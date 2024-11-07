package com.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class CRUDCliente {

    private final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");

    public void adicionarCliente(String nome, String cpf, String endereco, String telefone, String email) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Cliente cliente = new Cliente(nome, cpf, endereco, telefone, email);
            entityManager.persist(cliente);
            transaction.commit();

        } catch (RuntimeException exception) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw exception;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public Cliente buscarClientePorCpf(String cpf) {
        EntityManager entityManager = null;
        Cliente cliente = null;
    
        try {
            entityManager = emFactory.createEntityManager();
            
            // Executa a consulta para buscar o cliente pelo CPF
            TypedQuery<Cliente> query = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf", Cliente.class);
            query.setParameter("cpf", cpf);
            List<Cliente> results = query.getResultList();
    
            if (!results.isEmpty()) {
                cliente = results.get(0);
                System.out.println("Usuário encontrado: " + cliente.getNome());
            } else {
                System.out.println("Nenhum usuário encontrado com o CPF: " + cpf);
            }
    
        } catch (RuntimeException e) {
            System.out.println(e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    
        return cliente;
    }
    
    
    
    
}
