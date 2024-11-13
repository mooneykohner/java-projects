import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;


public class TutorialFX extends Application {
    private int randomNumber = (int) (Math.random() * 10) + 1;
    private int userAttempts = 0;

    @Override // Overrides the starting method from the Application class.

    public void start(Stage primaryStage) {
        // Create the root layout of the scene

        // UI Elements
        Label instructionsLabel = new Label("Guess a number between 1 and 10: "); // Creates an object from Label instructing user input.
        VBox layout = getvBox(instructionsLabel);

        // Create a scene using the root layout, then define width and height of window.
        Scene scene = new Scene(layout, 300, 250); // Directly uses the VBox 'layout' as the root.

        // Sets title of the application.
        primaryStage.setTitle("NUMBER GUESSER");

        // Sets scene.
        primaryStage.setScene(scene);

        // Displays scene.
        primaryStage.show();
    }

    private VBox getvBox(Label instructionsLabel) {
        TextField guessInput = new TextField(); // Prompts user and allows for input.
        Button submitButton = new Button("Submit"); // Creates an object from Button that allows the user to submit their guess.
        Label feedbackLabel = new Label(""); // For inputting a guess.
        Label attemptsLabel = new Label(""); // Total attempts until a correct guess is made.
        Label leastAttemptsLabel = new Label(""); // Shows the least attempts made.

        // Action for using submitButton
        submitButton.setOnAction(e -> handleGuess(guessInput, feedbackLabel, attemptsLabel, leastAttemptsLabel));

        // Sets up the layout of the elements in the application.
        VBox layout = new VBox(10, instructionsLabel, guessInput, submitButton, feedbackLabel, attemptsLabel, leastAttemptsLabel);
        layout.setStyle("-fx-padding: 20px; -fx-background-color: white;");
        return layout;
    }

    public void handleGuess(TextField guessInput, Label feedbackLabel, Label attemptsLabel, Label leastAttemptsLabel) {
        // Receives user input in the form of an integer.
        try {
            int userGuess = Integer.parseInt(guessInput.getText());

            userAttempts++; // Increases amount of times number has been guessed.
            attemptsLabel.setText("Attempts: " + userAttempts); // Returns value of userAttempts to Label attemptsLabel.

            if (userGuess > randomNumber) {
                feedbackLabel.setText("That's too high!");
            } else if (userGuess < randomNumber) {
                feedbackLabel.setText("That's too low!");
            } else { // Resets game
                feedbackLabel.setText("That's correct!");

                int leastAttempts = 10;

                if (userAttempts < leastAttempts) {
                    leastAttempts = userAttempts;
                }

                randomNumber = (int) (Math.random() * 10) + 1;
                userAttempts = 0;


                attemptsLabel.setText("Attempts: " + userAttempts);
                leastAttemptsLabel.setText("Least Attempts: " + leastAttempts);

            }

        } catch (NumberFormatException e) {
            feedbackLabel.setText("Please enter a valid number between 1 and 10.");
        }
    }

    public static void main(String[] args) {
        launch(args); // Starts JavaFX application.

    }
}