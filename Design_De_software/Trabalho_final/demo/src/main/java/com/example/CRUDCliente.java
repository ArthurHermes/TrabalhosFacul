package com.example;

import javax.persistence.*;
import java.util.List;

public class CRUDCliente {

    // Adicionar Cliente
    public void adicionarCliente(String nome, String cpf, String endereco, String telefone, String email) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            // Criando o EntityManager e iniciando a transação
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Criando o cliente e persistindo
            Cliente cliente = new Cliente(nome, cpf, endereco, telefone, email);
            entityManager.persist(cliente);

            // Commit da transação para garantir que as alterações sejam salvas
            transaction.commit();

        } catch (RuntimeException exception) {
            // Se ocorrer uma exceção, faz o rollback
            if (transaction != null && transaction.isActive()) {
                try {
                    transaction.rollback();
                } catch (RuntimeException nestedException) {
                    // Tratar erros de rollback, se necessário
                }
            }
            throw exception;  // Relançar a exceção para tratamento externo, caso necessário
        } finally {
            // Fechar o EntityManager após a operação
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    // Buscar Cliente
    public void buscarCliente(String cpf) {
        EntityManager entityManager = null;

        try {
            // Criando o EntityManager
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");
            entityManager = emFactory.createEntityManager();

            // Criando a consulta para buscar o cliente pelo CPF
            Query query = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf");
            query.setParameter("cpf", cpf);
            List<Cliente> results = query.getResultList();

            // Exibindo os resultados
            if (results.isEmpty()) {
                System.out.println("Cliente não encontrado!");
            } else {
                for (Cliente c : results) {
                    System.out.println("Nome: " + c.getNome());
                    System.out.println("CPF: " + c.getCpf());
                    System.out.println("Endereço: " + c.getEndereco());
                    System.out.println("Telefone: " + c.getTelefone());
                    System.out.println("Email: " + c.getEmail());
                }
            }
        } catch (RuntimeException e) {
            throw e;  // Relançar exceções para tratamento externo, se necessário
        } finally {
            // Fechar o EntityManager após a operação
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
