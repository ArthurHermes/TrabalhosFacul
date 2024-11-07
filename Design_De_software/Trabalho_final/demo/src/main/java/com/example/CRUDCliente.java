package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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

}
