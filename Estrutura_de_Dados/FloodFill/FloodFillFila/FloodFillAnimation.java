package FloodFill.FloodFillFila;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class FloodFillAnimation extends JFrame {
    private int currentImageIndex = 0;
    private final File[] imageFiles;
    private final String nomeImagemQuadradoRosa = "quadrado_rosa.png"; // Substitua pelo nome correto

    public FloodFillAnimation(File[] imageFiles) {
        this.imageFiles = imageFiles;
        setTitle("Animação Flood Fill");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
        showNextImage();
    }

    private void showNextImage() {
        if (currentImageIndex < imageFiles.length) {
            try {
                BufferedImage img = ImageIO.read(imageFiles[currentImageIndex]);
                JLabel label = new JLabel(new ImageIcon(img));
                getContentPane().removeAll();
                add(label, BorderLayout.CENTER);
                revalidate();
                repaint();

                // Verifica se a imagem atual é o quadrado rosa
                if (imageFiles[currentImageIndex].getName().equals(nomeImagemQuadradoRosa)) {
                    System.out.println("Animação parada na imagem do quadrado rosa.");
                    return; // Para a animação se a imagem for o quadrado rosa
                }

                currentImageIndex++;
                Timer timer = new Timer(100, e -> showNextImage());
                timer.setRepeats(false);
                timer.start();
            } catch (Exception e) {
                System.err.println("Erro ao carregar a imagem: " + imageFiles[currentImageIndex].getName());
                e.printStackTrace();
            }
        } else {
            System.exit(0); 
        }
    }

    public static void main(String[] args) {
        File dir = new File("Estrutura_de_Dados/FloodFill/FloodFillFila/out");
        File[] imageFiles = dir.listFiles((d, name) -> name.endsWith(".png"));

        if (imageFiles != null && imageFiles.length > 0) {
            Arrays.sort(imageFiles, Comparator.comparingInt(FloodFillAnimation::extractNumberFromFileName));
            new FloodFillAnimation(imageFiles);
        } else {
            System.err.println("Nenhuma imagem encontrada.");
        }
    }

    private static int extractNumberFromFileName(File file) {
        String fileName = file.getName();
        String numberPart = fileName.replaceAll("\\D+", ""); 
        if (numberPart.isEmpty()) {
            return Integer.MAX_VALUE; // Coloca imagens sem número no final da lista
        }
        return Integer.parseInt(numberPart); 
    }
}
