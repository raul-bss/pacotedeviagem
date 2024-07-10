package com.example.pacotedeviagem.entities;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_relatorio")
public class Relatorio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "venda_id")
    private Venda venda;

    private String nomeCliente;
    private String formaDePagamento;
    private Instant dataDaVenda;

    private Double totalUsd;
    private Double totalUsdComTaxas;
    private Double lucro;
    private Double totalBrl;

    private String descricaoHospedagem;
    private Double valorHospedagem;

    private String tipoTransporte;
    private Double valorTransporte;

    private String destino;
    private Integer quantidadeDeDias;

    public Double valorPacoteReais(){
        Double valorReal = totalUsdComTaxas * venda.getPacote().getCotacaoDolar();
        return valorReal;

    }

    public Double valorTotalHospedagem(){
        Double valorHospedagem = venda.getPacote().getHospedagem().getValor() * venda.getPacote().getQuantidadeDias();
        return valorHospedagem;
    }

    public Double valorPacote(){
        return valorTotalHospedagem()+venda.getPacote().getTransporte().getValor();
    }

    public Double calcularLucro(Double margemLucro, Double taxaAdcional){
        Double total = (valorPacote()*(margemLucro/100)) + taxaAdcional + valorPacote();
        Double lucro = total - valorPacote();
        return lucro;
    }
    /*
    public Double calcularValorComTaxa(){
        Double total = valorPacote() + venda.getPacote().getLucro();

        return total;
    }
    */
    public Relatorio() {
    }

    public Relatorio(Venda venda) {
        this.venda = venda;

        this.nomeCliente =venda.getNomeCliente();
        this.formaDePagamento = venda.getFormaPagamento();
        this.dataDaVenda = venda.getDataVenda();
        this.descricaoHospedagem = venda.getPacote().getHospedagem().getDescricao();
        this.valorHospedagem = venda.getPacote().getHospedagem().getValor();
        this.tipoTransporte = venda.getPacote().getTransporte().getTipo();
        this.valorTransporte = venda.getPacote().getTransporte().getValor();
        this.destino = venda.getPacote().getDestino();
        this.quantidadeDeDias = venda.getPacote().getQuantidadeDias();
        this.totalUsd = valorPacote();
        this.totalUsdComTaxas = valorPacote() + calcularLucro(venda.getPacote().getMargemLucro(), venda.getPacote().getTaxasAdcionais());
        this.lucro = calcularLucro(venda.getPacote().getMargemLucro(), venda.getPacote().getTaxasAdcionais());
        this.totalBrl = valorPacoteReais();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public Instant getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(Instant dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    public Double getTotalUsd() {
        return totalUsd;
    }

    public void setTotalUsd(Double totalUsd) {
        this.totalUsd = totalUsd;
    }

    public Double getTotalUsdComTaxas() {
        return totalUsdComTaxas;
    }

    public void setTotalUsdComTaxas(Double totalUsdComTaxas) {
        this.totalUsdComTaxas = totalUsdComTaxas;
    }

    public Double getLucro() {
        return lucro;
    }

    public void setLucro(Double lucro) {
        this.lucro = lucro;
    }

    public String getDescricaoHospedagem() {
        return descricaoHospedagem;
    }

    public void setDescricaoHospedagem(String descricaoHospedagem) {
        this.descricaoHospedagem = descricaoHospedagem;
    }

    public Double getValorHospedagem() {
        return valorHospedagem;
    }

    public void setValorHospedagem(Double valorHospedagem) {
        this.valorHospedagem = valorHospedagem;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public Double getValorTransporte() {
        return valorTransporte;
    }

    public void setValorTransporte(Double valorTransporte) {
        this.valorTransporte = valorTransporte;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Integer getQuantidadeDeDias() {
        return quantidadeDeDias;
    }

    public void setQuantidadeDeDias(Integer quantidadeDeDias) {
        this.quantidadeDeDias = quantidadeDeDias;
    }

    public Double getTotalBrl() {
        return totalBrl;
    }

    public void setTotalBrl(Double totalBrl) {
        this.totalBrl = totalBrl;
    }
}


