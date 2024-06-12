package view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class LeafTreePainter extends TreePainter {
    private static final double LEAF_SIZE = 200;
    private static final double TRUNK_WIDTH = 20;
    private static final double TRUNK_HEIGHT = 100;

    @Override
    protected Pane drawTree() {
        Circle bush = new Circle(LEAF_SIZE / 2);
        bush.setCenterX(LEAF_SIZE / 2);
        bush.setCenterY(LEAF_SIZE / 2);

        bush.setFill(tree.getSize().getColor());
        bush.setStrokeType(StrokeType.INSIDE);
        bush.setStrokeWidth(STROKE_WIDTH);
        bush.setStroke(Color.BLACK);

        // todo zie andere todo
        Rectangle trunk = new Rectangle(TRUNK_WIDTH, TRUNK_HEIGHT);
        trunk.setFill(Color.web("#433000"));
        trunk.setStrokeType(StrokeType.INSIDE);
        trunk.setStrokeWidth(STROKE_WIDTH);
        trunk.setStroke(Color.BLACK);

        trunk.setLayoutX(LEAF_SIZE / 2 + (-TRUNK_WIDTH / 2));
        trunk.setLayoutY(LEAF_SIZE);

        return new Pane(bush, trunk);
    }
}
