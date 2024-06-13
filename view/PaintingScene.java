package view;

import com.sun.xml.internal.bind.v2.TODO;
import controller.Controller;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PaintingScene extends Scene {
    private final Controller controller;
    public final PaintingPane paintingPane;

    public PaintingScene(Controller controller) {
        super(new Pane());
        this.controller = controller;

        BorderPane root = new BorderPane();
        MenuBar menuBar = createMenuBar();
        paintingPane = new PaintingPane(controller);
        root.setTop(menuBar);
        root.setCenter(paintingPane);

        setRoot(root);

        // on resize listener
        widthProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(paintingPane::refresh);
        });
        heightProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(paintingPane::refresh);
        });
    }

    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        // file
        Menu fileMenu = new Menu("File");
        MenuItem loadMI = new MenuItem("Load painting...");
        loadMI.setOnAction(e -> controller.loadWorld());

        MenuItem saveMI = new MenuItem("Save painting as...");
        saveMI.setOnAction(e -> controller.saveWorld());

        MenuItem exitMI = new MenuItem("Exit");
        exitMI.setOnAction(e -> System.exit(0));

        fileMenu.getItems().addAll(loadMI, saveMI, exitMI);

        // tree
        Menu treeMenu = new Menu("Tree");
        MenuItem addLeafMI = new MenuItem("Add Leaf Tree");
        addLeafMI.setOnAction(e -> controller.addLeafTree());

        MenuItem addPineMI = new MenuItem("Add Pine Tree");
        addPineMI.setOnAction(e -> controller.addPineTree());

        MenuItem addHundredMI = new MenuItem("Add 100 Trees");
        addHundredMI.setOnAction(e -> controller.addHundredTrees());

        MenuItem clearMI = new MenuItem("Clear All Trees");
        clearMI.setOnAction(e -> controller.clearAllTrees());

        treeMenu.getItems().addAll(addLeafMI, addPineMI, addHundredMI, clearMI);

        // autograph
        Menu autographMenu = new Menu("Autograph Font");
        ToggleGroup autographGroup = new ToggleGroup();

        RadioMenuItem greatVibesMI = new RadioMenuItem("Great Vibes");
        greatVibesMI.setToggleGroup(autographGroup);
        greatVibesMI.setOnAction(e -> controller.changeAutographFont("GreatVibes"));
        greatVibesMI.setSelected(true);

        RadioMenuItem handdnaMI = new RadioMenuItem("Handwriting DNA");
        handdnaMI.setToggleGroup(autographGroup);
        handdnaMI.setOnAction(e -> controller.changeAutographFont("handdna"));

        RadioMenuItem homemadeAppleMI = new RadioMenuItem("Homemade Apple");
        homemadeAppleMI.setToggleGroup(autographGroup);
        homemadeAppleMI.setOnAction(e -> controller.changeAutographFont("HomemadeApple"));

        RadioMenuItem leckerliOneMI = new RadioMenuItem("Leckerli One");
        leckerliOneMI.setToggleGroup(autographGroup);
        leckerliOneMI.setOnAction(e -> controller.changeAutographFont("LeckerliOne"));

        RadioMenuItem pwSignatureMI = new RadioMenuItem("PW Signature");
        pwSignatureMI.setToggleGroup(autographGroup);
        pwSignatureMI.setOnAction(e -> controller.changeAutographFont("PWSignatureTwo"));

        RadioMenuItem quickhandMI = new RadioMenuItem("Quickhand");
        quickhandMI.setToggleGroup(autographGroup);
        quickhandMI.setOnAction(e -> controller.changeAutographFont("Quikhand"));

        RadioMenuItem tommysMI = new RadioMenuItem("Tommys");
        tommysMI.setToggleGroup(autographGroup);
        tommysMI.setOnAction(e -> controller.changeAutographFont("tommys"));

        autographMenu.getItems().addAll(greatVibesMI, handdnaMI, homemadeAppleMI, leckerliOneMI, pwSignatureMI, quickhandMI, tommysMI);

        // movie
        Menu movieMenu = new Menu("Movie");
        CheckMenuItem playMI = new CheckMenuItem("Play");
        playMI.setOnAction(e -> System.out.println("Play")); // TODO
        movieMenu.getItems().add(playMI);

        // add to menu bar
        menuBar.getMenus().addAll(fileMenu, treeMenu, autographMenu, movieMenu);

        return menuBar;
    }
}
