import java.util.Arrays;

abstract class HashTable {
    protected String[] table;
    protected int size;
    protected int collisions;

    public HashTable(int size) {
        this.size = size;
        this.table = new String[size];
        this.collisions = 0;
    }

    protected abstract int hashFunction(String key);

    public void insert(String key) {
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

    public int getCollisions() {
        return collisions;
    }

    public String[] getTable() {
        return table;
    }
}

// Exemplo de implementação concreta da HashTable
class SimpleHashTable extends HashTable {

    public SimpleHashTable(int size) {
        super(size);
    }

    @Override
    protected int hashFunction(String key) {
        return Math.abs(key.hashCode()) % size; // Função hash simples
    }
}
