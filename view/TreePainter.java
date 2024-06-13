package view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import model.Tree;

abstract class TreePainter {
    protected final static int STROKE_WIDTH = 2;
    private static final double TRUNK_WIDTH = 25;

    public Pane paint(Tree tree, double paintingWidth, double paintingHeight) {
        // calculate the position
        double x = tree.getRelX() / 100 * paintingWidth;
        double y = tree.getRelY() / 100 * paintingHeight;

        // draw the tree top
        Shape treeTop = drawTreeTop(tree);

        // draw the trunk
        double trunkHeight = treeTop.getBoundsInLocal().getHeight() / 2;
        Rectangle trunk = new Rectangle(TRUNK_WIDTH, trunkHeight);
        trunk.setFill(Color.web("#433000"));
        trunk.setStrokeType(StrokeType.INSIDE);
        trunk.setStrokeWidth(STROKE_WIDTH);
        trunk.setStroke(Color.BLACK);

        // position the trunk
        trunk.setLayoutX(treeTop.getBoundsInLocal().getWidth() / 2 + (-TRUNK_WIDTH / 2));
        trunk.setLayoutY(treeTop.getBoundsInLocal().getHeight() - 2);

        // combine the tree top and trunk
        Pane paneWithTree = new Pane(treeTop, trunk);

        // scale the tree
        double scale = tree.getSize().getScale() / 100;
        paneWithTree.setScaleX(scale);
        paneWithTree.setScaleY(scale);

        // position the tree
        double width = paneWithTree.getBoundsInLocal().getWidth();
        double height = paneWithTree.getBoundsInLocal().getHeight();

        paneWithTree.setLayoutX(x - (width * (scale + 1) / 2));
        paneWithTree.setLayoutY(y - (height * (scale + 1) / 2));

        // return the tree
        return paneWithTree;
    }

    protected abstract Pane drawTree();
}
