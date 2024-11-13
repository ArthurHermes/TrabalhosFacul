package com.example;

import java.text.ParseException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) throws ParseException {

        // Inicializa o EntityManagerFactory, o que irá criar as tabelas no banco de dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_mercadinho");

        // Fecha o EntityManagerFactory depois da criação das tabelas
        emf.close();
    


        // CRUDS dos cliente

        //CRUDCliente cliente = new CRUDCliente();

        //cliente.adicionarCliente("Teste", "123.456.789-00", "Rua A, 222", "41 9 9999-9999", "Teste@gmail.com");
        

        // cliente.buscarClientePorCpf("123.456.789-00");






        //CRUDS do funcionario

        //CRUDFuncionario funcionario = new CRUDFuncionario();

        //funcionario.adicionarfuncionario("Júlio Santos","398.751.218-37","Analista de Sistemas",5200.0,"09:00 - 18:00","(11) 98765-4321","julio.santos@email.com");

        //funcionario.buscarFuncionarioPorCpf("398.751.218-37");


        //funcionario.excluirFuncionarioPorCpf("398.751.218-37");

        //funcionario.editarFuncionarioPorCpf("398.751.218-37", "Arthur Silva", "Analyst", 75321.45, "arthur123@mail.com", "+1-541-827-3064");


        //CRUDFornecedor fornecedor = new CRUDFornecedor();

        //fornecedor.adicionarfuncionario("João Silva", "Rua das Flores, 123, Bairro Centro, São Paulo, SP", "(11) 98765-4321", "joao.silva@email.com", "Computadores, Periféricos, Impressoras, Acessórios de Tecnologia");
        
        //fornecedor.buscaFornecedorPorNome("João Silva");

        //fornecedor.editarFornecedorPorNome("João Silva", "Rua das Flores, 345, Bairro Centro, São Paulo, SP", "(11) 98765-4321", "joao.silva@email.com", "Computadores, Periféricos, Impressoras, Acessórios de Tecnologia");
        
        //fornecedor.excluirFornecedorPorNome("Joâo Silva");



        //CRUDProduto produto = new CRUDProduto();

        // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // java.util.Date utilDate = sdf.parse("30/12/2025");
        // java.sql.Date dataValidade = new java.sql.Date(utilDate.getTime());
        // produto.adicionarProduto("Smartphone X10", "Smartphone com tela de 6,5 polegadas, câmera de 48MP e bateria de 4000mAh.", 1999.99, 50, "Eletrônicos", dataValidade);

        //produto.buscarProdutoPorNome("Smartphone X10");

        // SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        // java.util.Date utilDate = sdf2.parse("30/12/2025");
        // java.sql.Date dataValidade = new java.sql.Date(utilDate.getTime());
        // produto.editarProdutoPorNome("Smartphone X10", "Computador Dell Inspiron 15 3000", 2500.0, 10, "Computadores", dataValidade);

        //produto.excluirProdutoPorNome("Smartphone X10");



        // CRUDVenda venda = new CRUDVenda();

        // Cliente clientebusca = cliente.buscarClientePorCpf("123.456.789-00");


        // Setting up the date for dataVenda2
        // SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        // java.util.Date utilDate2 = sdf2.parse("30/12/2025");
        // java.sql.Date dataVenda2 = new java.sql.Date(utilDate2.getTime());

        // Creating the list of products
        // List<Produto> produtos = Arrays.asList(produto.buscarProdutoPorNome("Smartphone X10"));

        // Adding the sale
        // venda.adicionarVenda(clientebusca, produtos, 1999.99, "Dinheiro", Venda.StatusVenda.PENDENTE, dataVenda2);

        
        //venda.buscarVendaPorCpfCliente("123.456.789-00");

        //venda.editarVendaPorNomeCliente(1l, "123.456.789-00");

        //venda.excluirVendaPorCliente("123.456.789-00");


    }
}
