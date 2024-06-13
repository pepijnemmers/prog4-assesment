package controller;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Tree;
import model.TreeSize;
import model.TreeType;
import model.World;
import view.PaintingScene;

import java.io.File;
import java.util.Random;

public class Controller extends Application {
    private static final int FONT_SIZE = 24;
    private static final Random RANDOM = new Random();

    private Stage stage;
    private PaintingScene paintingScene;
    private World world;

    public static void startup(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        // stage settings
        stage = new Stage();
        stage.setTitle("Pepijn Emmers - Painting");
        stage.getIcons().add(new Image("/resources/pics/favicon.jpg"));
        stage.setWidth(800);
        stage.setHeight(600);

        // set world
        world = new World();

        // show stage
        paintingScene = new PaintingScene(this);
        changeAutographFont("GreatVibes");
        stage.setScene(paintingScene);
        stage.show();
    }

    public void changeAutographFont(String fontName) {
        Font font = getFont(fontName);
        if (font != null && paintingScene != null) {
            paintingScene.paintingPane.autograph.setFont(font);
        }
    }

    private Font getFont(String fontName) {
        String fontPath = "/resources/fonts/";
        switch (fontName) {
            case "handdna":
                fontPath += "handdna.ttf";
                break;
            case "HomemadeApple":
                fontPath += "HomemadeApple.ttf";
                break;
            case "LeckerliOne":
                fontPath += "LeckerliOne.ttf";
                break;
            case "PWSignatureTwo":
                fontPath += "PWSignatureTwo.ttf";
                break;
            case "Quikhand":
                fontPath += "Quikhand.ttf";
                break;
            case "tommys":
                fontPath += "tommys.ttf";
                break;
            default:
                fontPath += "GreatVibes.ttf";
                break;
        }
        return Font.loadFont(getClass().getResourceAsStream(fontPath), FONT_SIZE);
    }

    public World getWorld() {
        return world;
    }

    public TreeSize getRandomTreeSize() {
        return TreeSize.values()[(int) (Math.random() * TreeSize.values().length)];
    }

    public double getRandomRelY() {
        return 50 + RANDOM.nextInt(51); // 50 - 100 (is exclusive upper bound)
    }

    public double getRandomRelX() {
        return RANDOM.nextInt(101); // 0 - 100 (is exclusive upper bound)
    }

    public void addLeafTree() {
        Tree tree = new Tree(getRandomTreeSize(), TreeType.LEAF, getRandomRelX(), getRandomRelY());
        world.addTree(tree);
        paintingScene.paintingPane.refresh();
    }

    public void addPineTree() {
        Tree tree = new Tree(getRandomTreeSize(), TreeType.PINE, getRandomRelX(), getRandomRelY());
        world.addTree(tree);
        paintingScene.paintingPane.refresh();
    }

    public void addHundredTrees() {
        for (int i = 0; i < 100; i++) {
            if (RANDOM.nextBoolean()) {
                addLeafTree();
            } else {
                addPineTree();
            }
        }
    }

    public void clearAllTrees() {
        world.clearTrees();
        paintingScene.paintingPane.refresh();
    }

    public void loadWorld() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Painting Files", "*.painting"));

        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            world = FileIO.read(selectedFile.getAbsolutePath());
            paintingScene.paintingPane.refresh();
        }
    }
}
