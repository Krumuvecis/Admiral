package graphics.common.overlays;

import java.awt.*;
import java.util.Objects;

import graphics.common.overlays.centering.CenteringPanel;
import org.jetbrains.annotations.NotNull;

import graphicsEngine.presets.SimpleOverlay;

import graphics.common.CommonWindow;
import graphics.common.overlays.page_main.Main;
import org.jetbrains.annotations.Nullable;

/**
 * TODO: add javadocs
 */
public class PagedOverlay extends SimpleOverlay {

    private final @NotNull CommonWindow window;

    /**
     * TODO: finish this javadoc
     */
    public PagedOverlay(@NotNull CommonWindow window) {
        super(null);
        this.window = window;
        setPage(OverlayPageType.MAIN);
    }

    //
    public void setPage(OverlayPageType page) {
        removeAll();
        setLayout(new BorderLayout());
        try {
            add(Objects.requireNonNull(getNewPage(page)), BorderLayout.CENTER);
        } catch (NullPointerException ignored) {}
    }

    @SuppressWarnings("UnnecessaryDefault")
    private @Nullable CenteringPanel getNewPage(OverlayPageType page) {
        return switch (page) {
            case MAIN -> new Main(window);
            case SETTINGS -> null;
            case SETTINGS_LAYOUT -> null;
            case SETTINGS_COLORS -> null;
            case SETTINGS_DEV -> null;
            default -> null;
        };
    }
}