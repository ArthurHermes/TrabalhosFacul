import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MorseCodeTree tree = new MorseCodeTree();

        System.out.println("Escolha uma opção: ");
        System.out.println("1. Decodificar código Morse");
        System.out.println("2. Codificar texto para código Morse");
        int opcao = sc.nextInt();
        sc.nextLine();  
        if (opcao == 1) {
            System.out.println("Insira a mensagem em código Morse (separada por espaços, três espaços entre palavras):");
            String input = sc.nextLine();
            String[] morseWords = input.split("   ");  
            StringBuilder decodedMessage = new StringBuilder();

            for (String morseWord : morseWords) {
                String[] morseLetters = morseWord.split(" ");  
                for (String code : morseLetters) {
                    decodedMessage.append(tree.decode(code));
                }
                decodedMessage.append(' ');  
            }

            System.out.println("Mensagem decodificada: " + decodedMessage.toString().trim());
        } else if (opcao == 2) {
            System.out.println("Insira a mensagem em texto para codificar em Morse:");
            String input = sc.nextLine();
            String encodedMessage = tree.encode(input);
            System.out.println("Mensagem codificada: " + encodedMessage);
        }

        sc.close();
    }
}
