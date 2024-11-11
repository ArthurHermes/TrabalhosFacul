import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "Estrutura_de_Dados\\TabelaHash_2\\female_names.txt";
        HashTable table1 = new HashTableFunction1(5001);
        HashTable table2 = new HashTableFunction2(5001);
        List<String> nomes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                nomes.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long startTime, endTime;

        startTime = System.nanoTime();
        for (String name : nomes) {
            table1.insert(name);
        }
        endTime = System.nanoTime();
        long timeTable1Insert = endTime - startTime;

        startTime = System.nanoTime();
        for (String name : nomes) {
            table2.insert(name);
        }
        endTime = System.nanoTime();
        long timeTable2Insert = endTime - startTime;

        System.out.println("Tempo total de inserção na Tabela 1 (Função Hash 1): " + timeTable1Insert + " ns");
        System.out.println("Tempo total de inserção na Tabela 2 (Função Hash 2): " + timeTable2Insert + " ns");

        testEfficiency(table1, table2);
    }

    private static void testEfficiency(HashTable table1, HashTable table2) {
        long startTime, endTime;

        startTime = System.nanoTime();
        for (String name : table1.getTable()) {
            if (name != null) table1.search(name);
        }
        endTime = System.nanoTime();
        long timeTable1Search = endTime - startTime;

        startTime = System.nanoTime();
        for (String name : table2.getTable()) {
            if (name != null) table2.search(name);
        }
        endTime = System.nanoTime();
        long timeTable2Search = endTime - startTime;

        System.out.println("\nTabela 1 (Função Hash 1):");
        System.out.println("Número de colisões: " + table1.getCollisions());
        System.out.println("Tempo total de busca: " + timeTable1Search + " ns");

        System.out.println("\nTabela 2 (Função Hash 2):");
        System.out.println("Número de colisões: " + table2.getCollisions());
        System.out.println("Tempo total de busca: " + timeTable2Search + " ns");

        printCollisionDistribution(table1);
        printCollisionDistribution(table2);
    }

    private static void printCollisionDistribution(HashTable table) {
        int[] distribution = new int[table.size];
        for (String name : table.getTable()) {
            if (name != null) {
                int index = table.hashFunction(name);
                distribution[index]++;
            }
        }

        System.out.println("\nDistribuição de colisões para a Tabela:");
        for (int i = 0; i < distribution.length; i++) {
            if (distribution[i] > 1) {
                System.out.println("Índice " + i + ": " + distribution[i] + " colisões");
            }
        }
    }
}
