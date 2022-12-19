package main;

import org.jetbrains.annotations.NotNull;

import DelayCalculator.DelayOptions;
import DelayCalculator.PreferenceType;
import graphicsEngine.GraphicsAdapter;
import graphicsEngine.windows.WindowManager;
import graphicsEngine.windows.WindowUpdater;
import graphicsEngine.windows.AbstractWindow;

import graphics.normalMode.NormalWindow;
import graphics.devMode.DevWindow;

/**
 * Main class of this application.
 * Run main(args) to run this.
 */
public class Main {
    public static final String DEV_MODE_ID = "dev";
    private static final DelayOptions
            WINDOW_REFRESH_RATE = new DelayOptions(PreferenceType.FPS, 60);

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
        new GraphicsAdapter() {{
            newWindow(newWindowUpdater(this, devMode));
        }};
    }

    private @NotNull WindowUpdater newWindowUpdater(@NotNull WindowManager graphicsAdapter,
                                                    boolean devMode) {
        return new WindowUpdater(newWindow(graphicsAdapter, devMode), WINDOW_REFRESH_RATE);
    }

    private @NotNull AbstractWindow newWindow(@NotNull WindowManager graphicsAdapter,
                                              boolean devMode) {
        if (devMode) {
            return new DevWindow(graphicsAdapter);
        } else {
            return new NormalWindow(graphicsAdapter);
        }
    }
}