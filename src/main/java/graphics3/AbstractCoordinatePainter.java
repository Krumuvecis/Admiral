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
    public abstract void paint(@NotNull Graphics g, int @NotNull [] observerPos, int scale); /*{
        @NotNull Dimension
                drawSize = getDrawSize(),
                drawCenter = getDrawCenter();
        int @NotNull [] @NotNull [] drawableCoordinateLimits;
    }*/

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

    //
    public static int scaleDown(int value, int scale) {
        return value / scale;
    }

    //
    @SuppressWarnings("unused")
    public static int scaleUp(int value, int scale) {
        return value * scale;
    }

    //
    public static int @NotNull [] getActualOffset(int @NotNull [] observerPos,
                                                  int @NotNull [] referencePos) {
        return new int[] {
                referencePos[0] - observerPos[0],
                referencePos[1] - observerPos[1]
        };
    }

    //
    public static int @NotNull [] getDrawOffset(int @NotNull [] actualOffset,
                                                int scale) {
        return new int[] {
                scaleDown(actualOffset[0], scale),
                scaleDown(actualOffset[1], scale)
        };
    }
}