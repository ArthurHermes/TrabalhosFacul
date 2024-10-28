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
    // tem que guardar atual da tabela para parar de inserir
    // Verificar se tem colisao antes do while da colisao
    protected abstract int hashFunction(String key);

    public void insert(String key) {
        int index = hashFunction(key);
        int originalIndex = index;
        if(table[index] == null){
            table[index] = key;
        }else {
            index = (index + 1) % size;
            while (table[index] != null) {
                collisions++;
                index = (index + 1) % size; // Endereçamento aberto
                if (index == originalIndex) {
                    throw new RuntimeException("Table is full");
                }
            }
        }
        
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
