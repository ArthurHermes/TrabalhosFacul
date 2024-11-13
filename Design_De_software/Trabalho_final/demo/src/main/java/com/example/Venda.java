package com.example;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;

    private String cliente;
    
    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> produto = new ArrayList<>();
    private double totalVenda;
    private Date dataVenda;
    private String formaPagamento;
    private StatusVenda status;

    public enum StatusVenda {
        PENDENTE,
        CONCLUIDA,
        CANCELADA,
        EM_ANDAMENTO,
        DEVOLVIDA
    }

    // Construtor vazio para o JPA (obrigatório)
    public Venda() {
    }

    // Construtor com parâmetros
    public Venda(String cliente, List<String> produto, double totalVenda, String formaPagamento, StatusVenda status) {
        this.cliente = cliente;
        this.produto = produto;
        this.totalVenda = totalVenda;
        this.formaPagamento = formaPagamento;
        this.status = status;
    }

    // Getters e Setters
    public Long getIdVenda() {
        return idVenda;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<String> getProduto() {
        return produto;
    }

    public void setProduto(List<String> produto) {
        this.produto = produto;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public StatusVenda getStatus() {
        return status;
    }

    public void setStatus(StatusVenda status) {
        this.status = status;
    }
}
