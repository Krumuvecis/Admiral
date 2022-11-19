package main;

import graphicsEngine.GraphicsAdapter;
import graphicsEngine.windows.WindowUpdater;

import graphics.Window;

/**
 * Main class of this application.
 * Run main(args) to run this.
 */
public class Main {
    /**
     * Main method of this application.
     *
     * @param args Command-line arguments (none needed nor supported).
     */
    public static void main(String[] args) {
        //init some static data here
        startGraphics();
    }

    private static void startGraphics() {
        new GraphicsAdapter() {{
            newWindow(new WindowUpdater(new Window(this)));
        }};
    }
}