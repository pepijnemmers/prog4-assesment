package controller;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.PaintingScene;

public class Controller extends Application {
    public static void startup(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // stage settings
        stage = new Stage();
        stage.setTitle("Pepijn Emmers - Painting");
        stage.getIcons().add(new Image("/resources/pics/favicon.jpg"));
        stage.setWidth(800);
        stage.setHeight(600);

        // show stage
        stage.setScene(new PaintingScene(this));
        stage.show();
    }
}
