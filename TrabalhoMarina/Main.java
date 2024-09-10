import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedImage imagem = ImageIO.read(new File("TrabalhoMarina\\teste.png"));
            int novaCor = 0xFFFF0000;  // Cor vermelha no formato ARGB (com alfa)

            // Aplica o Flood Fill a partir do ponto (1, 1)
            FloodFill.floodFillPilha(imagem, 1, 1, novaCor);

            // Salva a imagem modificada
            ImageIO.write(imagem, "png", new File("imagem_modificada.png"));
        } catch (IOException e) {
            System.out.println("Erro ao processar a imagem: " + e.getMessage());
        }
    }
}
