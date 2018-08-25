package us.rlit.client;


import us.rlit.game.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rob on 10/11/16.
 */
public class ClientController implements Initializable {
    private Game game;
    private boolean quitting = false;

    @FXML
    private Label prompt;

    @FXML
    private TextField guess;

    @FXML
    private Label response;

    @FXML
    private Button quit;

    @FXML
    private Button again;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        game = new Game();
        game.start();
    }

    @FXML
    private void onEnter(ActionEvent event) {
        if (game.isGameOver()) {
            guess.setText("");
            return;
        }
        quitting = false;
        System.out.println(guess.getText());
        guess(guess.getText());
        guess.setText("");
    }

    @FXML
    private void guess(String input) {
        String gameResponse = "Guess again.";
        Integer theGuess = null;
        try {
            theGuess = Integer.parseInt(input);
        } catch (Exception e) {
            gameResponse = "Invalid input";
            System.out.println(gameResponse);
            response.setText(gameResponse);
            return;
        }
        if (game.guess(theGuess)) {
            gameResponse = "Guessed right on try " + game.getGuesses() + "!";
            again.setDisable(false);
            again.setVisible(true);
            gameResponse += "\nCorrect answer was " + game.getNumber();
            game.setGameOver(true);
            prompt.setText("Game Over.");
        } else {
            if (game.getDirection() < 1) {
                gameResponse = "Too low!";
            } else {
                gameResponse = "Too high!";
            }
        }
        System.out.println(gameResponse);
        response.setText(gameResponse);

    }


    public void quit(ActionEvent actionEvent) {
        if (quitting == true) {
            System.exit(0);
        }
        quitting = true;
        quit.setText("Yes!");
        response.setText("Really Quit!?");
        again.setDisable(false);
        again.setVisible(true);
    }

    public void again(ActionEvent actionEvent) {
        quitting = false;
        game.setGameOver(false);
        quit.setText("Quit");
        response.setText("Lets go! Good luck.");
        guess.setText("");
        prompt.setText("Enter a number between 1 and 100");
        again.setDisable(true);
        again.setVisible(false);
        game.start();
    }
}
