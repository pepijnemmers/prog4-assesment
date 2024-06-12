package view;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PaintingScene extends Scene {
    private final Controller controller;

    public PaintingScene(Controller controller) {
        super(new Pane());
        this.controller = controller;

        BorderPane root = new BorderPane();
        MenuBar menuBar = createMenuBar();
        PaintingPane paintingPane = new PaintingPane(controller);
        root.setTop(menuBar);
        root.setCenter(paintingPane);

        setRoot(root);
    }

    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        // file
        Menu fileMenu = new Menu("File");
        MenuItem loadMI = new MenuItem("Load painting...");
        loadMI.setOnAction(e -> System.out.println("Load painting...")); // TODO

        MenuItem saveMI = new MenuItem("Save painting as...");
        saveMI.setOnAction(e -> System.out.println("Save painting as...")); // TODO

        MenuItem exitMI = new MenuItem("Exit");
        exitMI.setOnAction(e -> System.exit(0));

        fileMenu.getItems().addAll(loadMI, saveMI, exitMI);

        // tree
        Menu treeMenu = new Menu("Tree");
        MenuItem addLeafMI = new MenuItem("Add Leaf Tree");
        addLeafMI.setOnAction(e -> System.out.println("Add Leaf Tree")); // TODO

        MenuItem addPineMI = new MenuItem("Add Pine Tree");
        addPineMI.setOnAction(e -> System.out.println("Add Pine Tree")); // TODO

        MenuItem addHundredMI = new MenuItem("Add 100 Trees");
        addHundredMI.setOnAction(e -> System.out.println("Add 100 Trees")); // TODO

        MenuItem clearMI = new MenuItem("Clear All Trees");
        clearMI.setOnAction(e -> System.out.println("Clear All Trees")); // TODO

        treeMenu.getItems().addAll(addLeafMI, addPineMI, addHundredMI, clearMI);

        // autograph
        Menu autographMenu = new Menu("Autograph Font");
        ToggleGroup autographGroup = new ToggleGroup();

        RadioMenuItem greatVibesMI = new RadioMenuItem("Great Vibes");
        greatVibesMI.setToggleGroup(autographGroup);
        greatVibesMI.setSelected(true);
        greatVibesMI.setOnAction(e -> System.out.println("Great Vibes")); // TODO

        RadioMenuItem handdnaMI = new RadioMenuItem("Handwriting DNA");
        handdnaMI.setToggleGroup(autographGroup);
        handdnaMI.setOnAction(e -> System.out.println("Handwriting DNA")); // TODO

        RadioMenuItem homemadeAppleMI = new RadioMenuItem("Homemade Apple");
        homemadeAppleMI.setToggleGroup(autographGroup);
        homemadeAppleMI.setOnAction(e -> System.out.println("Homemade Apple")); // TODO

        RadioMenuItem leckerliOneMI = new RadioMenuItem("Leckerli One");
        leckerliOneMI.setToggleGroup(autographGroup);
        leckerliOneMI.setOnAction(e -> System.out.println("Leckerli One")); // TODO

        RadioMenuItem pwSignatureMI = new RadioMenuItem("PW Signature");
        pwSignatureMI.setToggleGroup(autographGroup);
        pwSignatureMI.setOnAction(e -> System.out.println("PW Signature")); // TODO

        RadioMenuItem quickhandMI = new RadioMenuItem("Quickhand");
        quickhandMI.setToggleGroup(autographGroup);
        quickhandMI.setOnAction(e -> System.out.println("Quickhand")); // TODO

        RadioMenuItem tommysMI = new RadioMenuItem("Tommys");
        tommysMI.setToggleGroup(autographGroup);
        tommysMI.setOnAction(e -> System.out.println("Tommys")); // TODO

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
