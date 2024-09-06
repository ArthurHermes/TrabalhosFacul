package atividade6;

public class Configuracao {
    private static Configuracao instanciaUnica = null;

    private String ambiente;
    private int porta;

    private Configuracao() {
        this.ambiente = "desenvolvimento";
        this.porta = 8080;
    }

    public static Configuracao getInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new Configuracao();    
        }
        return instanciaUnica;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    @Override
    public String toString() {
        return "Configuracao (ambiente=" + ambiente + ", porta=" + porta + ")";
    }

    
}
