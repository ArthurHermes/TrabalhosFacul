package com.example;

import javax.persistence.*;
import java.util.List;

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

    public Cliente buscarClientePorEmail(String email) {
        EntityManager entityManager = null;

        try {
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");
            entityManager = emFactory.createEntityManager();

            // Consultando cliente pelo email
            String jpql = "SELECT c FROM Cliente c WHERE c.email = :email";
            TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
            query.setParameter("email", email);

            List<Cliente> clientes = query.getResultList(); // Usando getResultList() para evitar NoResultException

            // Verifica se algum cliente foi encontrado
            if (clientes.isEmpty()) {
                return null; // Retorna null se nenhum cliente for encontrado
            } else {
                return clientes.get(0); // Retorna o primeiro cliente encontrado
            }

        } catch (Exception e) {
            // Trata qualquer outro erro
            e.printStackTrace();
            return null;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
