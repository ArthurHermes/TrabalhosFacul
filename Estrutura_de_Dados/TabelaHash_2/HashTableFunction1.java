class HashTableFunction1 extends HashTable {
    public HashTableFunction1(int size) {
        super(size);
    }

    @Override
    protected int hashFunction(String key) {
        return key.length() % size; // Função hash baseada no comprimento da chave
    }
}
