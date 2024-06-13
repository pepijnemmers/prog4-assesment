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
    protected Shape drawTreeTop(Tree tree) {
        Path bush = new Path();
        bush.getElements().add(new MoveTo(LEAF_WIDTH / 2, 0));
        bush.getElements().add(new LineTo(0, LEAF_HEIGHT));
        bush.getElements().add(new LineTo(LEAF_WIDTH, LEAF_HEIGHT));
        bush.getElements().add(new ClosePath());

        bush.setFill(tree.getSize().getColor());
        bush.setStrokeType(StrokeType.INSIDE);
        bush.setStrokeWidth(STROKE_WIDTH);
        bush.setStroke(Color.BLACK);

        return bush;
    }
}
