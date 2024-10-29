import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Defina as variáveis para o tamanho da tabela e o número de nomes
        int tableSize = 5000; // Tamanho da tabela hash
        int numberOfNames = 5000; // Número de nomes a serem lidos

        String filePath = "Estrutura_de_Dados\\TabelaHash_2\\names_5000.csv"; // Caminho para o seu arquivo CSV
        HashTable table1 = new HashTableFunction1(tableSize);
        HashTable table2 = new HashTableFunction2(tableSize);

        // Ler o arquivo CSV e armazenar os nomes em um vetor
        String[] names = new String[numberOfNames];
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null && index < names.length) {
                names[index++] = line.trim();
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return; // Termina a execução se não conseguir ler o arquivo
        }

        // Marcar tempo da inserção na tabela 1
        long startTime = System.nanoTime();
        for (String name : names) {
            if (name != null) {
                table1.insert(name);
            }
        }
        long endTime = System.nanoTime();
        long insertionTime1 = endTime - startTime;

        // Marcar tempo da inserção na tabela 2
        startTime = System.nanoTime();
        for (String name : names) {
            if (name != null) {
                table2.insert(name);
            }
        }
        endTime = System.nanoTime();
        long insertionTime2 = endTime - startTime;

        // Testar eficiência
        testEfficiency(table1, table2);

        // Relatório de tempos de inserção
        System.out.println("Tempo total de inserção na Tabela 1 (Função Hash 1): " + insertionTime1 + " ns");
        System.out.println("Tempo total de inserção na Tabela 2 (Função Hash 2): " + insertionTime2 + " ns");
    }

    private static void testEfficiency(HashTable table1, HashTable table2) {
        // Teste de buscas
        long startTime, endTime;

        // Tempo de busca na tabela 1
        startTime = System.nanoTime();
        for (String name : table1.getTable()) {
            if (name != null) table1.search(name);
        }
        endTime = System.nanoTime();
        long time1 = endTime - startTime;

        // Tempo de busca na tabela 2
        startTime = System.nanoTime();
        for (String name : table2.getTable()) {
            if (name != null) table2.search(name);
        }
        endTime = System.nanoTime();
        long time2 = endTime - startTime;

        // Relatório de buscas
        System.out.println("\nTabela 1 (Função Hash 1):");
        System.out.println("Número de colisões: " + table1.getCollisions());
        System.out.println("Tempo total de busca: " + time1 + " ns");

        System.out.println("\nTabela 2 (Função Hash 2):");
        System.out.println("Número de colisões: " + table2.getCollisions());
        System.out.println("Tempo total de busca: " + time2 + " ns");

        // Distribuição das chaves
        printKeyDistribution(table1);
        printKeyDistribution(table2);
    }

    private static void printKeyDistribution(HashTable table) {
        int[] distribution = new int[table.size];
        for (String name : table.getTable()) {
            if (name != null) {
                int index = table.hashFunction(name);
                distribution[index]++;
            }
        }

        System.out.println("\nDistribuição de chaves:");
        for (int i = 0; i < distribution.length; i++) {
            System.out.println("Indice " + i + ": " + distribution[i] + " chaves");
        }
    }
}
