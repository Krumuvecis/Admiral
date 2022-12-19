package graphics.common;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.windows.WindowConfig;
import graphicsEngine.windows.WindowManager;
import graphicsEngine.windows.windowTypes.MultiPageWindow;

import graphicsEngineExtension.KeyboardListener;

/**
 * The window for this application
 * TODO: finish javadocs
 */
public abstract class Window extends MultiPageWindow {
    public KeyboardListener keyboardListener;
    /**
     * For determining the "enabled" state of non-overlay listeners
     */
    public boolean pageListenersEnabled;

    //TODO: add javadoc
    public Window(@NotNull WindowManager windowManager) {
        super(windowManager, config(), null, null);
        setIcon(graphicsEngine.Utilities.getSampleIcon());

        keyboardListener = new KeyboardListener();
        addKeyListener(keyboardListener);

        setPageListenersEnabled(true);
    }

    /**
     * Hardcoded configuration of a new Window object.
     *
     * @return Window configuration.
     */
    private static @NotNull WindowConfig config() {
        String title = "Admiral";
        int[]
                size = new int[] {1000, 600},
                location = new int[] {200, 30};
        WindowConfig config = new WindowConfig(title, size, location);
        config.closeOperation = EXIT_ON_CLOSE;
        return config;
    }

    private void setPageListenersEnabled(boolean state) {
        pageListenersEnabled = state;
    }

    private void togglePageListenersEnabled() {
       setPageListenersEnabled(!pageListenersEnabled);
    }

    //TODO: add javadoc
    @Override
    public void setActivePage(@Nullable String key) {
        super.setActivePage(key);
        hideOverlay();
    }

    //TODO: add javadoc
    @Override
    public void showOverlay() {
        setPageListenersEnabled(false);
        super.showOverlay();
    }

    //TODO: add javadoc
    @Override
    public void hideOverlay() {
        super.hideOverlay();
        setPageListenersEnabled(true);
    }

    //TODO: add javadoc
    @Override
    public void toggleOverlay() {
        togglePageListenersEnabled();
        super.toggleOverlay();
    }
}