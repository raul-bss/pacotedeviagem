package com.example.pacotedeviagem.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_pacote")
public class Pacote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String destino;
    private int quantidadeDias;

    @ManyToOne
    @JoinColumn(name = "transporte_id")
    private Transporte transporte;

    @ManyToOne
    @JoinColumn(name = "hospedagem_id")
    private Hospedagem hospedagem;

    public Pacote() {
    }

    public Pacote(Long id, String destino, int quantidadeDias) {
        this.id = id;
        this.destino = destino;
        this.quantidadeDias = quantidadeDias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }
}
