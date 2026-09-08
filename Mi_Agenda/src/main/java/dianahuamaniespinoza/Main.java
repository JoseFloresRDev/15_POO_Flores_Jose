package dianahuamaniespinoza;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        URL fxml = getClass().getResource("/welcome.fxml");

        if (fxml == null) {
            throw new RuntimeException("No se encontró welcome.fxml");
        }

        Parent root = FXMLLoader.load(fxml);

        Scene scene = new Scene(root, 402, 852);

        stage.setTitle("Mi Agenda");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}