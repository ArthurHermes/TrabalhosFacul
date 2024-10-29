public class MainBubbleSort {
    public static void main(String[] args) {

        long tempoInicio = System.currentTimeMillis();

        LerCSV leitor = new LerCSV("csv\\aleatorio_10000.csv");
        
        int[] numeros = leitor.lerNumeros();

        BubbleSort bubbleSort = new BubbleSort(numeros);

        bubbleSort.ordenar();

        bubbleSort.exibirVetor("Ordenado:");

        long tempoFim = System.currentTimeMillis();

        System.out.println("Tempo de execução: " + (tempoFim - tempoInicio) + " Milisegundos");
        System.out.println("Tempo de execução: " + ((tempoFim - tempoInicio) / 1000) + " Segundos");
    }
}
