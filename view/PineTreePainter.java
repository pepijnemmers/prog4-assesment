package view;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import model.Tree;

public class PineTreePainter extends TreePainter {
    private static final double LEAF_WIDTH = 150;
    private static final double LEAF_HEIGHT = 200;

    @Override
    protected Pane drawTree() {
        Polygon bush = new Polygon(
            0, 0,
            50, 50,
            100, 0,
            50, 50
        );
        bush.setFill(Color.YELLOW);

        bush.setFill(tree.getSize().getColor());
        bush.setStrokeType(StrokeType.INSIDE);
        bush.setStrokeWidth(STROKE_WIDTH);
        bush.setStroke(Color.BLACK);

        return bush;
    }
}
