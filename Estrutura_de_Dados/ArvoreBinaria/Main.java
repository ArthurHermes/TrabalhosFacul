import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        ArvoreMorse arvoreMorse = new ArvoreMorse();
    
        System.out.println("Árvore Morse:");
        arvoreMorse.imprimirArvore(arvoreMorse.raiz, "");
    

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o código Morse para decodificar (use espaço entre letras): ");
            String codigo = scanner.nextLine();
            

            String resultado = arvoreMorse.decodificar(codigo);
            System.out.println("Palavra decodificada: " + resultado);
        } 
    }
}
