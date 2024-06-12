package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller extends Application {
    public static void startup(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Pane()); // TODO paintingscene

        stage = new Stage();
        stage.setTitle("Pepijn Emmers - Paining");
        stage.getIcons().add(new Image("/resources/pics/favicon.jpg"));
        stage.setHeight(600);
        stage.setWidth(800);
        stage.setResizable(false); // TODO resizable

        stage.setScene(scene);
        stage.show();
    }
}
