// Imports Classes for buttons, labels, scenes, and other objects.
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.stage.*;

public class CoinFlip extends Application { // Extends class through JavaFX application.

    private int heads = 0;
    private int tails = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override // Overrides default method from the Application class.
    public void start(Stage primaryStage) {
        VBox layout = getVBox();

        Scene scene = new Scene(layout, 300, 250);

        primaryStage.setTitle("FLIP A COIN");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private VBox getVBox() {
        Label flipCoinResultLabel = new Label("");

        Button flipCoinButton = new Button("Flip a coin!");

        Label headsAmountLabel = new Label("");
        Label tailsAmountLabel = new Label("");

        flipCoinButton.setOnAction(e -> flipCoin(flipCoinResultLabel, headsAmountLabel, tailsAmountLabel));

        VBox layout = new VBox(10, flipCoinResultLabel, flipCoinButton,  headsAmountLabel, tailsAmountLabel);
        layout.setStyle("-fx-padding: 20px; -fx-alignment: center; -fx-font-size: 50px;");
        return layout;
    }

    public void flipCoin(Label flipCoinResultLabel, Label headsAmountLabel, Label tailsAmountLabel) {
        int random = (int) (Math.random() * 2) + 1;

        Media coinFlipSound = new Media(getClass().getResource("coinflip.mp3").toExternalForm());
        MediaPlayer coinFlipSoundPlayer = new MediaPlayer(coinFlipSound);
        coinFlipSoundPlayer.play();


        if (random == 1) {
            flipCoinResultLabel.setText("Heads!");
            heads++;
        } else {
            flipCoinResultLabel.setText("Tails!");
            tails++;
        }
        headsAmountLabel.setText("Heads: " + heads);
        tailsAmountLabel.setText("Tails: " + tails);
    }
}

