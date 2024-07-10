package com.example.pacotedeviagem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_transporte")
public class Transporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tipo;
    private Double valor;

    @JsonIgnore
    @OneToMany(mappedBy = "transporte")
    private List<Pacote> pacote = new ArrayList<>();

    public Transporte() {
    }

    public Transporte(Long id, String tipo, Double valor) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Pacote> getPacote() {
        return pacote;
    }
}
