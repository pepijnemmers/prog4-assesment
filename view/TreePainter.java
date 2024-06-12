package view;

import javafx.scene.layout.Pane;
import model.Tree;

abstract class TreePainter {
    protected final static int STROKE_WIDTH = 2;

    public Pane paint(Tree tree, double paintingWidth, double paintingHeight) {
        double x = tree.getRelX() / 100 * paintingWidth;
        double y = tree.getRelY() / 100 * paintingHeight;
        Pane paneWithTree = drawTree(tree);

        double scale = tree.getSize().getScale() / 100;

        paneWithTree.setScaleX(scale);
        paneWithTree.setScaleY(scale);

        double width = paneWithTree.getBoundsInLocal().getWidth();
        double height = paneWithTree.getBoundsInLocal().getHeight();

        paneWithTree.setLayoutX(x - (width * (scale + 1) / 2));
        paneWithTree.setLayoutY(y - (height * (scale + 1) / 2));

        return paneWithTree;
    }

    protected abstract Pane drawTree();
}
