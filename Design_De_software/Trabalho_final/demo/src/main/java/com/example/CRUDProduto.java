package com.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.Date;




public class CRUDProduto {
    private final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");

    public void adicionarProduto(String nome, String descricao, double preco, int quantidadeEstoque, String categoria, Date dataValidade)
    
    {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Produto produto = new Produto(nome, descricao, preco, quantidadeEstoque, categoria, dataValidade);
            entityManager.persist(produto);
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

    public Produto buscarProdutoPorNome(String nome) {
        EntityManager entityManager = null;
        Produto produto = null;

        try {
            entityManager = emFactory.createEntityManager();

            // Executa a consulta para buscar o produto pelo nome
            TypedQuery<Produto> query = entityManager.createQuery("SELECT p FROM Produto p WHERE p.nome = :nome", Produto.class);
            query.setParameter("nome", nome);
            List<Produto> results = query.getResultList();

            if (!results.isEmpty()) {
                produto = results.get(0);
                System.out.println("Produto encontrado: \n" + produto.getIdProduto() + ": " + produto.getNome() + " ; " + produto.getDescricao() + " ; " + produto.getPreco() + " ; " + produto.getQuantidadeEstoque() + " ; " + produto.getCategoria() + " ; " + produto.getDataValidade());
            } else {
                System.out.println("Nenhum produto encontrado com o nome: " + nome);
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return produto;
    }

    public void editarProdutoPorNome(String nome, String descricao, double preco, int quantidadeEstoque, String categoria, Date dataValidade) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Produto produto = buscarProdutoPorNome(nome);
            if (produto != null) {
                produto.setDescricao(descricao);
                produto.setPreco(preco);
                produto.setQuantidadeEstoque(quantidadeEstoque);
                produto.setCategoria(categoria);
                produto.setDataValidade(dataValidade);
                entityManager.merge(produto);
                transaction.commit();
                System.out.println("Produto editado com sucesso!");
            } else {
                System.out.println("Produto não encontrado!");
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

    public void excluirProdutoPorNome(String nome) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Produto produto = buscarProdutoPorNome(nome);
            if (produto != null) {
                entityManager.remove(produto);
                transaction.commit();
                System.out.println("Produto excluído com sucesso!");
            } else {
                System.out.println("Produto não encontrado!");
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
