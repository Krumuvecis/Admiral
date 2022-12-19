package graphics.normalMode.playPage.drawPanel;

import java.awt.Graphics;
import java.awt.Color;

import org.jetbrains.annotations.NotNull;

import consoleUtils.NumberFormatter;

import staticData.StaticData;
import cells.Cell;

//TODO: add javadocs
class CellPainter {
    private static final boolean DRAW_BAROKINETIC_INFO = false;

    //TODO: add javadoc
    static void drawCell(@NotNull Graphics g, int zoom,
                         int cellX, int cellY, int cellSize,
                         int i, int j) {
        @NotNull Cell cell = StaticData.cells.getCell(i, j);
        drawPressureColor(g, cellX, cellY, cellSize, cell);
        drawWind(g, cellX, cellY, cellSize, zoom, cell);
        if (DRAW_BAROKINETIC_INFO) {
            drawBarokineticInfo(g, cellX, cellY, cell);
        }
    }

    private static void drawPressureColor(@NotNull Graphics g,
                                          int cellX, int cellY, int cellSize,
                                          @NotNull Cell cell) {
        double
                referencePressure = StaticData.cells.barokineticSettings.pressureMaxMagnitudeChange,
                pressure = cell.getPressure();
        int alpha = Math.max(
                0,
                Math.min(
                        255,
                        (int) (255
                                * Math.log(1 + Math.pow(Math.abs(pressure) / referencePressure, 0.7))
                                / Math.log(2))));
        if (pressure >= 0) {
            g.setColor(new Color(255, 0, 0, alpha));
        } else {
            g.setColor(new Color(0, 255, 50, alpha));
        }
        g.fillRect(
                cellX, cellY,
                cellSize, cellSize);
    }

    private static void drawWind(@NotNull Graphics g,
                                 int cellX, int cellY, int cellSize, int zoom,
                                 @NotNull Cell cell) {
        int[] cellCenter = new int[] {
                cellX + cellSize / 2,
                cellY + cellSize / 2};
        int circleRadius = 4;
        g.setColor(new Color(220, 200, 20));
        g.fillOval(
                cellCenter[0] - circleRadius / 2, cellCenter[1] - circleRadius / 2,
                circleRadius, circleRadius);
        int
                lengthCoefficient = 100,
                dx = (int) (lengthCoefficient * cell.windAmount * Math.cos(cell.windDirection) / zoom),
                dy = (int) (lengthCoefficient * cell.windAmount * Math.sin(cell.windDirection) / zoom);
        g.drawLine(
                cellCenter[0], cellCenter[1],
                cellCenter[0] + dx, cellCenter[1] + dy);
    }

    private static void drawBarokineticInfo(@NotNull Graphics g,
                                            int cellX, int cellY,
                                            @NotNull Cell cell) {
        int @NotNull [] offset = new int[] {3, 13};
        int dt = 15;

        g.setColor(Color.white);
        g.drawString(
                "p: " + NumberFormatter.doubleToString(cell.getPressure(), 2),
                cellX + offset[0], cellY + offset[1]);
        g.drawString(
                "w: " + NumberFormatter.doubleToString(cell.windAmount, 2),
                cellX + offset[0], cellY + offset[1] + dt);
    }
}