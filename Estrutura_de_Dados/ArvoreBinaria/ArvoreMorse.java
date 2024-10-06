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
    Map<Character, String> morseMap; // Mapeamento de letras para código Morse

    public ArvoreMorse() {
        raiz = new No(' '); // Nodo raiz vazio
        morseMap = new HashMap<>();
        construirArvore();
    }

    // Inserir um caractere na árvore com base no código Morse
    void inserir(char letra, String codigoMorse) {
        raiz = inserirRecursivo(raiz, letra, codigoMorse, 0);
    }

    No inserirRecursivo(No raiz, char letra, String codigoMorse, int posicao) {
        if (raiz == null) {
            raiz = new No(' '); // Cria um nodo vazio
        }

        if (posicao == codigoMorse.length()) {
            raiz.valor = letra; // Atribui o caractere no local correto
        } else {
            if (codigoMorse.charAt(posicao) == '.') {
                raiz.esquerdo = inserirRecursivo(raiz.esquerdo, letra, codigoMorse, posicao + 1);
            } else if (codigoMorse.charAt(posicao) == '-') {
                raiz.direito = inserirRecursivo(raiz.direito, letra, codigoMorse, posicao + 1);
            }
        }

        return raiz;
    }

    // Função para decodificar uma sequência de código Morse
    String decodificar(String codigo) {
        StringBuilder resultado = new StringBuilder();
        String[] caracteres = codigo.split(" "); // Separando por espaços para cada letra

        for (String c : caracteres) {
            resultado.append(decodificarRecursivo(raiz, c, 0));
        }

        return resultado.toString();
    }

    char decodificarRecursivo(No raiz, String codigoMorse, int posicao) {
        if (raiz == null) {
            return ' '; // Caso de erro, caractere não encontrado
        }
        if (posicao == codigoMorse.length()) {
            return raiz.valor; // Retorna o caractere na posição
        }

        if (codigoMorse.charAt(posicao) == '.') {
            return decodificarRecursivo(raiz.esquerdo, codigoMorse, posicao + 1);
        } else {
            return decodificarRecursivo(raiz.direito, codigoMorse, posicao + 1);
        }
    }

    // Função para imprimir a árvore (preorder traversal)
    void imprimirArvore(No raiz, String codigo) {
        if (raiz != null) {
            if (raiz.valor != ' ') {
                System.out.println(raiz.valor + " -> " + codigo);
            }
            imprimirArvore(raiz.esquerdo, codigo + ".");
            imprimirArvore(raiz.direito, codigo + "-");
        }
    }

    // Construir a árvore com base no código Morse
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
        // Adicione números ou outros símbolos se necessário
    }

}
