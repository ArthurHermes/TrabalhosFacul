public class TabelaHashProbingQuadratico extends TabelaHash {
    public TabelaHashProbingQuadratico(int tamanho) {
        super(tamanho);
    }

    @Override
    protected int funcaoHash(String chave) {
        return Math.abs(chave.hashCode() % tamanho); // Usando Math.abs para evitar índices negativos
    }

    @Override
    public boolean inserir(String chave) {
        int indice = funcaoHash(chave);
        int i = 0; // Para probing quadrático

        while (tabela[indice] != null) {
            if (tabela[indice].equals(chave)) {
                return false; // Já existe na tabela
            }
            colisoes++;
            i++;
            indice = (funcaoHash(chave) + i * i) % tamanho; // Probing quadrático
            indice = Math.abs(indice); // Garantindo que o índice seja não negativo
        }
        tabela[indice] = chave;
        return true;
    }
}
