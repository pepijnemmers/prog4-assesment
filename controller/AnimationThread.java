package controller;

import javafx.application.Platform;
import model.World;
import view.PaintingPane;

public class AnimationThread extends Thread {
    private static final double FRAME_RATE = 45;
    private static final double SPEED = 0.8;

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
                Thread.sleep((long) (1000 / FRAME_RATE));
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
