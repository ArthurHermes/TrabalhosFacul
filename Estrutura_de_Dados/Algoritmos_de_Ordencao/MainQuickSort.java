public class MainQuickSort {
    public static void main(String[] args) {

        long tempoInicio = System.currentTimeMillis();

        LerCSV leitor = new LerCSV("csv\\aleatorio_10000.csv");
        
        int[] numeros = leitor.lerNumeros();

        QuickSort ordenador = new QuickSort(numeros);
        
        ordenador.ordenar();

        ordenador.exibirVetor("Valores ordenado:");

        long tempoFim = System.currentTimeMillis();

        System.out.println("Tempo de execução: " + (tempoFim - tempoInicio) + " Milisegundos");
        System.out.println("Tempo de execução: " + ((tempoFim - tempoInicio) / 1000) + " Segundos");
    }
}
