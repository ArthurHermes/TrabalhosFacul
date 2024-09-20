// Interface Strategy declara operações comuns a todas as versões suportadas de algum algoritmo.
interface Strategy {
    int execute(int a, int b);
}

// Estratégias concretas implementam o algoritmo enquanto seguem a interface Strategy base.
class ConcreteStrategyAdd implements Strategy {
    public int execute(int a, int b) {
        return a + b;
    }
}

class ConcreteStrategySubtract implements Strategy {
    public int execute(int a, int b) {
        return a - b;
    }
}

class ConcreteStrategyMultiply implements Strategy {
    public int execute(int a, int b) {
        return a * b;
    }
}

// O contexto define a interface de interesse para clientes.
class Context {
    private Strategy strategy;

    // O contexto aceita uma estratégia e permite trocá-la durante a execução.
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    // O contexto delega o trabalho para o objeto estratégia.
    public int executeStrategy(int a, int b) {
        if (strategy != null) {
            return strategy.execute(a, b);
        } else {
            throw new IllegalStateException("Estratégia não definida");
        }
    }
}

// O código cliente escolhe uma estratégia concreta e a passa para o contexto.
public class ApplicationStrategy {

    public static void main(String[] args) {
        Context context = new Context();

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Lê os números e a ação desejada da entrada do usuário.
        System.out.print("Digite o primeiro número: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int secondNumber = scanner.nextInt();

        System.out.print("Escolha uma ação (adicao, subtracao, multiplicacao): ");
        String action = scanner.next().toLowerCase();

        // Define a estratégia com base na entrada do usuário.
        switch (action) {
            case "adicao":
                context.setStrategy(new ConcreteStrategyAdd());
                break;
            case "subtracao":
                context.setStrategy(new ConcreteStrategySubtract());
                break;
           case "multiplicacao":
                context.setStrategy(new ConcreteStrategyMultiply());
                break;
            default:
                System.out.println("Ação inválida!");
        }

        // Executa a estratégia e imprime o resultado.
        int result = context.executeStrategy(firstNumber, secondNumber);
        System.out.println("Resultado: " + result);

        scanner.close();
    }
}