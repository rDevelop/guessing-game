package us.rlit.client;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by rob on 10/11/16.
 */
public class Client extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLClientController.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Guessing Game");
        stage.show();

        stage.setOnCloseRequest(event -> exit());
    }

    public void client(String[] args) {
        launch(args);
    }

    private void exit() {
        // may want to put more code here
        System.out.println("Exiting.");
        System.exit(0);
    }
}
