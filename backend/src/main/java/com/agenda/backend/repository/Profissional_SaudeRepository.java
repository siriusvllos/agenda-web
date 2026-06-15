package com.agenda.backend.repository;

import com.agenda.backend.model.Categoria;
import com.agenda.backend.model.Profissional_Saude;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfissionalSaudeRepository
        extends JpaRepository<Profissional_Saude, Long> {

    List<Profissional_Saude> findByNomeContainingIgnoreCase(String nome);

    List<Profissional_Saude> findByCategoria(Categoria categoria);
}