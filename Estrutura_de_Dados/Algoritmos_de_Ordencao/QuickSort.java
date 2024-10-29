public class QuickSort {
    private final int[] vetor;

    public QuickSort(int[] vetor) {
        this.vetor = vetor;
    }

    public void ordenar() {
        quickSort(0, vetor.length - 1);
    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separarPosicionarPivo(inicio, fim);
            quickSort(inicio, posicaoPivo - 1);
            quickSort(posicaoPivo + 1, fim);
        }
    }

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

    public void exibirVetor(String mensagem) {
        System.out.println(mensagem);
        for (int valor : vetor) {
            System.out.println(valor);
        }
    }
}
