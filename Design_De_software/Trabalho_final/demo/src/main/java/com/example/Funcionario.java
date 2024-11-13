package com.example;

import java.util.List;
import javax.persistence.*;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    private String nome;
    private String cpf;
    private String cargo;
    private double salario;
    private String horarioTrabalho;
    private String telefone;
    private String email;

    @ManyToMany(mappedBy = "funcionarios")
    private List<Cliente> clientes;

    // Construtores, getters e setters

    //Construtor vazio(obrigatorio)
    public Funcionario(){

    }

    //Construtor
    public Funcionario(String nome, String cpf, String cargo, double salario, String horarioTrabalho, String telefone, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.salario = salario;
        this.horarioTrabalho = horarioTrabalho;
        this.telefone = telefone;
        this.email = email;
    }

    //Getters

    public Long getIdFuncionario(){
        return idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public String getHorarioTrabalho() {
        return horarioTrabalho;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    //Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }



    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setHorarioTrabalho(String horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
