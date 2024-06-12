package model;

import javafx.scene.paint.Color;

public enum TreeSize {
    S("#04fe02"),
    M("#00d201"),
    L("#02a401"),
    XL("#007800"),
    XXL("#014a01");

    private final Color color;

    TreeSize(String hex) {
        color = Color.web(hex);
    }

    public Color getColor() {
        return color;
    }
}
