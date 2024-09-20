import java.util.Scanner;

public class ExampleApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê os números e a ação desejada da entrada do usuário.
        System.out.print("Digite o primeiro número: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int secondNumber = scanner.nextInt();

        System.out.print("Escolha uma ação (adicao, subtracao, multiplicacao): ");
        String action = scanner.next().toLowerCase();

        int result;

        // Define a operação com base na entrada do usuário.
        switch (action) {
            case "adicao":
                result = firstNumber + secondNumber;
                break;
            case "subtracao":
                result = firstNumber - secondNumber;
                break;
            case "multiplicacao":
                result = firstNumber * secondNumber;
                break;
            default:
                System.out.println("Ação inválida!");
                scanner.close();
                return;
        }

        // Imprime o resultado da operação.
        System.out.println("Resultado: " + result);

        scanner.close();
    }
}
