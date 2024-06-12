package controller;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.PaintingPane;
import view.PaintingScene;
import view.RootPane;

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
        stage.setResizable(false); // TODO resizable

        // show stage
        stage.setScene(new PaintingScene(new RootPane()));
        stage.show();
    }
}
