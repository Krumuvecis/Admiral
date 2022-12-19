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
public abstract class CommonWindow extends MultiPageWindow {
    private static final @NotNull String //for title purposes
            APPLICATION_NAME = "Admiral",
            VERSION_NUMBER = "0.5",
            TITLE_SUFFIX_SEPARATOR = " - ";

    public KeyboardListener keyboardListener;

    /**
     * For determining the "enabled" state of non-overlay listeners
     */
    public boolean pageListenersEnabled;

    //TODO: add javadoc
    public CommonWindow(@NotNull WindowManager windowManager,
                        @Nullable String titleModeSuffix,
                        int @NotNull [] size,
                        int @NotNull [] location) {
        super(
                windowManager,
                config(titleModeSuffix, size, location),
                null, null);
        // icon paths don't work after graphicsEngine compilation! TODO: fix
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
    private static @NotNull WindowConfig config(@Nullable String titleModeSuffix,
                                                int @NotNull [] size,
                                                int @NotNull [] location) {
        @NotNull WindowConfig config = new WindowConfig(
                generateTitle(titleModeSuffix),
                size,
                location);
        config.closeOperation = EXIT_ON_CLOSE;
        return config;
    }

    private static @NotNull String generateTitle(@Nullable String titleModeSuffix) {
        @NotNull String title = APPLICATION_NAME + TITLE_SUFFIX_SEPARATOR + VERSION_NUMBER;
        if (titleModeSuffix != null) {
            title = title + TITLE_SUFFIX_SEPARATOR + titleModeSuffix;
        }
        return title;
    }

    /**
     * For multi-window purposes.
     *
     * @return The key of this window.
     */
    @Override
    public final @NotNull String getWindowKey() {
        return "main_window";
    }

    private void setPageListenersEnabled(boolean state) {
        pageListenersEnabled = state;
    }

    private void togglePageListenersEnabled() {
       setPageListenersEnabled(!pageListenersEnabled);
    }

    //TODO: add javadoc
    @Override
    public final void setActivePage(@Nullable String key) {
        super.setActivePage(key);
        hideOverlay();
    }

    //TODO: add javadoc
    @Override
    public final void showOverlay() {
        setPageListenersEnabled(false);
        super.showOverlay();
    }

    //TODO: add javadoc
    @Override
    public final void hideOverlay() {
        super.hideOverlay();
        setPageListenersEnabled(true);
    }

    //TODO: add javadoc
    @Override
    public final void toggleOverlay() {
        togglePageListenersEnabled();
        super.toggleOverlay();
    }
}