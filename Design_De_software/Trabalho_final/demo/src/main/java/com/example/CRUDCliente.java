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

    public Cliente buscarClientePorEmail(String nome, S) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try{
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.email = :email");
            List<Cliente> results = query.getResultList();

            for(Cliente c: results){
                System.out.println("Usuarios    " + c.getNome());
            }
            entityManager.flush();
            transaction.commit();

        }catch(RuntimeException exception){
            if (transaction != null){
                try{
                    transaction.rollback();
                }catch (RuntimeException nestedException){
                }
            }
            throw exception;
        }finally{
            if (entityManager != null){
                entityManager.close();
            } 
        }
    }
}
