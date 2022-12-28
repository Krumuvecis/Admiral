package graphics.normalMode.playPage.drawPanel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import staticData.StaticData;

//TODO: add javadoc
class ClickPointPainter {
    private static final Color COLOR = new Color(220, 170, 20);
    private static final int RADIUS_UNSCALED = 30;

    //TODO: add javadoc
    protected static void drawClickPoints(@NotNull Graphics g,
                                          @NotNull Dimension drawCenter,
                                          int @NotNull [] observerPos,
                                          int zoom) {
        int radius = getScaledRadius(zoom);
        g.setColor(COLOR);
        for (int @NotNull [] point : StaticData.clickPoints) {
            int @NotNull [] circleCenter = getCircleCenter(drawCenter, point, observerPos, zoom);
            drawSinglePoint(g, circleCenter, radius);
        }
    }

    private static int getScaledRadius(int zoom) {
        return RADIUS_UNSCALED / zoom;
    }

    private static int @NotNull [] getCircleCenter(@NotNull Dimension drawCenter,
                                                   int @NotNull [] point,
                                                   int @NotNull [] observerPos,
                                                   int zoom) {
        return new int[] {
                drawCenter.width + (point[0] - observerPos[0]) / zoom,
                drawCenter.height + (point[1] - observerPos[1]) / zoom};
    }

    private static void drawSinglePoint(@NotNull Graphics g,
                                        int @NotNull [] circleCenter,
                                        int radius) {
        g.fillOval(
                circleCenter[0] - radius / 2,
                circleCenter[1] - radius / 2,
                radius,
                radius);
    }
}