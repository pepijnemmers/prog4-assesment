package model;

public class Tree {
    private TreeSize size;
    private TreeType type;
    private double relX;
    private double relY;

    public Tree(TreeSize size, TreeType type, double relX, double relY) {
        this.size = size;
        this.type = type;
        this.relX = relX;
        this.relY = relY;
    }

    public TreeSize getSize() {
        return size;
    }

    public TreeType getType() {
        return type;
    }

    public double getRelX() {
        return relX;
    }

    public double getRelY() {
        return relY;
    }

    public void move() {

    }
}
