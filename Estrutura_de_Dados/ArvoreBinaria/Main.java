import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        ArvoreMorse arvoreMorse = new ArvoreMorse();

        // Imprimir a árvore de código Morse
        System.out.println("Árvore Morse:");
        arvoreMorse.imprimirArvore(arvoreMorse.raiz, "");

        // Entrada do usuário para decodificar uma palavra
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o código Morse para decodificar (use espaço entre letras): ");
        String codigo = scanner.nextLine();

        // Decodificar e imprimir o resultado
        String resultado = arvoreMorse.decodificar(codigo);
        System.out.println("Palavra decodificada: " + resultado);

        scanner.close();
    }
}
