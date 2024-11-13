package com.example;

import java.util.List;
import javax.persistence.*;

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

    @ManyToMany(mappedBy = "fornecedores")
    private List<Produto> produtos;

    // Construtores, getters e setters

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

    public Long getIdFornecedor() {
        return idFornecedor;
    }

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
