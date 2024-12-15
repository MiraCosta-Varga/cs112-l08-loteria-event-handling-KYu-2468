package cs112.lab08;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.util.Random;

import java.io.IOException;

public class HelloApplication extends Application {

    //CONSTANTS
    private ImageView cardImageView;
    private Label messageLabel;
    private Random random = new Random();

    //array of LoteriaCards to use for game:
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };

    @Override
    public void start(Stage primaryStage) throws IOException {
        //removed FXML code, fill this in with components, scene, stage, etc.
        Label titleLabel = new Label("EChALE STEM Lotería");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #2e86de;");

        cardImageView = new ImageView();
        cardImageView.setFitWidth(200);
        cardImageView.setFitHeight(300);
        cardImageView.setPreserveRatio(true);

        messageLabel = new Label("Card Info!");
        messageLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #34495e;");

        Button drawCardButton = new Button("Draw Card");
        drawCardButton.setStyle("-fx-background-color: #28b463; -fx-text-fill: white; -fx-font-size: 14px;");
        drawCardButton.setOnAction(event -> drawRandomCard());

        VBox layout = new VBox(10, titleLabel, cardImageView, messageLabel, drawCardButton);
        layout.setStyle("-fx-alignment: center; -fx-padding: 15; -fx-background-color: #f7f9f9;");

        // Scene
        Scene scene = new Scene(layout, 350, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("EChALE STEM Lotería");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void drawRandomCard() {
        int randomIndex = random.nextInt(LOTERIA_CARDS.length);
        LoteriaCard selectedCard = LOTERIA_CARDS[randomIndex];

        cardImageView.setImage(selectedCard.getImage());
        messageLabel.setText("Card Name: " + selectedCard.getCardName() + "!");
    }
}