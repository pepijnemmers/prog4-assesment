package view;

import controller.Controller;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.Tree;
import model.TreeSize;
import model.TreeType;
import model.World;

public class PaintingPane extends StackPane {
    private World world;
    private final Text autograph;

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

        // autograph
        autograph = new Text("Pepijn Emmers");
        controller.changeAutographFont("GreatVibes");

        HBox autographPane = new HBox();
        autographPane.setAlignment(Pos.BOTTOM_RIGHT);
        autographPane.setPadding(new Insets(15));
        autographPane.getChildren().add(autograph);

        getChildren().addAll(background, content, autographPane);

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

    public void changeAutographFont(Font font) {
        getChildren().remove(autograph);
        autograph.setFont(font);
        getChildren().add(autograph);
    }
}
