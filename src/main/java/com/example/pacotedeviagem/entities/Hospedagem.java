package com.example.pacotedeviagem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_hospedagem")
public class Hospedagem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descricao;
    private Double valor;

    @JsonIgnore
    @OneToMany(mappedBy = "hospedagem")
    private List<Pacote> pacote = new ArrayList<>();

    

    public Hospedagem() {
    }

    public Hospedagem(Long id, String descricao, Double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
