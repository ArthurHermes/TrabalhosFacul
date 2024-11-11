import java.util.Arrays;

abstract class HashTable {
    protected String[] table;
    protected int size;
    protected int count;
    protected int collisions;

    public HashTable(int size) {
        this.size = size;
        this.table = new String[size];
        this.collisions = 0;
        this.count = 0;
    }

    protected abstract int hashFunction(String key);

    public void insert(String key) {
        if (count >= size * 0.7) {
            rehash();
        }

        int index = hashFunction(key);
        int originalIndex = index;

        if (table[index] != null) {
            collisions++;
            index = (index + 1) % size;
            while (table[index] != null) {
                collisions++;
                index = (index + 1) % size;
                if (index == originalIndex) {
                    throw new RuntimeException("Table is full");
                }
            }
        }

        table[index] = key;
        count++;
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
        size *= 2;
        table = new String[size];
        count = 0;

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
