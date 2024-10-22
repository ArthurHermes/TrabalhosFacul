import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        String caminhoArquivo = "Estrutura_de_dados/TabelaHash/names_5000.csv"; // Certifique-se de que o arquivo está no caminho correto
        TabelaHash tabelaLinear = new TabelaHashProbingLinear(6000);
        TabelaHash tabelaQuadratica = new TabelaHashProbingQuadratico(6000);

        // Leitura do arquivo e inserção na tabela hash com probing linear
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            long tempoInicio, tempoFim;

            // Inserção na tabela hash com probing linear
            tempoInicio = System.currentTimeMillis(); // Medida em milissegundos
            while ((linha = br.readLine()) != null) {
                String chave = linha.trim(); // Ler como string
                tabelaLinear.inserir(chave);
            }
            tempoFim = System.currentTimeMillis();
            System.out.printf("Probing Linear: %d colisões, tempo: %.3f segundos%n", 
                              tabelaLinear.getColisoes(), 
                              (tempoFim - tempoInicio) / 1000.0); // Convertendo milissegundos para segundos
            
            // Imprimir a distribuição das chaves
            tabelaLinear.distribuicaoDasChaves(); // Mostra a distribuição das chaves
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leitura do arquivo e inserção na tabela hash com probing quadrático
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            long tempoInicio, tempoFim;

            // Inserção na tabela hash com probing quadrático
            tempoInicio = System.currentTimeMillis(); // Medida em milissegundos
            while ((linha = br.readLine()) != null) {
                String chave = linha.trim(); // Ler como string
                tabelaQuadratica.inserir(chave);
            }
            tempoFim = System.currentTimeMillis();
            System.out.printf("Probing Quadrático: %d colisões, tempo: %.3f segundos%n", 
                              tabelaQuadratica.getColisoes(), 
                              (tempoFim - tempoInicio) / 1000.0); // Convertendo milissegundos para segundos
            
            // Imprimir a distribuição das chaves
            tabelaQuadratica.distribuicaoDasChaves(); // Mostra a distribuição das chaves
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
