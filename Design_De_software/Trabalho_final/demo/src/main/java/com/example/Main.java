package com.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        // Inicializa o EntityManagerFactory, o que irá criar as tabelas no banco de dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_mercadinho");

        // Fecha o EntityManagerFactory depois da criação das tabelas
        emf.close();
    


        // CRUDS dos cliente

        // CRUDCliente cliente = new CRUDCliente();

        // cliente.adicionarCliente("Teste", "123.456.789-00", "Rua A, 222", "41 9 9999-9999", "Teste@gmail.com");
        

        // cliente.buscarClientePorCpf("123.456.789-00");






        // CRUDS do funcionario

        //CRUDFuncionario funcionario = new CRUDFuncionario();

        //funcionario.adicionarfuncionario("Júlio Santos","398.751.218-37","Analista de Sistemas",5200.0,"09:00 - 18:00","(11) 98765-4321","julio.santos@email.com");

        //funcionario.buscarFuncionarioPorCpf("398.751.218-37");


        //funcionario.excluirFuncionarioPorCpf("398.751.218-37");

        //funcionario.editarFuncionarioPorCpf("398.751.218-37", "Arthur Silva", "Analyst", 75321.45, "arthur123@mail.com", "+1-541-827-3064");
    }
}
