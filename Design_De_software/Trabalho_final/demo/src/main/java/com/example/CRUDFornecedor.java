package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class CRUDFornecedor {
    
    public void adicionarFornecedor(String nome, String cpf, String endereco, String telefone, String email){
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try{
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
        }
    }
}
