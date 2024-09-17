package FloodFill;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FloodFillViewer extends Application {

    private List<Image> images = new ArrayList<>();
    private int currentImageIndex = 0;

    @Override
    public void start(Stage primaryStage) {
        // Carregar todas as imagens salvas
        loadImages("out"); // O diretório onde você salva as imagens

        // Verificar se existem imagens
        if (images.isEmpty()) {
            System.out.println("Nenhuma imagem encontrada.");
            return;
        }

        // Criar um ImageView para exibir as imagens
        ImageView imageView = new ImageView();
        imageView.setImage(images.get(currentImageIndex));

        // Definir o layout
        StackPane root = new StackPane(imageView);
        Scene scene = new Scene(root, 800, 600);

        // Configurar a troca de imagens usando uma Timeline
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            currentImageIndex = (currentImageIndex + 1) % images.size(); // Loop pelas imagens
            imageView.setImage(images.get(currentImageIndex));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE); // Repetir indefinidamente
        timeline.play();

        // Configurar o Stage
        primaryStage.setTitle("Flood Fill Image Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadImages(String directoryPath) {
        File dir = new File(directoryPath);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".png"));

        if (files != null) {
            for (File file : files) {
                try {
                    images.add(new Image(new FileInputStream(file)));
                } catch (FileNotFoundException e) {
                    System.out.println("Erro ao carregar imagem: " + file.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
