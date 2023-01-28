package graphics3;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import graphicsEngineExtension.ExtendedDynamicPanel;

import staticData.StaticData;

//TODO: add javadoc
public class ClickPointPainter extends AbstractCoordinatePainter {
    private static final Color POINT_COLOR = new Color(220, 170, 20);
    private static final int RADIUS_UNSCALED = 30;

    public ClickPointPainter(@NotNull ExtendedDynamicPanel panel) {
        super(panel);
    }

    //
    @Override
    public void paint(@NotNull Graphics g, int @NotNull [] observerPos, int scale) {
        @NotNull Dimension drawCenter = getDrawCenter();
        int radius = scaleDown(RADIUS_UNSCALED, scale);

        g.setColor(POINT_COLOR);
        for (int @NotNull [] point : StaticData.clickPoints) {
            int @NotNull [] circleDrawPos = getCircleDrawPos(drawCenter, point, observerPos, scale);
            drawSinglePoint(g, circleDrawPos, radius);
        }
    }

    private static int @NotNull [] getCircleDrawPos(@NotNull Dimension drawCenter,
                                                    int @NotNull [] point,
                                                    int @NotNull [] observerPos,
                                                    int scale) {
        int @NotNull []
                actualOffset = getActualOffset(observerPos, point),
                drawOffset = getDrawOffset(actualOffset, scale);

        return new int[] {
                drawCenter.width + drawOffset[0],
                drawCenter.height + drawOffset[1]
        };
    }

    private static void drawSinglePoint(@NotNull Graphics g,
                                        int @NotNull [] circleDrawPos,
                                        int radius) {
        g.fillOval(
                circleDrawPos[0] - radius / 2,
                circleDrawPos[1] - radius / 2,
                radius,
                radius);
    }
}