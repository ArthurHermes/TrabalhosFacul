package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CRUDCliente {

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

    public void atualizarCliente(Long idCliente, String nome, String cpf, String endereco, String telefone, String email) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Cliente cliente = entityManager.find(Cliente.class, idCliente);
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setEndereco(endereco);
            cliente.setTelefone(telefone);
            cliente.setEmail(email);
            entityManager.merge(cliente);
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

    public void removerCliente(Long idCliente) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Cliente cliente = entityManager.find(Cliente.class, idCliente);
            entityManager.remove(cliente);
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

    public Cliente buscarCliente(Long idCliente) {
        EntityManager entityManager = null;

        try {
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");
            entityManager = emFactory.createEntityManager();

            return entityManager.find(Cliente.class, idCliente);

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

}
