package view;

import javafx.scene.Cursor;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import model.Tree;

abstract class TreePainter {
    protected static final int STROKE_WIDTH = 2;
    private static final double TRUNK_WIDTH = 25;

    private PaintingPane paintingPane = null;

    /**
     * Paint the tree.
     * @param tree the tree to paint
     * @param paintingPane the painting pane
     * @return the pane with the tree
     */
    public Pane paint(Tree tree, PaintingPane paintingPane) {
        this.paintingPane = paintingPane;
        double paintingWidth = paintingPane.getWidth();
        double paintingHeight = paintingPane.getHeight();

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
        double scale = (tree.getSize().getScale() / 100) * (0.02 * tree.getRelY() - 0.8);
        paneWithTree.setScaleX(scale);
        paneWithTree.setScaleY(scale);

        // position the tree
        double width = paneWithTree.getBoundsInLocal().getWidth();
        double height = paneWithTree.getBoundsInLocal().getHeight();

        paneWithTree.setLayoutX(x - (width * (scale + 1) / 2));
        paneWithTree.setLayoutY(y - (height * (scale + 1) / 2));

        // drag and drop
        setDragAndDrop(paneWithTree, tree, paintingWidth, paintingHeight);

        // return the tree
        return paneWithTree;
    }

    /**
     * Draw the tree top.
     *
     * @param tree the tree to draw
     * @return the tree top
     */
    protected abstract Shape drawTreeTop(Tree tree);

    private void setDragAndDrop(Pane paneWithTree, Tree tree, double paintingWidth, double paintingHeight) {
        // create variables to store the offset
        final double[] offsetX = new double[1];
        final double[] offsetY = new double[1];

        paneWithTree.setOnMouseEntered(e -> paneWithTree.setCursor(Cursor.OPEN_HAND));

        // set the offset when the mouse is pressed (offset = mouse position - tree position)
        paneWithTree.setOnMousePressed(event -> {
            offsetX[0] = event.getSceneX() - paneWithTree.getLayoutX();
            offsetY[0] = event.getSceneY() - paneWithTree.getLayoutY();
            paneWithTree.setCursor(Cursor.CLOSED_HAND);
        });

        // move the tree when the mouse is dragged
        paneWithTree.setOnMouseDragged(event -> {
            double newX = event.getSceneX() - offsetX[0];
            double newY = event.getSceneY() - offsetY[0];
            paneWithTree.setLayoutX(newX);
            paneWithTree.setLayoutY(newY);
        });

        // move the tree (in the model) when the mouse is released
        paneWithTree.setOnMouseReleased(event -> {
            double newX = paneWithTree.getLayoutX() + event.getX() - offsetX[0] + paneWithTree.getBoundsInLocal().getWidth();
            double newY = paneWithTree.getLayoutY() + event.getY() - offsetY[0] + (paneWithTree.getBoundsInLocal().getHeight() / 2);
            double relX = newX / paintingWidth * 100;
            double relY = newY / paintingHeight * 100;

            // prevent the tree from flying in air
            if (relY < 50) relY = 50;

            tree.move(relX, relY);
            paintingPane.refresh();
        });
    }
}
