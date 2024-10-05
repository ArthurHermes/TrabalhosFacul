package FloodFill.FloodFillFila;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import javax.imageio.ImageIO;

public class FloodFill {
    public static void main(String[] args) {
        int count = 0;
        int countName = 0;
        File file = new File("Estrutura_de_Dados\\FloodFill\\FloodFillFila\\Marina.png");
        if (!file.exists()) {
            System.out.println("O arquivo não foi encontrado!");
            return;
        }

        try {
            BufferedImage img = ImageIO.read(file);
            int width = img.getWidth();
            int height = img.getHeight();
            BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            Color pink = new Color(255, 192, 203);

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    newImage.setRGB(x, y, img.getRGB(x, y));
                }
            }

            Color targetColor = Color.WHITE;
            Color boundaryColor = Color.BLACK;

            int xStart = 268; 
            int yStart = 69; 

            if (xStart < 0 || xStart >= width || yStart < 0 || yStart >= height) {
                System.out.println("Ponto de início fora dos limites da imagem.");
                return;
            }

            Color startColor = new Color(newImage.getRGB(xStart, yStart));
            if (!isColorSimilar(startColor, targetColor)) {
                System.out.println("O ponto de início não é da cor alvo.");
                return;
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{xStart, yStart});

         
            File outDir = new File("Estrutura_de_Dados\\FloodFill\\FloodFillFila\\out");
            if (!outDir.exists()) {
                outDir.mkdirs(); 
            }

            while (!queue.isEmpty()) {
                count++;
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];

                if (x < 0 || x >= width || y < 0 || y >= height) {
                    continue;
                }

                Color currentColor = new Color(newImage.getRGB(x, y));

                if (isColorSimilar(currentColor, targetColor) && !isColorSimilar(currentColor, boundaryColor)) {
                    newImage.setRGB(x, y, pink.getRGB());

                    queue.offer(new int[]{x + 1, y});
                    queue.offer(new int[]{x - 1, y});
                    queue.offer(new int[]{x, y + 1});
                    queue.offer(new int[]{x, y - 1});
                }

                if (count % 500 == 0) {
                    File output = new File("Estrutura_de_Dados\\FloodFill\\FloodFillFila\\out/" + countName + ".png");
                    ImageIO.write(newImage, "png", output);
                    countName++;
                }
            }

            File outputFile = new File("Estrutura_de_Dados\\FloodFill\\FloodFillFila\\out/quadrado_rosa_filled.png");
            ImageIO.write(newImage, "png", outputFile);

            System.out.println("Imagem processada e salva.");

        } catch (IOException e) {
            System.out.println("Erro ao ler ou salvar a imagem: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean isColorSimilar(Color c1, Color c2) {
        int tolerance = 30; 
        return Math.abs(c1.getRed() - c2.getRed()) < tolerance &&
               Math.abs(c1.getGreen() - c2.getGreen()) < tolerance &&
               Math.abs(c1.getBlue() - c2.getBlue()) < tolerance;
    }
}
