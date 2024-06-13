package model;

import java.util.ArrayList;

public class World {
    private final ArrayList<Tree> trees;

    public World() {
        trees = new ArrayList<Tree>();
    }

    public ArrayList<Tree> getTrees() {
        return trees;
    }

    public void addTree(Tree tree) {
        trees.add(tree);
    }

    public void clearTrees() {
        trees.clear();
    }

    public void moveTrees(double speed) {
        for (Tree tree : trees) {
            double moveFactor = 0.1 * (0.8 + (tree.getRelY() / 100));
            double moveDistance = speed * moveFactor;

            tree.move(tree.getRelX() + moveDistance);
            if (tree.getRelX() > 110) {
                tree.move(-10);
            }
        }
    }
}
