package graphicsEngineExtension;

import java.util.Objects;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.panels.DynamicPanel;

//
public class ExtendedDynamicPanel extends DynamicPanel {
    private static final @NotNull Color
            DEFAULT_TEST_LINE_COLOR = Color.red,
            DEFAULT_CENTER_MARKER_COLOR = Color.red;

    //
    public ExtendedDynamicPanel(@Nullable SimpleColorScheme colors) {
        super(colors);
        initialize();
    }

    //
    public ExtendedDynamicPanel(@Nullable Dimension sizeLimits,
                                @Nullable SimpleColorScheme colors,
                                @Nullable BorderProperties borderProperties) {
        super(sizeLimits, colors, borderProperties);
        initialize();
    }

    private void initialize() {
        //put some common initialization here
    }

    //
    public void drawTestLines(@NotNull Graphics g, @Nullable Color lineColor) {
        g.setColor(Objects.requireNonNullElse(lineColor, DEFAULT_TEST_LINE_COLOR));
        @NotNull Dimension drawSize = this.getSize();
        g.drawLine(
                0, 0,
                drawSize.width, drawSize.height);
        g.drawLine(
                drawSize.width, 0,
                0, drawSize.height);
    }

    //
    public final @NotNull Dimension getPanelCenter() {
        @NotNull Dimension panelSize = this.getSize();
        return new Dimension(
                panelSize.width / 2,
                panelSize.height / 2);
    }

    //
    public void drawCenterMarker(@NotNull Graphics g, @Nullable Color markerColor, int markerSize) {
        if (markerSize > 0) { //prevents negative sizes
            g.setColor(Objects.requireNonNullElse(markerColor, DEFAULT_CENTER_MARKER_COLOR));
            @NotNull Dimension drawCenter = getPanelCenter();
            g.drawLine( // vertical line
                    drawCenter.width, drawCenter.height - markerSize / 2,
                    drawCenter.width, drawCenter.height + markerSize / 2
            );
            g.drawLine( // horizontal line
                    drawCenter.width - markerSize / 2, drawCenter.height,
                    drawCenter.width + markerSize / 2, drawCenter.height
            );
        }
    }
}