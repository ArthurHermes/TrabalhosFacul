package com.example;

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

<<<<<<< Updated upstream
=======
    // Atualizar Cliente
    public void atualizarCliente(String nome, String cpf, String endereco, String telefone, String email) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Cliente cliente = buscarClientePorCpf(cpf);
            if (cliente != null) {
                cliente.setNome(nome);
                cliente.setEndereco(endereco);
                cliente.setTelefone(telefone);
                cliente.setEmail(email);
                entityManager.merge(cliente);
                entityManager.flush();
                transaction.commit();
            } else {
                throw new RuntimeException("Cliente com CPF " + cpf + " não encontrado.");
            }

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

    // Remover Cliente
    public void removerCliente(String cpf) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Cliente cliente = buscarClientePorCpf(cpf); // Busca cliente por CPF
            if (cliente != null) {
                entityManager.remove(cliente);
                entityManager.flush();
                transaction.commit();
            } else {
                throw new RuntimeException("Cliente com CPF " + cpf + " não encontrado.");
            }

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

    // Buscar Cliente por CPF
    public Cliente buscarClientePorCpf(String cpf) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            // Criar o EntityManager e iniciar a transação
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");
            entityManager = emFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Cliente c = entityManager.find(Cliente.class, 1);

            // Criar a consulta para buscar o cliente pelo CPF
            // Query query = entityManager.createQuery("select c from cliente c where c.cpf
            // = :cpf");
            // query.setParameter("cpf", cpf);

            // Retornar o resultado da consulta (se houver)
            return c; // (Cliente) query.getSingleResult();

        } catch (NoResultException e) {
            // Caso não encontre nenhum cliente com esse CPF, logando o erro
            System.out.println("Cliente com CPF " + cpf + " não encontrado.");
            return null; // Retorna null se o cliente não for encontrado

        } catch (RuntimeException e) {
            try {
                transaction.rollback();
                return null;
            } catch (RuntimeException nestedException) {
                return null;
            }
        } catch (Exception e) {
            // Logando qualquer outro erro inesperado
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
            return null; // Retorna null em caso de erro

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

>>>>>>> Stashed changes
}
