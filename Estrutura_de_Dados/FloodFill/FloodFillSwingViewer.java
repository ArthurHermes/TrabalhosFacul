package FloodFill;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FloodFillSwingViewer extends JFrame {

    private List<ImageIcon> images = new ArrayList<>();
    private JLabel imageLabel;
    private int currentImageIndex = 0;

    public FloodFillSwingViewer() {
        // Carregar todas as imagens salvas
        loadImages("FloodFill\\out");

        // Configurar a janela
        setTitle("Flood Fill Image Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurar o JLabel para exibir a imagem
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        // Iniciar a exibição da primeira imagem
        if (!images.isEmpty()) {
            imageLabel.setIcon(images.get(currentImageIndex));
        } else {
            System.out.println("Nenhuma imagem encontrada.");
        }

        // Configurar o Timer para alternar as imagens a cada 1 segundo (1000ms)
        Timer timer = new Timer(100, e -> {
            currentImageIndex = (currentImageIndex + 1) % images.size();
            imageLabel.setIcon(images.get(currentImageIndex));
        });
        timer.start();
    }

    // Método para carregar imagens salvas do diretório
    private void loadImages(String directoryPath) {
        File dir = new File(directoryPath);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".png"));

        if (files != null) {
            for (File file : files) {
                images.add(new ImageIcon(file.getAbsolutePath()));
            }
        }
    }

    // Método principal para iniciar a aplicação
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FloodFillSwingViewer viewer = new FloodFillSwingViewer();
            viewer.setVisible(true);
        });
    }
}
