import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerCSV {
    private String arquivoCSV;

    public LerCSV(String arquivoCSV) {
        this.arquivoCSV = arquivoCSV;
    }

    public List<Integer> lerNumeros() {
        List<Integer> numeros = new ArrayList<>();
        String linha;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            while ((linha = br.readLine()) != null) {
                try {
                    int numero = Integer.parseInt(linha.trim());
                    numeros.add(numero);
                } catch (NumberFormatException e) {
                    System.out.println("Linha invalida: " + linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return numeros;
    }

    public static void main(String[] args) {

        LerCSV leitor = new LerCSV("csv\\aleatorio_10000.csv");
        
        
        List<Integer> numeros = leitor.lerNumeros();

        
        System.out.println("Numeros lidos do arquivo:");
        for (int numero : numeros) {
            System.out.println("Numero: " + numero);
        }
    }
}
