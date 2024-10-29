public class QuickSort {
    private int[] vetor;

    // Construtor para inicializar o vetor com valores específicos
    public QuickSort(int[] vetor) {
        this.vetor = vetor;
    }

    // Método que implementa o QuickSort
    public void ordenar() {
        quickSort(0, vetor.length - 1);
    }

    // Método recursivo do QuickSort
    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separarPosicionarPivo(inicio, fim);
            quickSort(inicio, posicaoPivo - 1);
            quickSort(posicaoPivo + 1, fim);
        }
    }

    // Método auxiliar para separar e posicionar o pivô
    private int separarPosicionarPivo(int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1;
        int f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo) {
                i++;
            } else if (pivo < vetor[f]) {
                f--;
            } else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }

    // Método para exibir o vetor
    public void exibirVetor(String mensagem) {
        System.out.print(mensagem);
        for (int valor : vetor) {
            System.out.print(" " + valor);
        }
        System.out.println();
    }

    // Método para medir e exibir o tempo de execução da ordenação
    public void medirTempoExecucao() {
        long tempoInicial = System.currentTimeMillis();

        ordenar();

        long tempoFinal = System.currentTimeMillis();
        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
    }

    // Método principal para rodar o programa
    public static void main(String[] args) {
        int[] vetor = {7, 3, 5, 8, 2, 9, 4, 15, 6}; // Valores específicos

        QuickSort ordenador = new QuickSort(vetor);

        ordenador.exibirVetor("Vetor desordenado:");
        ordenador.medirTempoExecucao();
        ordenador.exibirVetor("Vetor ordenado:");
    }
}
