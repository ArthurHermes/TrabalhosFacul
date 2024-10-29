
public class InsertionSort {
    

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while ((j > 0) && (arr[j - 1] > arr[j])) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                j--;
            }
        }
        return arr;
    }


    public static void exibirVetor(String mensagem, int[] arr) {
        System.out.println(mensagem);
        for (int num : arr) {
            System.out.println(num);
        }
    }

}
