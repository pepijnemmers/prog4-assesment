package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class LeafTreePainter extends TreePainter {
    private static final double LEAF_SIZE = 200;

    @Override
    protected Pane drawTree() {
        Circle bush = new Circle(LEAF_SIZE / 2);
        bush.setCenterX(LEAF_SIZE / 2);
        bush.setCenterY(LEAF_SIZE / 2);

        bush.setFill(tree.getSize().getColor());
        bush.setStrokeType(StrokeType.INSIDE);
        bush.setStrokeWidth(STROKE_WIDTH);
        bush.setStroke(Color.BLACK);

        return bush;
    }
}
