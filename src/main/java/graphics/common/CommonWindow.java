package graphics.common;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.windows.WindowConfig;
import graphicsEngine.windows.WindowManager;

import graphicsEngineExtension.windows.ExtendedMultiPageWindow;

import graphics.common.overlays.PagedOverlay;

/**
 * The window for this application
 * TODO: finish javadocs
 */
public abstract class CommonWindow extends ExtendedMultiPageWindow {
    private static final @NotNull String //for title purposes
            APPLICATION_NAME = "Admiral",
            VERSION_NUMBER = "0.6",
            TITLE_SUFFIX_SEPARATOR = " - ";

    //TODO: add javadoc
    public CommonWindow(@NotNull WindowManager windowManager,
                        @Nullable String titleModeSuffix,
                        int @NotNull [] size,
                        int @NotNull [] location,
                        @Nullable String mainPageKey) {
        super(
                windowManager,
                config(titleModeSuffix, size, location),
                null, null, mainPageKey);
        setOverlay(new PagedOverlay(this));
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
}