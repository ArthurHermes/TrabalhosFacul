import java.util.Arrays;


public class InsertionSort{
    
    
    public static int[] insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int j = i;
            while ((j > 0) && (arr[j-1] > arr[j])){
                int tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
                j--;
            }
        }
        return arr;
        
    }

    
    public static void main(String[] args) {
        int arr[] = new int[] { 7, 3, 5, 8, 2, 9, 4, 15, 6 };
        
        System.out.println("Desordenado: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
        System.out.println("\nOrdenado: ");
        arr = insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        
            
        }
        
    }