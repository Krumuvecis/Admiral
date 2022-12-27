package graphics.common.overlays;

import org.jetbrains.annotations.NotNull;

import graphicsEngineExtension.SimpleButtonListener;

import graphics.common.CommonWindow;

/**
 * TODO: add javadocs
 */
public abstract class OverlayButtonListener extends SimpleButtonListener {

    /**
     * TODO: finish this javadoc
     */
    public OverlayButtonListener(@NotNull CommonWindow window) {
        super(window);
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public final @NotNull String listenableName() {
        return "Overlay";
    }

    /**
     * TODO: finish this javadoc
     */
    public final void switchPage(OverlayPageType page) {
        ((PagedOverlay) (getCommonWindow().getOverlay())).setPage(page);
    }

    /**
     * TODO: finish this javadoc
     */
    public @NotNull CommonWindow getCommonWindow() {
        return (CommonWindow) getWindow();
    }
}