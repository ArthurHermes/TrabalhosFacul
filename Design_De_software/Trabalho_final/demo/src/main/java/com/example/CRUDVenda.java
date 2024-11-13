package com.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.Date;

public class CRUDVenda {
    private final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");

    public void adicionarVenda(Cliente cliente, List<Produto> produtos, double totalVenda, Date dataVenda, String formaPagamento, Venda.StatusVenda status) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Venda venda = new Venda(cliente, produtos, totalVenda, dataVenda, formaPagamento, status);
            entityManager.persist(venda);
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

    public Venda buscarVendaPorId(Long idVenda) {
        EntityManager entityManager = null;
        Venda venda = null;

        try {
            entityManager = emFactory.createEntityManager();

            // Executa a consulta para buscar a venda pelo ID
            TypedQuery<Venda> query = entityManager.createQuery("SELECT v FROM Venda v WHERE v.idVenda = :idVenda", Venda.class);
            query.setParameter("idVenda", idVenda);
            List<Venda> results = query.getResultList();

            if (!results.isEmpty()) {
                venda = results.get(0);
                System.out.println("Venda encontrada: \n" + venda.getIdVenda() + ": " + venda.getCliente().getNome() + " ; " + venda.getProdutos() + " ; " + venda.getTotalVenda() + " ; " + venda.getFormaPagamento() + " ; " + venda.getStatus());
            } else {
                System.out.println("Nenhuma venda encontrada com o ID: " + idVenda);
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return venda;
    }

    public void editarVendaPorId(Long idVenda, Cliente cliente) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Venda venda = entityManager.find(Venda.class, idVenda);
            if (venda != null) {
                venda.setCliente(cliente);
                entityManager.merge(venda);
                transaction.commit();
            } else {
                System.out.println("Nenhuma venda encontrada com o ID: " + idVenda);
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

    public void excluirVendaPorCliente(Cliente cliente) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            TypedQuery<Venda> query = entityManager.createQuery("SELECT v FROM Venda v WHERE v.cliente = :cliente", Venda.class);
            query.setParameter("cliente", cliente);
            List<Venda> results = query.getResultList();

            if (!results.isEmpty()) {
                for (Venda venda : results) {
                    entityManager.remove(venda);
                }
                transaction.commit();
            } else {
                System.out.println("Nenhuma venda encontrada com o cliente: " + cliente.getNome());
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
