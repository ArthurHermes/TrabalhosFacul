import java.util.Arrays;

public abstract class TabelaHash {
    protected String[] tabela;
    protected int tamanho;
    protected int colisoes;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        tabela = new String[tamanho];
        colisoes = 0;
    }

    protected abstract int funcaoHash(String chave);

    public boolean inserir(String chave) {
        int indice = funcaoHash(chave);
        int indiceOriginal = indice;

        while (tabela[indice] != null) {
            if (tabela[indice].equals(chave)) {
                return false; // Já existe na tabela
            }
            colisoes++;
            indice = (indice + 1) % tamanho; // Probing linear
            if (indice == indiceOriginal) {
                return false; // Tabela cheia
            }
        }
        tabela[indice] = chave;
        return true;
    }

    public boolean buscar(String chave) {
        int indice = funcaoHash(chave);
        int indiceOriginal = indice;

        while (tabela[indice] != null) {
            if (tabela[indice].equals(chave)) {
                return true; // Encontrado
            }
            indice = (indice + 1) % tamanho; // Probing linear
            if (indice == indiceOriginal) {
                return false; // Não encontrado
            }
        }
        return false; // Não encontrado
    }

    public String remover(String chave) {
        int indice = funcaoHash(chave);
        int indiceOriginal = indice;

        while (tabela[indice] != null) {
            if (tabela[indice].equals(chave)) {
                String chaveRemovida = tabela[indice];
                tabela[indice] = null; // Remove a chave
                return chaveRemovida;
            }
            indice = (indice + 1) % tamanho; // Probing linear
            if (indice == indiceOriginal) {
                return null; // Não encontrado
            }
        }
        return null; // Não encontrado
    }

    public int getColisoes() {
        return colisoes;
    }

    public void distribuicaoDasChaves() {
        int[] contagem = new int[tamanho];
        for (String chave : tabela) {
            if (chave != null) {
                int indice = funcaoHash(chave);
                contagem[indice]++;
            }
        }
        System.out.println("Distribuição das chaves:");
        for (int i = 0; i < contagem.length; i++) {
            System.out.printf("Índice %d: %d chave(s)%n", i, contagem[i]);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(tabela);
    }
}
