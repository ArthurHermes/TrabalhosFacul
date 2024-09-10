import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class FloodFill {
    public static void floodFillPilha(BufferedImage imagem, int x, int y, int novaCor) {
        Pilha<int[]> pilha = new Pilha<>();
        int corAntiga = imagem.getRGB(x, y);
        
        if (corAntiga == novaCor) return;
        
        pilha.empilhar(new int[]{x, y});

        while (!pilha.estaVazia()) {
            int[] ponto = pilha.desempilhar();
            int px = ponto[0], py = ponto[1];

            if (px < 0 || py < 0 || px >= imagem.getWidth() || py >= imagem.getHeight()) continue;

            if (imagem.getRGB(px, py) == corAntiga) {
                imagem.setRGB(px, py, novaCor);
                pilha.empilhar(new int[]{px + 1, py});
                pilha.empilhar(new int[]{px - 1, py});
                pilha.empilhar(new int[]{px, py + 1});
                pilha.empilhar(new int[]{px, py - 1});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedImage imagem = ImageIO.read(new File("teste.png"));
        int novaCor = 0xFFFF0000;  // Vermelho em formato ARGB
        
        floodFillPilha(imagem, 10, 10, novaCor);
        ImageIO.write(imagem, "png", new File("imagem_modificada.png"));
    }
}
