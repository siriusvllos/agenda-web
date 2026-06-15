package com.agenda.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "atendimentos")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private LocalTime horario;

    @Column(nullable = false)
    private String titulo;

    private String linkVideoConferencia;

    // TODO: Criar a relação @OneToMany com a classe Receita futuramente

    // Construtor vazio (obrigatório para o JPA)
    public Atendimento() {
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public LocalTime getHorario() { return horario; }
    public void setHorario(LocalTime horario) { this.horario = horario; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getLinkVideoConferencia() { return linkVideoConferencia; }
    public void setLinkVideoConferencia(String linkVideoConferencia) { this.linkVideoConferencia = linkVideoConferencia; }
}