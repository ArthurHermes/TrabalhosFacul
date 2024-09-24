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

            Color pink = new Color(255, 192, 203);

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    newImage.setRGB(x, y, img.getRGB(x, y));
                }
            }

            Color targetColor = Color.WHITE;
            Color boundaryColor = Color.BLACK;
            int xStart = 294; 
            int yStart = 94; 

            if (xStart < 0 || xStart >= width || yStart < 0 || yStart >= height) {
                System.out.println("Ponto de início fora dos limites da imagem.");
                return;
            }

            Color startColor = new Color(newImage.getRGB(xStart, yStart));
            if (!isColorSimilar(startColor, targetColor)) {
                System.out.println("O ponto de início não é da cor alvo.");
                return;
            }

            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{xStart, yStart});

            while (!stack.isEmpty()) {
                count++;
                int[] point = stack.pop();
                int x = point[0];
                int y = point[1];

                if (x < 0 || x >= width || y < 0 || y >= height) {
                    continue;
                }

                Color currentColor = new Color(newImage.getRGB(x, y));

                if (isColorSimilar(currentColor, targetColor) && !isColorSimilar(currentColor, boundaryColor)) {
                    // Define a cor rosa
                    newImage.setRGB(x, y, pink.getRGB());

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

            System.out.println("Imagem processada e salva como 'quadrado_rosa_filled.png'.");

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
