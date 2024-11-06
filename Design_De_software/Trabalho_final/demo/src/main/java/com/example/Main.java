package com.example;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // Criação de EntityManagerFactory e EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit"); // nome da unidade de persistência
        EntityManager em = emf.createEntityManager();

        // Criando um objeto Cliente
        Cliente cliente = new Cliente("João Silva", "123.456.789-00", "Rua X, 123", "1234-5678", "joao@exemplo.com");

        // Iniciando uma transação
        em.getTransaction().begin();
        
        // Persistindo o objeto
        em.persist(cliente);

        // Cometendo a transação para salvar os dados no banco
        em.getTransaction().commit();
        
        // Fechando o EntityManager e EntityManagerFactory
        em.close();
        emf.close();
    }
}
