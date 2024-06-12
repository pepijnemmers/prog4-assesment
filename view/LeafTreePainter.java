package view;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
        bush.setFill(Color.RED);

        Rectangle trunk = new Rectangle(TRUNK_WIDTH, TRUNK_HEIGHT);
        trunk.setFill(Color.web("#433000"));

        return new VBox(bush, trunk);
    }
}
