package com.example.pacotedeviagem.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "tb_venda")
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;
    private String formaPagamento;
    private Instant dataVenda;



    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Pacote_id", referencedColumnName = "id"),
            @JoinColumn(name = "Pacote_Transporte_id", referencedColumnName = "transporte_id"),
            @JoinColumn(name = "Pacote_Hospedagem_id", referencedColumnName = "hospedagem_id")
    })
    private Pacote pacote;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "relatorio_id")
    private Relatorio relatorio;

    public Venda (){

    }

    public Venda(Long id, String nomeCliente, String formaPagamento, Instant dataVenda, Pacote pacote) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.formaPagamento = formaPagamento;
        this.dataVenda = dataVenda;
        this.pacote = pacote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Instant getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Instant dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }
}
