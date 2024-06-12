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

    public void move() {

    }
}
