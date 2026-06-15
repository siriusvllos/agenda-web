package com.agenda.backend.controller;

import com.agenda.backend.model.Atendimento;
import com.agenda.backend.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atendimentos")
@CrossOrigin(origins = "*")
public class AtendimentoController {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    // 1. INSERIR (Criar um novo atendimento)
    @PostMapping
    public Atendimento inserir(@RequestBody Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    // 2. CONSULTAR (Listar todos os atendimentos)
    @GetMapping
    public List<Atendimento> consultarTodos() {
        return atendimentoRepository.findAll();
    }

    // 3. CONSULTAR POR ID (Buscar um atendimento específico)
    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> consultarPorId(@PathVariable Long id) {
        return atendimentoRepository.findById(id)
                .map(atendimento -> ResponseEntity.ok().body(atendimento))
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. ALTERAR (Atualizar os dados de um atendimento existente)
    @PutMapping("/{id}")
    public ResponseEntity<Atendimento> alterar(@PathVariable Long id, @RequestBody Atendimento atendimentoAtualizado) {
        return atendimentoRepository.findById(id)
                .map(atendimento -> {
                    atendimento.setData(atendimentoAtualizado.getData());
                    atendimento.setHorario(atendimentoAtualizado.getHorario());
                    atendimento.setTitulo(atendimentoAtualizado.getTitulo());
                    atendimento.setLinkVideoConferencia(atendimentoAtualizado.getLinkVideoConferencia());
                    Atendimento atualizado = atendimentoRepository.save(atendimento);
                    return ResponseEntity.ok().body(atualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    // 5. EXCLUIR (Remover um atendimento do sistema)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        return atendimentoRepository.findById(id)
                .map(atendimento -> {
                    atendimentoRepository.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}