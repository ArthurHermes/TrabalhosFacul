package com.example;

public class Main {
    public static void main(String[] args) {
        CriarDB bd = new CriarDB();
        bd.criarBD(); 


        CRUDCliente cliente = new CRUDCliente();

        //cliente.adicionarCliente("Teste", "123.456.789-00", "Rua A, 222", "41 9 9999-9999", "Teste@gmail.com");
        

        cliente.buscarClientePorCpf("123.456.789-00");

    }
}
