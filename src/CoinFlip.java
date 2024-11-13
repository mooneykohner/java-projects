// Imports Classes for buttons, labels, scenes, and other objects.
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class CoinFlip extends Application { // Extends class through JavaFX application.

    private int heads = 0; // Initializes variable for tracking amount of times flip results in heads.
    private int tails = 0; // Initializes variable for tracking amount of times flip results in tails.

    private int coinsFlipped = 0; // Initializes variable for the amount of times a coin is flipped.


    public static void main(String[] args) {
        launch(args); // Launches the application window.
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
        Label coinsFlippedLabel = new Label("");

        flipCoinButton.setOnAction(e -> flipCoin(flipCoinResultLabel, headsAmountLabel, tailsAmountLabel, coinsFlippedLabel));

        VBox layout = new VBox(10, flipCoinResultLabel, flipCoinButton,  headsAmountLabel, tailsAmountLabel, coinsFlippedLabel);
        layout.setStyle("-fx-padding: 20px; -fx-alignment: center; -fx-font-size: 50px;"); // CSS styling for VBox
        return layout; // Returns layout for Scene.
    }

    public void flipCoin(Label flipCoinResultLabel, Label headsAmountLabel, Label tailsAmountLabel, Label coinsFlippedLabel) {
        int random = (int) (Math.random() * 2) + 1;

        if (random == 1) {
            flipCoinResultLabel.setText("Heads!");
            heads++;
        } else {
            flipCoinResultLabel.setText("Tails!");
            tails++;
        }
        coinsFlipped++;

        double coinsFlippedHeadsRatio = Math.floor((double) heads / coinsFlipped * 100);
        double coinsFlippedTailsRatio = Math.floor((double) tails / coinsFlipped * 100);

        headsAmountLabel.setText("Heads: " + heads);
        tailsAmountLabel.setText("Tails: " + tails);
        coinsFlippedLabel.setText(coinsFlippedHeadsRatio + "%" + " / " + coinsFlippedTailsRatio + "%");
    }
}

