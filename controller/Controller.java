package controller;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import view.PaintingScene;

public class Controller extends Application {
    private PaintingScene paintingScene;

    private static final int FONT_SIZE = 24;

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

}
