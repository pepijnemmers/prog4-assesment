package model;

import java.util.ArrayList;

public class World {
    private ArrayList<Tree> trees;

    public World() {
        trees = new ArrayList<Tree>();
    }

    public ArrayList<Tree> getTrees() {
        return trees;
    }

    public void addTree(Tree tree) {
        trees.add(tree);
    }

    public void moveTrees() {

    }
}
