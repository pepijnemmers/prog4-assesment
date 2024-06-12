package view;

abstract class TreePainter {
    protected double relX;
    protected double relY;

    public TreePainter(double relX, double relY) {
        this.relX = relX;
        this.relY = relY;
    }

    public void paint(double paintingWidth, double paintingHeight) {
        double x = relX / 100 * paintingWidth;
        double y = relY / 100 * paintingHeight;
        double size = ((relY - 50) / 50 * 180) + 20;
        drawTree(size);
    }

    protected abstract void drawTree(double size);
}
