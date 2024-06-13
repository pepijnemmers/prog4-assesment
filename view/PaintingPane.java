package view;

import controller.Controller;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import model.Tree;
import model.TreeType;
import model.World;

import java.util.Comparator;

public class PaintingPane extends StackPane {
    private final Controller controller;
    public final Pane content;
    public final Text autograph;

    public PaintingPane(Controller controller) {
        this.controller = controller;

        // draw background
        Pane sky = new Pane();
        sky.setStyle("-fx-background-color: #87CEEB;");

        Pane ground = new Pane();
        ground.setStyle("-fx-background-color: #8b6913;");

        VBox background = new VBox();
        VBox.setVgrow(sky, Priority.ALWAYS);
        VBox.setVgrow(ground, Priority.ALWAYS);
        background.getChildren().addAll(sky, ground);

        content = new Pane();

        // autograph
        autograph = new Text("Pepijn Emmers");

        HBox autographPane = new HBox();
        autographPane.setMouseTransparent(true);
        autographPane.setAlignment(Pos.BOTTOM_RIGHT);
        autographPane.setPadding(new Insets(15));
        autographPane.getChildren().add(autograph);

        getChildren().addAll(background, content, autographPane);

        Platform.runLater(this::refresh);
    }

    public void refresh() {
        // clear pane
        content.getChildren().clear();

        // get world from controller
        World world = controller.getWorld();
        if (world == null) return;

        // sort trees by y-coordinate
        world.getTrees().sort(Comparator.comparingDouble(Tree::getRelY));

        // draw trees
        for (Tree tree : world.getTrees()) {
            TreePainter painter = tree.getType() == TreeType.LEAF ? new LeafTreePainter() : new PineTreePainter();
            content.getChildren().add(painter.paint(tree, this));
        }
    }
}
