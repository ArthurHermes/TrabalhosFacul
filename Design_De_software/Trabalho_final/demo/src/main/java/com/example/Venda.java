package com.example;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @ManyToMany
    @JoinTable(name = "venda_produto",
               joinColumns = @JoinColumn(name = "venda_id"),
               inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos = new ArrayList<>();

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
    public Venda(Cliente cliente, List<Produto> produtos, double totalVenda, String formaPagamento, StatusVenda status, Date dataVenda) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.totalVenda = totalVenda;
        this.dataVenda = dataVenda;
        this.formaPagamento = formaPagamento;
        this.status = status;
    }

    // Getters e Setters
    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
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
