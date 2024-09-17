package FloodFill;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import javax.imageio.ImageIO;

public class FloodFill {
    public static void main(String[] args) {
        int count = 0;
        int countName = 0;
        File file = new File("Estrutura_de_Dados\\FloodFill\\riscomeio.png");
        if (!file.exists()) {
            System.out.println("O arquivo não foi encontrado!");
            return;
        }

        try {
            BufferedImage img = ImageIO.read(file);
            int width = img.getWidth();
            int height = img.getHeight();
            BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            // Define a cor rosa
            Color pink = new Color(255, 192, 203);

            // Copia a imagem original para a nova imagem
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    newImage.setRGB(x, y, img.getRGB(x, y));
                }
            }

            // Define a cor branca para ser substituída
            Color targetColor = Color.WHITE;

            // Define a cor preta como a cor da borda
            Color boundaryColor = Color.BLACK;

            // Defina manualmente o ponto de início mais próximo da região desejada
            int xStart = 294; // Ajuste o valor de acordo com a imagem
            int yStart = 94; // Ajuste o valor de acordo com a imagem

            // Verifica se o ponto de início está dentro da imagem e na cor alvo
            if (xStart < 0 || xStart >= width || yStart < 0 || yStart >= height) {
                System.out.println("Ponto de início fora dos limites da imagem.");
                return;
            }

            Color startColor = new Color(newImage.getRGB(xStart, yStart));
            if (!isColorSimilar(startColor, targetColor)) {
                System.out.println("O ponto de início não é da cor alvo.");
                return;
            }

            // Algoritmo de preenchimento por flood fill usando pilha
            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{xStart, yStart});

            

            while (!stack.isEmpty()) {
                count++;
                int[] point = stack.pop();
                int x = point[0];
                int y = point[1];

                // Verifica se o ponto está dentro dos limites da imagem
                if (x < 0 || x >= width || y < 0 || y >= height) {
                    continue;
                }

                // Verifica a cor do pixel
                Color currentColor = new Color(newImage.getRGB(x, y));

                // Se o pixel atual for da cor alvo e não for da cor de borda (preto)
                if (isColorSimilar(currentColor, targetColor) && !isColorSimilar(currentColor, boundaryColor)) {
                    // Define a cor rosa
                    newImage.setRGB(x, y, pink.getRGB());


                    // Adiciona os pixels adjacentes à pilha
                    stack.push(new int[]{x + 1, y});
                    stack.push(new int[]{x - 1, y});
                    stack.push(new int[]{x, y + 1});
                    stack.push(new int[]{x, y - 1});
                }

                if(count % 1000 == 0) {
                    File output = new File("Estrutura_de_Dados\\FloodFill\\out/nome_" + countName + ".png");
                    ImageIO.write(newImage, "png", output);
                    countName++;
                }
            }

            // Salva a nova imagem alterada
            
            

            System.out.println("Imagem processada e salva como 'quadrado_rosa_filled.png'.");

        } catch (IOException e) {
            System.out.println("Erro ao ler ou salvar a imagem: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Função para comparar cores com uma tolerância
    private static boolean isColorSimilar(Color c1, Color c2) {
        int tolerance = 30; // Aumentei a tolerância para tornar a comparação mais flexível
        return Math.abs(c1.getRed() - c2.getRed()) < tolerance &&
               Math.abs(c1.getGreen() - c2.getGreen()) < tolerance &&
               Math.abs(c1.getBlue() - c2.getBlue()) < tolerance;
    }
}
