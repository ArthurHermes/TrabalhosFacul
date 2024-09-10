import java.awt.image.BufferedImage;

public class FloodFill {

    public static void floodFillPilha(BufferedImage imagem, int x, int y, int novaCor) {
        Pilha<int[]> pilha = new Pilha<>();
        int corAntiga = imagem.getRGB(x, y) & 0xFFFFFF; // Ignora o canal alfa

        // Se a cor antiga for a mesma que a nova, não faz nada
        if ((novaCor & 0xFFFFFF) == corAntiga) return;

        pilha.empilhar(new int[]{x, y});

        while (!pilha.estaVazia()) {
            int[] ponto = pilha.desempilhar();
            int px = ponto[0], py = ponto[1];

            // Verifica se o ponto está dentro dos limites da imagem
            if (px < 0 || py < 0 || px >= imagem.getWidth() || py >= imagem.getHeight()) continue;

            // Se o ponto tem a cor antiga, pinta com a nova cor e adiciona os vizinhos à pilha
            if ((imagem.getRGB(px, py) & 0xFFFFFF) == corAntiga) {
                imagem.setRGB(px, py, novaCor); // Aplica nova cor com alfa incluído
                pilha.empilhar(new int[]{px + 1, py}); // Vizinho à direita
                pilha.empilhar(new int[]{px - 1, py}); // Vizinho à esquerda
                pilha.empilhar(new int[]{px, py + 1}); // Vizinho abaixo
                pilha.empilhar(new int[]{px, py - 1}); // Vizinho acima
            }
        }
    }
}
