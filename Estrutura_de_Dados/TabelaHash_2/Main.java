import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "Estrutura_de_Dados\\TabelaHash_2\\female_names.txt"; // Caminho para o seu arquivo CSV
        HashTable table1 = new HashTableFunction1(5000);
        HashTable table2 = new HashTableFunction2(5000);
        List<String> nomes = new ArrayList<>();

        // Ler o arquivo CSV e armazenar os nomes em um vetor de strings
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                nomes.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Inserir nomes nas tabelas, marcando o tempo de inserção
        long startTime, endTime;

        // Inserção na tabela 1
        startTime = System.nanoTime();
        for (String name : nomes) {
            table1.insert(name);
        }
        endTime = System.nanoTime();
        long timeTable1Insert = (endTime - startTime) / 1_000_000; // Convertendo para milissegundos

        // Inserção na tabela 2
        startTime = System.nanoTime();
        for (String name : nomes) {
            table2.insert(name);
        }
        endTime = System.nanoTime();
        long timeTable2Insert = (endTime - startTime) / 1_000_000; // Convertendo para milissegundos

        // Relatório de inserção
        System.out.println("Tempo total de inserção na Tabela 1 (Função Hash 1): " + timeTable1Insert + " ns");
        System.out.println("Tempo total de inserção na Tabela 2 (Função Hash 2): " + timeTable2Insert + " ns");

        // Testar eficiência
        testEfficiency(table1, table2);
    }

    private static void testEfficiency(HashTable table1, HashTable table2) {
        long startTime, endTime;

        // Tempo de busca na tabela 1
        startTime = System.nanoTime();
        for (String name : table1.getTable()) {
            if (name != null) table1.search(name);
        }
        endTime = System.nanoTime();
        long timeTable1Search = (endTime - startTime) / 1_000_000; // Convertendo para milissegundos

        // Tempo de busca na tabela 2
        startTime = System.nanoTime();
        for (String name : table2.getTable()) {
            if (name != null) table2.search(name);
        }
        endTime = System.nanoTime();
        long timeTable2Search = (endTime - startTime) / 1_000_000; // Convertendo para milissegundos

        // Relatório
        System.out.println("\nTabela 1 (Função Hash 1):");
        System.out.println("Número de colisões: " + table1.getCollisions());
        System.out.println("Tempo total de busca: " + timeTable1Search + " ns");

        System.out.println("\nTabela 2 (Função Hash 2):");
        System.out.println("Número de colisões: " + table2.getCollisions());
        System.out.println("Tempo total de busca: " + timeTable2Search + " ns");

        // Distribuição das colisões
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
            if (distribution[i] > 1) { // Exibir somente índices com colisões
                System.out.println("Índice " + i + ": " + distribution[i] + " colisões");
            }
        }
    }
}
