public class TabelaHashProbingLinear extends TabelaHash {
    public TabelaHashProbingLinear(int tamanho) {
        super(tamanho);
    }

    @Override
    protected int funcaoHash(String chave) {
        return Math.abs(chave.hashCode() % tamanho); // Usando Math.abs para evitar índices negativos
    }
}
