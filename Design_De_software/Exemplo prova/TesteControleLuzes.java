
class Luzes {
    public void ligar() {
        System.out.println("Luzes ligadas.");
    }

    public void desligar() {
        System.out.println("Luzes desligadas.");
    }
}


class ControleLuzesFacade {
    private Luzes luzes;

    public ControleLuzesFacade() {
        this.luzes = new Luzes();
    }

    // Método para ligar as luzes
    public void ligarLuzes() {
        luzes.ligar();
    }

    // Método para desligar as luzes
    public void desligarLuzes() {
        luzes.desligar();
    }
}

// Cliente
public class TesteControleLuzes {
    public static void main(String[] args) {
        // Criando a fachada
        ControleLuzesFacade controleLuzes = new ControleLuzesFacade();

        // Usando a fachada para ligar e desligar as luzes
        controleLuzes.ligarLuzes();
        controleLuzes.desligarLuzes();
    }
}
