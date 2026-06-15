package com.agenda.backend.controller;

import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.agenda.backend.model.Categoria;
import com.agenda.backend.model.Profissional_Saude;
import com.agenda.backend.repository.Profissional_SaudeRepository;

@RestController
@RequestMapping("/api/profissionais")
@CrossOrigin(origins = "*")
public class Profissional_saude {

    private final Profissional_SaudeRepository repository;

    public Profissional_saude(Profissional_SaudeRepository repository) {
        this.repository = repository;
    }

    // INSERIR(ID)
    @PostMapping("/{id}")
    public ResponseEntity<Profissional_Saude> inserir(
            @PathVariable Long id,
            @Valid @RequestBody Profissional_Saude profissional) {

        profissional.setId(id);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(repository.save(profissional));
    }


    // CONSULTAR(ID)
    @GetMapping("/{id}")
    public ResponseEntity<?> consultarPorId(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // CONSULTAR(NOME)
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Profissional_Saude>>
    consultarPorNome(@PathVariable String nome) {

        return ResponseEntity.ok(
                repository.findByNomeContainingIgnoreCase(nome));
    }


    // CONSULTAR(CATEGORIA)
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Profissional_Saude>>
    consultarPorCategoria(
            @PathVariable Categoria categoria) {

        return ResponseEntity.ok(
                repository.findByCategoria(categoria));
    }


    // ALTERAR(ID)
    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(
            @PathVariable Long id,
            @Valid @RequestBody Profissional_Saude dados) {

        return repository.findById(id)
                .map(profissional -> {

                    profissional.setNome(dados.getNome());
                    profissional.setTelefone(dados.getTelefone());
                    profissional.setEndereco(dados.getEndereco());
                    profissional.setCategoria(dados.getCategoria());

                    return ResponseEntity.ok(
                            repository.save(profissional));
                })
                .orElse(ResponseEntity.notFound().build());
    }


    //EXCLUIR(ID)

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(profissional -> {

                    repository.delete(profissional);

                    return ResponseEntity.ok(
                            Map.of("mensagem",
                                   "Profissional removido com sucesso"));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}