package com.example.pacotedeviagem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_pacote")
public class Pacote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String destino;
    private int quantidadeDias;
    private Double margemLucro;
    private Double taxasAdcionais;
    private Double cotacaoDolar;

    @OneToMany(mappedBy = "pacote")
    private List<Venda> venda = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "transporte_id")
    private Transporte transporte;


    @ManyToOne
    @JoinColumn(name = "hospedagem_id")
    private Hospedagem hospedagem;


    public Pacote() {

    }

    public Pacote(String destino, int quantidadeDias, Double margemLucro, Double taxasAdcionais,Double cotacaoDolar, Transporte transporte, Hospedagem hospedagem) {
        this.destino = destino;
        this.quantidadeDias = quantidadeDias;
        this.margemLucro = margemLucro;
        this.taxasAdcionais = taxasAdcionais;
        this.transporte = transporte;
        this.hospedagem = hospedagem;
        this.cotacaoDolar = cotacaoDolar;
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

    public Double getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(Double margemLucro) {
        this.margemLucro = margemLucro;
    }

    public Double getTaxasAdcionais() {
        return taxasAdcionais;
    }

    public void setTaxasAdcionais(Double taxasAdcionais) {
        this.taxasAdcionais = taxasAdcionais;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public Double getCotacaoDolar() {
        return cotacaoDolar;
    }

    public void setCotacaoDolar(Double cotacaoDolar) {
        this.cotacaoDolar = cotacaoDolar;
    }


}
