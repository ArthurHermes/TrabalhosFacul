
public class BubbleSort {
    private final int[] vet;

    public BubbleSort(int[] vet) {
        this.vet = vet;
    }

    public void exibirVetor(String mensagem) {
        System.out.println(mensagem);
        for (int i = 0; i < vet.length; i++) {
            System.out.print("\n" + vet[i]);
        }
        System.out.println();
    }

    public void ordenar() {
        int aux;
        for (int i = 0; i < vet.length - 1; i++) {
            for (int j = 0; j < vet.length - 1 - i; j++) {
                if (vet[j] > vet[j + 1]) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }
    }
    
}
