package graphics3;

import java.awt.Dimension;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import graphicsEngineExtension.ExtendedDynamicPanel;

//
public abstract class AbstractCoordinatePainter {
    private final @NotNull ExtendedDynamicPanel panel;

    //
    public AbstractCoordinatePainter(@NotNull ExtendedDynamicPanel panel) {
        this.panel = panel;
    }

    //TODO: make abstract and add javadoc
    public void paint(@NotNull Graphics g, int @NotNull [] observerPos, int scale) {
        /*@NotNull Dimension
                drawSize = getDrawSize(),
                drawCenter = getDrawCenter();
        int @NotNull [] @NotNull [] drawableCoordinateLimits;*/
    }

    //
    public @NotNull ExtendedDynamicPanel getPanel() {
        return panel;
    }

    //
    public @NotNull Dimension getDrawSize() {
        return getPanel().getSize();
    }

    //
    public @NotNull Dimension getDrawCenter() {
        return getPanel().getPanelCenter();
    }
}