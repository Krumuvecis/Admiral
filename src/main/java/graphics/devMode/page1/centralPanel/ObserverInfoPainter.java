package graphics.devMode.page1.centralPanel;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

//TODO: add javadoc
class ObserverInfoPainter {
    private static final int LINE_HEIGHT = 15;
    private static final int @NotNull [] TEXT_OFFSET = new int[] {10, 10};

    //TODO: add javadoc
    protected static void drawMouseInfo(@NotNull Graphics g,
                                        int @NotNull [] mousePos,
                                        int zoom,
                                        @NotNull Color textColor) {
        g.setColor(textColor);
        int @NotNull [] textPos = new int[] {
                mousePos[0] + TEXT_OFFSET[0],
                mousePos[1] + TEXT_OFFSET[1]};
        drawCoordinateInfo(g, textPos, mousePos);
        drawZoomInfo(g, textPos, zoom);
    }

    private static void drawCoordinateInfo(@NotNull Graphics g,
                                           int @NotNull [] textPos,
                                           int @NotNull [] mousePos) {
        @NotNull String text = "x: " + mousePos[0] + ", y: " + mousePos[1];
        g.drawString(text, textPos[0], textPos[1]);
    }

    private static void drawZoomInfo(@NotNull Graphics g,
                                     int @NotNull [] textPos,
                                     int zoom) {
        @NotNull String text = "zoom: " + zoom;
        g.drawString(text, textPos[0], textPos[1] + LINE_HEIGHT);
    }
}