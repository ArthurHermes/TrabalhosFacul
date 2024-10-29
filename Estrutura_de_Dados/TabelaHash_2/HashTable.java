import java.util.Arrays;

abstract class HashTable {
    protected String[] table;
    protected int size;
    protected int count; // Número de elementos
    protected int collisions;

    public HashTable(int size) {
        this.size = size;
        this.table = new String[size];
        this.collisions = 0;
        this.count = 0; // Inicializa o contador de elementos
    }

    protected abstract int hashFunction(String key);

    public void insert(String key) {
        if (count >= size * 0.7) { // Rehash quando 70% estiver ocupado
            rehash();
        }
        
        int index = hashFunction(key);
        int originalIndex = index;

        // Verificar se há colisão antes do loop
        if (table[index] != null) {
            collisions++; // Contar colisão antes de começar a resolver
            index = (index + 1) % size; // Endereçamento aberto
            while (table[index] != null) {
                collisions++;
                index = (index + 1) % size; // Continuar buscando
                if (index == originalIndex) {
                    throw new RuntimeException("Table is full");
                }
            }
        }

        table[index] = key; // Inserir a chave no espaço vazio encontrado
        count++; // Incrementar o contador de elementos
    }

    public boolean search(String key) {
        int index = hashFunction(key);
        int originalIndex = index;

        while (table[index] != null) {
            if (table[index].equals(key)) {
                return true;
            }
            index = (index + 1) % size;
            if (index == originalIndex) {
                break;
            }
        }
        return false;
    }

    protected void rehash() {
        String[] oldTable = table;
        size *= 2; // Dobra o tamanho
        table = new String[size];
        count = 0; // Reseta o contador de elementos

        // Reinserir os elementos da tabela antiga
        for (String key : oldTable) {
            if (key != null) {
                insert(key);
            }
        }
    }

    public int getCollisions() {
        return collisions;
    }

    public String[] getTable() {
        return table;
    }
}
