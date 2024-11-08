package com.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        // Inicializa o EntityManagerFactory, o que irá criar as tabelas no banco de dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_mercadinho");

        // Fecha o EntityManagerFactory depois da criação das tabelas
        emf.close();
    


        CRUDCliente cliente = new CRUDCliente();

        cliente.adicionarCliente("Teste", "123.456.789-00", "Rua A, 222", "41 9 9999-9999", "Teste@gmail.com");
        

        cliente.buscarClientePorCpf("123.456.789-00");

    }
}
