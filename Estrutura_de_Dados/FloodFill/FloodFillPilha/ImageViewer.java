package FloodFill.FloodFillPilha;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageViewer extends JFrame {
    private int currentImageIndex = 0;
    private final File[] imageFiles;

    public ImageViewer(File[] imageFiles) {
        this.imageFiles = imageFiles;
        setTitle("Image Sequence");
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
                currentImageIndex++;
                Timer timer = new Timer(100, e -> showNextImage());
                timer.setRepeats(false);
                timer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Imagem exibida com sucesso!");
        }
    }

    public static void main(String[] args) {
        File dir = new File("Estrutura_de_Dados\\FloodFill\\FloodFillPilha\\out");
        File[] imageFiles = dir.listFiles((d, name) -> name.endsWith(".png"));

        if (imageFiles != null && imageFiles.length > 0) {
            Arrays.sort(imageFiles, Comparator.comparingInt(ImageViewer::extractNumberFromFileName));
            new ImageViewer(imageFiles);
        } else {
            System.out.println("No images found.");
        }
    }

    private static int extractNumberFromFileName(File file) {
        String fileName = file.getName();
        String numberPart = fileName.replaceAll("\\D+", ""); 
        return Integer.parseInt(numberPart); 
    }
}
