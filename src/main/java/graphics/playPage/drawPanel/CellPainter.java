package graphics.playPage.drawPanel;

import staticData.StaticData;
import cells.Cell;

import java.awt.*;

import consoleUtils.NumberFormatter;

import org.jetbrains.annotations.NotNull;

class CellPainter {
    static void drawCell(@NotNull Graphics g, int zoom,
                         int cellX, int cellY, int cellSize,
                         int i, int j) {
        Cell cell = StaticData.cells.getCell(i, j);

        //draw pressure
        double pressure = cell.getPressure();
        int alpha = Math.max(
                0,
                Math.min(
                        255,
                        (int) (255 * Math.log(1 + Math.pow(Math.abs(pressure) / Cell.PRESSURE_MAX, 0.7)) / Math.log(2))));
        if (pressure >= 0) {
            g.setColor(new Color(255, 0, 0, alpha));
        } else {
            g.setColor(new Color(0, 255, 50, alpha));
        }
        g.fillRect(
                cellX, cellY,
                cellSize, cellSize);

        //draw wind
        int[] cellCenter = new int[] {
                cellX + cellSize / 2,
                cellY + cellSize / 2};
        int circleRadius = 4;
        g.setColor(new Color(220, 200, 20));
        g.fillOval(
                cellCenter[0] - circleRadius / 2, cellCenter[1] - circleRadius / 2,
                circleRadius, circleRadius);
        int
                lengthCoefficient = 100,//3,
                dx = (int) (lengthCoefficient * cell.windAmount * Math.cos(cell.windDirection) / zoom),
                dy = (int) (lengthCoefficient * cell.windAmount * Math.sin(cell.windDirection) / zoom);
        g.drawLine(
                cellCenter[0], cellCenter[1],
                cellCenter[0] + dx, cellCenter[1] + dy);

        //draw cell pressure & wind data
        /*g.setColor(Color.white);
        g.drawString(
                "p: " + NumberFormatter.doubleToString(cell.getPressure(), 2),
                cellX + 3, cellY + 13);
        g.drawString(
                "w: " + NumberFormatter.doubleToString(cell.windAmount, 2),
                cellX + 3, cellY + 28);
        */
    }
}