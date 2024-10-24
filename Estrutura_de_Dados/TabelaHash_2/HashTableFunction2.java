class HashTableFunction2 extends HashTable {
    public HashTableFunction2(int size) {
        super(size);
    }

    @Override
    protected int hashFunction(String key) {
        return (key.hashCode() & 0x7FFFFFFF) % size; // Função hash usando hashCode
    }
}
