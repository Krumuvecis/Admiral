package main;

import static consoleUtils.ConsoleUtils.printLine;

import DelayCalculator.DelayOptions;
import DelayCalculator.PreferenceType;
import graphicsEngine.GraphicsAdapter;
import graphicsEngine.windows.WindowUpdater;

import graphics.Window;

/**
 * Main class of this application.
 * Run main(args) to run this.
 */
public class Main {
    public static final String DEV_MODE_ID = "dev";

    /**
     * Main method of this application.
     * Provide first argument as DEV_MODE_ID, to run the dev mode.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        //init some static data here
        new Main(args != null
                && args.length > 0
                && args[0].equals(DEV_MODE_ID));
    }

    private Main(boolean devMode) {
        if (devMode) {
            startDevMode();
        } else {
            startNormalMode();
        }
    }

    private void startDevMode() {
        printLine("dev mode not ready yet");
    }

    private void startNormalMode() {
        startGraphics();
    }

    private void startGraphics() {
        new GraphicsAdapter() {{
            newWindow(
                    new WindowUpdater(new Window(this),
                    new DelayOptions(PreferenceType.FPS, 60)));
        }};
    }
}