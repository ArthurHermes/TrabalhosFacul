import java.util.HashMap;
import java.util.Map;

class No {
    char valor;
    No esquerdo, direito;

    public No(char item) {
        valor = item;
        esquerdo = direito = null;
    }
}

public class ArvoreMorse {
    No raiz;
    Map<Character, String> morseMap; 

    public ArvoreMorse() {
        raiz = new No(' '); 
        morseMap = new HashMap<>();
        construirArvore();
    }

    void inserir(char letra, String codigoMorse) {
        raiz = inserirRecursivo(raiz, letra, codigoMorse, 0);
    }

    No inserirRecursivo(No raiz, char letra, String codigoMorse, int posicao) {
        if (raiz == null) {
            raiz = new No(' '); 
        }

        if (posicao == codigoMorse.length()) {
            raiz.valor = letra; 
        } else {
            if (codigoMorse.charAt(posicao) == '.') {
                raiz.esquerdo = inserirRecursivo(raiz.esquerdo, letra, codigoMorse, posicao + 1);
            } else if (codigoMorse.charAt(posicao) == '-') {
                raiz.direito = inserirRecursivo(raiz.direito, letra, codigoMorse, posicao + 1);
            }
        }

        return raiz;
    }


    String decodificar(String codigo) {
        StringBuilder resultado = new StringBuilder();
        String[] caracteres = codigo.split(" ");

        for (String c : caracteres) {
            resultado.append(decodificarRecursivo(raiz, c, 0));
        }

        return resultado.toString();
    }

    char decodificarRecursivo(No raiz, String codigoMorse, int posicao) {
        if (raiz == null) {
            return ' '; 
        }
        if (posicao == codigoMorse.length()) {
            return raiz.valor; 
        }

        if (codigoMorse.charAt(posicao) == '.') {
            return decodificarRecursivo(raiz.esquerdo, codigoMorse, posicao + 1);
        } else {
            return decodificarRecursivo(raiz.direito, codigoMorse, posicao + 1);
        }
    }


    void imprimirArvore(No raiz, String codigo) {
        if (raiz != null) {
            if (raiz.valor != ' ') {
                System.out.println(raiz.valor + " -> " + codigo);
            }

            imprimirArvore(raiz.esquerdo, codigo + ".");
            imprimirArvore(raiz.direito, codigo + "-");
        }
    }


    void construirArvore() {
        inserir('A', ".-");
        inserir('B', "-...");
        inserir('C', "-.-.");
        inserir('D', "-..");
        inserir('E', ".");
        inserir('F', "..-.");
        inserir('G', "--.");
        inserir('H', "....");
        inserir('I', "..");
        inserir('J', ".---");
        inserir('K', "-.-");
        inserir('L', ".-..");
        inserir('M', "--");
        inserir('N', "-.");
        inserir('O', "---");
        inserir('P', ".--.");
        inserir('Q', "--.-");
        inserir('R', ".-.");
        inserir('S', "...");
        inserir('T', "-");
        inserir('U', "..-");
        inserir('V', "...-");
        inserir('W', ".--");
        inserir('X', "-..-");
        inserir('Y', "-.--");
        inserir('Z', "--..");
        
    }

}
