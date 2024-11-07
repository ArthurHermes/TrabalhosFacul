package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriarDB {

    public void criarBD(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_mercadinho"); // Nome da unidade de persistência
        EntityManager em = emf.createEntityManager();

        try {
            // Criando objetos das classes
            Cliente cliente = new Cliente();
            Funcionario funcionario = new Funcionario();
            Venda venda = new Venda();
            Produto produto = new Produto();
            Fornecedor fornecedor = new Fornecedor();

            // Iniciando a transação
            em.getTransaction().begin();

            // Persistindo os objetos
            em.persist(cliente);
            em.persist(funcionario);
            em.persist(venda);
            em.persist(produto);
            em.persist(fornecedor);

            // Cometendo a transação para salvar os dados no banco
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            
            em.close();
            emf.close();
        }
    }
}
