package com.example;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeEstoque;
    private String categoria;
    private Date dataValidade;

    //Construtor vazio(obrigatorio)
    public Produto(){}

    //Construtor
    public Produto(String nome, String descricao, double preco, int quantidadeEstoque, String categoria, Date dataValidade){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
        this.dataValidade = dataValidade;

    }

    //Getters
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    //Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }
}
