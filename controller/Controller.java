package controller;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import view.PaintingPane;
import view.PaintingScene;

public class Controller extends Application {
    private final PaintingScene paintingScene;

    private final Font greatVibes;
    private final Font handdna;
    private final Font homemadeApple;
    private final Font leckerliOne;
    private final Font pwSignatureTwo;
    private final Font quikhand;
    private final Font tommys;

    private static final int FONT_SIZE = 24;

    public Controller() {
        greatVibes = Font.loadFont(getClass().getResourceAsStream("/fonts/GreatVibes.ttf"), FONT_SIZE);
        handdna = Font.loadFont(getClass().getResourceAsStream("/fonts/handdna.ttf"), FONT_SIZE);
        homemadeApple = Font.loadFont(getClass().getResourceAsStream("/fonts/HomemadeApple.ttf"), FONT_SIZE);
        leckerliOne = Font.loadFont(getClass().getResourceAsStream("/fonts/LeckerliOne.ttf"), FONT_SIZE);
        pwSignatureTwo = Font.loadFont(getClass().getResourceAsStream("/fonts/PWSignaturetwo.ttf"), FONT_SIZE);
        quikhand = Font.loadFont(getClass().getResourceAsStream("/fonts/Quikhand.ttf"), FONT_SIZE);
        tommys = Font.loadFont(getClass().getResourceAsStream("/fonts/tommys.ttf"), FONT_SIZE);

        paintingScene = new PaintingScene(this);
    }

    public static void startup(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // stage settings
        stage = new Stage();
        stage.setTitle("Pepijn Emmers - Painting");
        stage.getIcons().add(new Image("/resources/pics/favicon.jpg"));
        stage.setWidth(800);
        stage.setHeight(600);

        // show stage
        stage.setScene(paintingScene);
        stage.show();
    }

    public void changeAutographFont(String fontName) {
        Font font;
        switch (fontName) {
            case "handdna":
                font = handdna;
                break;
            case "HomemadeApple":
                font = homemadeApple;
                break;
            case "LeckerliOne":
                font = leckerliOne;
                break;
            case "PWSignatureTwo":
                font = pwSignatureTwo;
                break;
            case "Quikhand":
                font = quikhand;
                break;
            case "tommys":
                font = tommys;
                break;
            default:
                font = greatVibes;
        }

        paintingScene.paintingPane.changeAutographFont(font);
    }
}
