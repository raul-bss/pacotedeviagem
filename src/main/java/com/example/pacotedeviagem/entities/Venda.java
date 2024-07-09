package com.example.pacotedeviagem.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;
    private String formaPagamento;
    private Date dataVenda;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Pacote_id", referencedColumnName = "id"),
            @JoinColumn(name = "Pacote_Transporte_id", referencedColumnName = "Transporte_id"),
            @JoinColumn(name = "Pacote_Hospedagem_id", referencedColumnName = "Hospedagem_id")
    })
    private Pacote pacote;

    public Venda (){

    }

    public Venda(Long id, String nomeCliente, String formaPagamento, Date dataVenda, Pacote pacote) {
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

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }
}
