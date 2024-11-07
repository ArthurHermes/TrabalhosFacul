package com.example;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;

    private String cliente;
    private List<String> produto = new ArrayList<>();
    private double totalVenda;
    private Date dataVenda;
    private String formaPagamento;
    private enum StatusVenda {
        PENDENTE,
        CONCLUIDA,
        CANCELADA,
        EM_ANDAMENTO,
        DEVOLVIDA
    };

    
    
}
