package model;

public class Tree {
    private final TreeSize size;
    private final TreeType type;
    private double relX;
    private final double relY;

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

    public void move(double x) {
        relX = x;
    }
}
