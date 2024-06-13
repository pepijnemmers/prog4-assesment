package model;

import javafx.scene.paint.Color;

public enum TreeSize {
    S("#04fe02", 20),
    M("#00d201", 40),
    L("#02a401", 60),
    XL("#007800", 80),
    XXL("#014a01", 100);

    private final Color color;
    private final double scale;

    TreeSize(String hex, double scale) {
        color = Color.web(hex);
        this.scale = scale;
    }

    public Color getColor() {
        return color;
    }

    public double getScale() {
        return scale;
    }
}
