package com.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class CRUDFornecedor {
    private final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");

    public void adicionarfuncionario(String nome, String endereco, String telefone, String email, String produtosFornecidos) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Fornecedor fornecedor = new Fornecedor(nome, endereco, telefone, email, produtosFornecidos);
            entityManager.persist(fornecedor);
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

    public Fornecedor buscaFornecedorPorNome(String nome) {
        EntityManager entityManager = null;
        Fornecedor fornecedor = null;

        try {
            entityManager = emFactory.createEntityManager();

            // Executa a consulta para buscar o fornecedor pelo nome
            TypedQuery<Fornecedor> query = entityManager.createQuery("SELECT f FROM Fornecedor f WHERE f.nome = :nome", Fornecedor.class);
            query.setParameter("nome", nome);
            List<Fornecedor> results = query.getResultList();

            if (!results.isEmpty()) {
                fornecedor = results.get(0);
                System.out.println("Fornecedor encontrado: \n" + fornecedor.getIdFornecedor() + ": " + fornecedor.getNome() + " ; " + fornecedor.getEndereco() + " ; " + fornecedor.getTelefone() + " ; " + fornecedor.getEmail() + " ; " + fornecedor.getProdutosFornecidos());
            } else {
                System.out.println("Nenhum fornecedor encontrado com o nome: " + nome);
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return fornecedor;
    }

    public void editarFornecedorPorNome(String nome, String endereco, String telefone, String email, String produtosFornecidos) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Fornecedor fornecedor = buscaFornecedorPorNome(nome);
            if (fornecedor != null) {
                fornecedor.setEndereco(endereco);
                fornecedor.setTelefone(telefone);
                fornecedor.setEmail(email);
                fornecedor.setProdutosFornecidos(produtosFornecidos);
                entityManager.merge(fornecedor);
                transaction.commit();
            } else {
                System.out.println("Nenhum fornecedor encontrado com o nome: " + nome);
            }
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

    public void excluirFornecedorPorNome(String nome) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
    
        try {
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
    
            // Busca o fornecedor diretamente no contexto atual do EntityManager
            TypedQuery<Fornecedor> query = entityManager.createQuery("SELECT f FROM Fornecedor f WHERE f.nome = :nome", Fornecedor.class);
            query.setParameter("nome", nome);
            List<Fornecedor> results = query.getResultList();
    
            if (!results.isEmpty()) {
                Fornecedor fornecedor = results.get(0);
                entityManager.remove(fornecedor);
                transaction.commit();
            } else {
                System.out.println("Nenhum fornecedor encontrado com o nome: " + nome);
            }
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
    


}
