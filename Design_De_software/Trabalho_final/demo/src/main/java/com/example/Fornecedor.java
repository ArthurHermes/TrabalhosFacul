package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Fornecedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFornecedor;

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String produtosFornecidos;

    // Construtor vazio(obrigatório)
    public Fornecedor() {}

    // Construtor com todos os atributos, exceto o id
    public Fornecedor(String nome, String endereco, String telefone, String email, String produtosFornecidos) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.produtosFornecidos = produtosFornecidos;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProdutosFornecidos() {
        return produtosFornecidos;
    }

    public void setProdutosFornecidos(String produtosFornecidos) {
        this.produtosFornecidos = produtosFornecidos;
    }

}
