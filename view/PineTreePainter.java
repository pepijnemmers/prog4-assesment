package view;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import model.Tree;

public class PineTreePainter extends TreePainter {
    private static final double LEAF_WIDTH = 120;
    private static final double LEAF_HEIGHT = 200;
    private static final double TRUNK_WIDTH = 20;
    private static final double TRUNK_HEIGHT = 60;

    @Override
    protected Pane drawTree() {
        Polygon bush = new Polygon(
            0, 0,
            50, 50,
            100, 0,
            50, 50
        );
        bush.setFill(Color.YELLOW);

        Rectangle trunk = new Rectangle(TRUNK_WIDTH, TRUNK_HEIGHT);
        trunk.setFill(Color.web("#433000"));
        trunk.setStrokeType(StrokeType.INSIDE);
        trunk.setStrokeWidth(STROKE_WIDTH);
        trunk.setStroke(Color.BLACK);

        trunk.setLayoutX(LEAF_WIDTH / 2 + (-TRUNK_WIDTH / 2));
        trunk.setLayoutY(LEAF_HEIGHT);

        return new Pane(bush, trunk);
    }
}
