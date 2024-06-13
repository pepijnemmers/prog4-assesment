package controller;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
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
    private static final String BASIC_FOLDER = "resources/paintings";
    private static final double MOVIE_SPEED = 100;

    private Stage stage;
    private PaintingScene paintingScene;
    private World world;
    private boolean playMovie;

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
        playMovie = false;

        // show stage
        paintingScene = new PaintingScene(this);
        changeAutographFont("GreatVibes");
        stage.setScene(paintingScene);
        stage.show();

        // Start animation thread
        startAnimation();
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

        File startFolder = new File(BASIC_FOLDER);
        if (startFolder.exists() && startFolder.isDirectory()) {
            fileChooser.setInitialDirectory(startFolder);
        }

        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            world = FileIO.read(selectedFile.getAbsolutePath());
            paintingScene.paintingPane.refresh();
        }
    }

    public void saveWorld() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Painting Files", "*.painting"));

        File startFolder = new File(BASIC_FOLDER);
        if (startFolder.exists() && startFolder.isDirectory()) {
            fileChooser.setInitialDirectory(startFolder);
        }

        File selectedFile = fileChooser.showSaveDialog(new Stage());
        if (selectedFile != null) {
            FileIO.write(selectedFile.getAbsolutePath(), world);
        }
    }

    public void toggleMovie() {
        playMovie = !playMovie;
    }

    private void startAnimation() {
        AnimationTimer animationTimer = new AnimationTimer() {
            long lastUpdate = 0;

            @Override
            public void handle(long now) {
                double deltaTime = (now - lastUpdate) / 1e9;
                if (deltaTime > 1.0 / 24.0) {
                    moveTrees(deltaTime * MOVIE_SPEED);
                    paintingScene.paintingPane.refresh();
                    lastUpdate = now;
                }
            }
        };
        animationTimer.start();
    }

    private void moveTrees(double speed) {
        if (playMovie) {
            world.moveTrees(speed);
        }
    }
}
