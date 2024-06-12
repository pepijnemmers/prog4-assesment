package view;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import model.Tree;

abstract class TreePainter {
    public void paint(Tree tree, double paintingWidth, double paintingHeight) {
        double x = tree.getRelX() / 100 * paintingWidth;
        double y = tree.getRelY() / 100 * paintingHeight;
        double size = ((tree.getRelY() - 50) / 50 * 180) + 20;
        drawTree();
    }

    protected abstract Pane drawTree();
}
