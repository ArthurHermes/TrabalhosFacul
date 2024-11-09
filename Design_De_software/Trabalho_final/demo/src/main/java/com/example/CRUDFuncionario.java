package com.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class CRUDFuncionario {
    private final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistencia_mercadinho");
    
    public void adicionarfuncionario(String nome, String cpf, String cargo, double salario, String horarioTrabalho, String telefone, String email) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = emFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Funcionario funcionario = new Funcionario(nome, cpf, cargo, salario, horarioTrabalho, telefone, email);
            entityManager.persist(funcionario);
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
    
    
    
    
    public Funcionario buscarFuncionarioPorCpf(String cpf) {
        EntityManager entityManager = null;
        Funcionario funcionario = null;
    
        try {
            entityManager = emFactory.createEntityManager();
            
            // Executa a consulta para buscar o funcionario pelo CPF
            TypedQuery<Funcionario> query = entityManager.createQuery("SELECT c FROM Funcionario c WHERE c.cpf = :cpf", Funcionario.class);
            query.setParameter("cpf", cpf);
            List<Funcionario> results = query.getResultList();
    
            if (!results.isEmpty()) {
                funcionario = results.get(0);
                System.out.println("Funcionario encontrado: \n" + funcionario.getIdFuncionario() + " , " + funcionario.getNome() + " , " + funcionario.getCargo() + " , " + funcionario.getHorarioTrabalho() + " , " + funcionario.getSalario());
            } else {
                System.out.println("Nenhum funcionario encontrado com o CPF: " + cpf);
            }
    
        } catch (RuntimeException e) {
            System.out.println(e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    
        return funcionario;
    }
}
