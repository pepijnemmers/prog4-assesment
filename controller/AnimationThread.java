package controller;

import javafx.application.Platform;
import model.World;
import view.PaintingPane;

public class AnimationThread extends Thread {
    private static final int FRAME_RATE = 24;
    private static final double SPEED = 5;

    private final PaintingPane paintingPane;
    private final Controller controller;
    private boolean running = false;

    public AnimationThread(PaintingPane paintingPane, Controller controller) {
        this.paintingPane = paintingPane;
        this.controller = controller;
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            Platform.runLater(() -> {
                if (paintingPane != null) {
                    moveTrees();
                    paintingPane.refresh();
                }
            });

            try {
                Thread.sleep(1000 / FRAME_RATE);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void moveTrees() {
        World world = controller.getWorld();
        if (world == null) {
            stopThread();
            return;
        }
        world.moveTrees(SPEED);
    }

    public void stopThread() {
        running = false;
    }
}
