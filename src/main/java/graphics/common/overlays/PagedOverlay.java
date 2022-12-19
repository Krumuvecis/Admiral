package graphics.common.overlays;

import java.util.Objects;
import java.awt.BorderLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleOverlay;

import graphics.common.CommonWindow;
import graphics.common.overlays.centering.CenteringPanel;
import graphics.common.overlays.pages.main.Main;
import graphics.common.overlays.pages.settings.Settings;
import graphics.common.overlays.pages.settings_colors.ColorSettings;
import graphics.common.overlays.pages.settings_layout.LayoutSettings;
import graphics.common.overlays.pages.settings_dev.DevSettings;

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
        setLayout(new BorderLayout());
        setPage(OverlayPageType.MAIN);
    }

    /**
     * TODO: finish this javadoc
     */
    public void setPage(OverlayPageType page) {
        removeAll();
        try {
            add(Objects.requireNonNull(getNewPage(page)), BorderLayout.CENTER);
        } catch (NullPointerException ignored) {}
    }

    @SuppressWarnings("UnnecessaryDefault")
    private @Nullable CenteringPanel getNewPage(OverlayPageType page) {
        return switch (page) {
            case MAIN -> new Main(window);
            case SETTINGS -> new Settings(window);
            case SETTINGS_LAYOUT -> new LayoutSettings(window);
            case SETTINGS_COLORS -> new ColorSettings(window);
            case SETTINGS_DEV -> new DevSettings(window);
            default -> null;
        };
    }
}