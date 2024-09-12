package ModificandoImagem;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ColorirImagem{
    public static void main(String[] args) {
        try {
            // Carregar a imagem
            BufferedImage imagem = ImageIO.read(new File("ModificandoImagem\\quadrado.png"));
            Graphics2D g2 = imagem.createGraphics();

            // Tamanho do quadrado na imagem (ajustar conforme a imagem)
            int squareSize = 20; // Ajuste o tamanho do quadrado aqui
            int width = imagem.getWidth();
            int height = imagem.getHeight();
            Color black = new Color(0, 0, 0); // Cor preta

            // Colorir a imagem, linha por linha
            for (int y = 0; y < height; y += squareSize) {
                boolean encontrouPreto = false;
                for (int x = 0; x < width; x += squareSize) {
                    // Verifica se o quadrado atual é preto apenas pelo pixel central do quadrado
                    int centerX = x + squareSize / 2;
                    int centerY = y + squareSize / 2;

                    if (centerX < width && centerY < height && imagem.getRGB(centerX, centerY) == black.getRGB()) {
                        encontrouPreto = true;
                    }

                    if (!encontrouPreto) {
                        // Se ainda não encontrou um quadrado preto, pintamos o quadrado
                        g2.setColor(Color.RED);
                        g2.fillRect(x, y, squareSize, squareSize);
                    } else {
                        // Se encontrou um quadrado preto, pare de pintar nessa linha
                        break;
                    }
                }
            }

            // Finaliza o desenho
            g2.dispose();

            // Salva a imagem modificada
            ImageIO.write(imagem, "png", new File("output_lateral.png"));
            System.out.println("Imagem colorida salva com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao processar a imagem: " + e.getMessage());
        }
    }
}
