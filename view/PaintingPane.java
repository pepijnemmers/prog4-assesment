package view;

import controller.Controller;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.Tree;
import model.TreeSize;
import model.TreeType;
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

        Pane content = new Pane();

        getChildren().addAll(background, content); // background, content, signature TODO

        World world = new World();
        world.addTree(new Tree(TreeSize.XXL, TreeType.LEAF, 30, 75));
        world.addTree(new Tree(TreeSize.M, TreeType.LEAF, 80, 75));
        world.addTree(new Tree(TreeSize.XL, TreeType.LEAF, 80, 75));
        world.addTree(new Tree(TreeSize.L, TreeType.PINE, 50, 75));

        Platform.runLater(() -> {
            for (Tree tree : world.getTrees()) {
                TreePainter painter = tree.getType() == TreeType.LEAF ? new LeafTreePainter() : new PineTreePainter();
                content.getChildren().add(painter.paint(tree, getWidth(), getHeight()));
            }
        });

    }
}
