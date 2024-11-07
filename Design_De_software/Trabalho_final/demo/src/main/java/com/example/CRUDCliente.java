package com.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CRUDCliente {

    // Adicionar Cliente
    public void adicionarCliente(String nome, String cpf, String endereco, String telefone, String email) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Cliente cliente = new Cliente(nome, cpf, endereco, telefone, email);
            entityManager.persist(cliente);
            entityManager.flush();
            transaction.commit();

        } catch (RuntimeException exception) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (RuntimeException nestedException) {
                }
            }
            throw exception;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void buscarCliente(String cpf) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
    
        try {
    
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
    
            Query query = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf");
            query.setParameter("cpf", cpf);  // Certifique-se de passar o parâmetro cpf para a query
            List<Cliente> results = query.getResultList();
    
            for (Cliente c : results) {
                System.out.println("Nome: " + c.getNome());
                System.out.println("CPF: " + c.getCpf());
                System.out.println("Endereço: " + c.getEndereco());
                System.out.println("Telefone: " + c.getTelefone());
                System.out.println("Email: " + c.getEmail());
            }
    
            entityManager.flush();
            transaction.commit();
    
        } catch (RuntimeException e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (RuntimeException nestedException) {
                    // Tratar o erro de rollback, se necessário
                }
            }
            throw e;  // Corrigido aqui para lançar a exceção corretamente
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    

}
