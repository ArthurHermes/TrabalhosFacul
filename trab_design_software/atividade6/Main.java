package atividade6;

public class Main {
    public static void main(String[] args) {
        Configuracao config1 = Configuracao.getInstancia();
        Configuracao config2 = Configuracao.getInstancia();
        Configuracao config3 = Configuracao.getInstancia();

        System.out.println("Ambiente config1: " + config1.getAmbiente());
        System.out.println("Porta config1: " + config1.getPorta());

        System.out.println("Ambiente config2: " + config2.getAmbiente());
        System.out.println("Porta config2: " + config2.getPorta());

        System.out.println("Ambiente config3: " + config3.getAmbiente());
        System.out.println("Porta config3: " + config3.getPorta());

        // Imprime a representação da instância usando o método toString()
        System.out.println("Configuração: " + config1);
    }
}
