package view;

import controller.Controller;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.World;

public class PaintingPane extends StackPane {
    private World world;

    public PaintingPane(Controller controller) {
        // draw background
        Pane sky = new Pane();
        sky.setStyle("-fx-background-color: #87CEEB;");

        Pane ground = new Pane();
        ground.setStyle("-fx-background-color: #8b6913;");

        VBox background = new VBox();
        VBox.setVgrow(sky, Priority.ALWAYS);
        VBox.setVgrow(ground, Priority.ALWAYS);
        background.getChildren().addAll(sky, ground);
        
        getChildren().addAll(background);
    }
}
