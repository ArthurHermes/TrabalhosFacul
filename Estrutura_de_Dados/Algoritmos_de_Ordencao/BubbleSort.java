public class BubbleSort {
    private int[] vet;

    // Construtor para inicializar o vetor
    public BubbleSort(int[] vet) {
        this.vet = vet;
    }

    // Método para exibir o vetor
    public void exibirVetor(String mensagem) {
        System.out.println(mensagem);
        for (int i = 0; i < vet.length; i++) {
            System.out.print(" " + vet[i]);
        }
        System.out.println();
    }

    // Método para ordenar o vetor (usando bubble sort)
    public void ordenar() {
        int aux;
        for (int i = 0; i < vet.length; i++) {
            for (int j = 0; j < vet.length - 1; j++) {
                if (vet[j] > vet[j + 1]) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        int[] vetor = {8, 9, 3, 5, 1};
        
        BubbleSort ordenador = new BubbleSort(vetor);

        ordenador.exibirVetor("Vetor desordenado:");
        ordenador.ordenar();
        ordenador.exibirVetor("Vetor organizado:");
    }
}
