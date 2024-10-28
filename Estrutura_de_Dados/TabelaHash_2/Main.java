import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "names_5000.csv"; // Caminho para o seu arquivo CSV
        HashTable table1 = new HashTableFunction1(5000);
        HashTable table2 = new HashTableFunction2(5000);

        // Ler o arquivo CSV e inserir os nomes nas tabelas
        //marcar tempo da insercao, fazer um vetor de string{} e inserir tudo nele e depois inserir separadamente em cada tabela marcando o tempo
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                table1.insert(line.trim());
                table2.insert(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Testar eficiência
        testEfficiency(table1, table2);
    }

    private static void testEfficiency(HashTable table1, HashTable table2) {
        // Teste de buscas
        long startTime, endTime;
        
        // Tempo de inserção
        startTime = System.nanoTime();
        for (String name : table1.getTable()) {
            if (name != null) table1.search(name);
        }
        endTime = System.nanoTime();
        long time1 = endTime - startTime;

        startTime = System.nanoTime();
        for (String name : table2.getTable()) {
            if (name != null) table2.search(name);
        }
        endTime = System.nanoTime();
        long time2 = endTime - startTime;

        // Relatório
        System.out.println("Tabela 1 (Função Hash 1):");
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
            if(distribution[i]==1)
            System.out.println("Índice " + i + ": " + distribution[i] + " chaves");
        }
    }
}
