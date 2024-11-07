package com.example;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // Criação de EntityManagerFactory e EntityManager
        // EntityManagerFactory emf =
        // Persistence.createEntityManagerFactory("persistencia_mercadinho"); // nome da
        // unidade de persistência
        // EntityManager em = emf.createEntityManager();

        // // Criando um objeto Cliente
        // Cliente cliente = new Cliente("João Silva", "123.456.789-00", "Rua X, 123",
        // "1234-5678", "joao@exemplo.com");

        // //Criando um objeto Funcionario
        // Funcionario funcionario = new Funcionario("Ana Costa", "Analista de
        // Sistemas", 5500.00, "09:00 - 18:00", "(11) 91234-5678",
        // "ana.costa@exemplo.com");

        // //Criando a lista para pssar no objeto
        // List<String> produtos = Arrays.asList("Arroz", "Feijão", "Macarrão");
        // // Criando um objeto Venda
        // Venda venda = new Venda("João Silva", produtos, 10.0, "Dinheiro",
        // Venda.StatusVenda.CONCLUIDA);

        // // Criando um objeto Produto
        // Date dataValidade = Date.valueOf("2025-12-31");
        // Produto produto = new Produto("Arroz", "Arroz tipo 1", 10.0, 100, "Alimento",
        // dataValidade);

        // //Criando um objeto Fornecedor
        // Fornecedor fornecedor = new Fornecedor( "Fornecedor 1", "Rua Y, 456",
        // "9876-5432", "fornecedor1@gmail.com", "Arroz, Feijão, Macarrão");

        // // Iniciando uma transação
        // em.getTransaction().begin();

        // // Persistindo o objeto
        // em.persist(cliente);
        // em.persist(funcionario);
        // em.persist(venda);
        // em.persist(produto);
        // em.persist(fornecedor);

        // // Cometendo a transação para salvar os dados no banco
        // em.getTransaction().commit();

        // // Fechando o EntityManager e EntityManagerFactory
        // em.close();
        // emf.close();

        CRUDCliente crudCliente = new CRUDCliente();
        //crudCliente.adicionarCliente("Maria Silva", "987.654.321-00", "Rua Y, 456", "9876-5432", "mariasilva@gmail.com");

        crudCliente.buscarCliente("987.654.321-00");
        
        // crudCliente.atualizarCliente("Maria Silva", "987.654.321-00", "Rua Y, 456",
        // "9876-5432", "maria123@gmail.com");

    }
}
