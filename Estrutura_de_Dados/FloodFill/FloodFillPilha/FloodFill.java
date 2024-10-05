package FloodFill.FloodFillPilha;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import javax.imageio.ImageIO;

public class FloodFill {
    public static void main(String[] args) {
        int contador = 0;
        int contadorNome = 0;
        File arquivo = new File("Estrutura_de_Dados\\FloodFill\\FloodFillPilha\\Marina.png");
        if (!arquivo.exists()) {
            System.out.println("O arquivo não foi encontrado!");
            return;
        }

        try {
            BufferedImage imagem = ImageIO.read(arquivo);
            int largura = imagem.getWidth();
            int altura = imagem.getHeight();
            BufferedImage novaImagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

            Color rosa = new Color(255, 192, 203);

            for (int y = 0; y < altura; y++) {
                for (int x = 0; x < largura; x++) {
                    novaImagem.setRGB(x, y, imagem.getRGB(x, y));
                }
            }

            Color corAlvo = Color.WHITE;
            Color corFronteira = Color.BLACK;

            int xInicio = 268;
            int yInicio = 69;

            if (xInicio < 0 || xInicio >= largura || yInicio < 0 || yInicio >= altura) {
                System.out.println("Ponto de início fora dos limites da imagem.");
                return;
            }

            Color corInicial = new Color(novaImagem.getRGB(xInicio, yInicio));
            if (!corSimilar(corInicial, corAlvo)) {
                System.out.println("O ponto de início não é da cor alvo.");
                return;
            }

            File diretorioSaida = new File("Estrutura_de_Dados\\FloodFill\\FloodFillPilha\\out");
            if (!diretorioSaida.exists()) {
                diretorioSaida.mkdirs(); 
            }

            Stack<int[]> pilha = new Stack<>();
            pilha.push(new int[]{xInicio, yInicio});

            while (!pilha.isEmpty()) {
                contador++;
                int[] ponto = pilha.pop();
                int x = ponto[0];
                int y = ponto[1];

                if (x < 0 || x >= largura || y < 0 || y >= altura) {
                    continue;
                }

                Color corAtual = new Color(novaImagem.getRGB(x, y));

                if (corSimilar(corAtual, corAlvo) && !corSimilar(corAtual, corFronteira)) {
                    novaImagem.setRGB(x, y, rosa.getRGB());

                    pilha.push(new int[]{x + 1, y});
                    pilha.push(new int[]{x - 1, y});
                    pilha.push(new int[]{x, y + 1});
                    pilha.push(new int[]{x, y - 1});
                }

                if (contador % 250 == 0) {
                    File arquivoSaida = new File("Estrutura_de_Dados\\FloodFill\\FloodFillPilha\\out/" + contadorNome + ".png");
                    ImageIO.write(novaImagem, "png", arquivoSaida);
                    contadorNome++;
                }
            }

            File arquivoFinal = new File("Estrutura_de_Dados\\FloodFill\\FloodFillPilha\\out/quadrado_rosa_filled.png");
            ImageIO.write(novaImagem, "png", arquivoFinal);

            System.out.println("Imagem processada e salva como 'quadrado_rosa_filled.png'.");
        } catch (IOException e) {
            System.out.println("Erro ao ler ou salvar a imagem: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean corSimilar(Color c1, Color c2) {
        int tolerancia = 30;
        return Math.abs(c1.getRed() - c2.getRed()) < tolerancia &&
               Math.abs(c1.getGreen() - c2.getGreen()) < tolerancia &&
               Math.abs(c1.getBlue() - c2.getBlue()) < tolerancia;
    }
}
