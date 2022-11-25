package graphics.playPage.drawPanel;

import staticData.StaticData;
import cells.CellContainer;
import cells.Cell;

import graphics.playPage.observer.Observer;

import java.awt.*;

import consoleUtils.NumberFormatter;

import org.jetbrains.annotations.NotNull;

class FieldPainter {
    private static final Color
            FIELD_COLOR = new Color(50, 100, 150),
            GRID_COLOR = new Color(100, 80, 60);
    private final @NotNull Observer observer;

    FieldPainter(@NotNull Observer observer) {
        this.observer = observer;
    }

    void drawField(@NotNull Graphics g,
                   @NotNull Dimension drawCenter) {
        int zoom = observer.zoom;
        int[]
                fieldStart = new int[] {
                drawCenter.width - observer.observerPos[0] / zoom,
                drawCenter.height - observer.observerPos[1] / zoom
        },
                fieldSize = new int[] {
                        CellContainer.fieldSize[0] / zoom,
                        CellContainer.fieldSize[1] / zoom
                };

        g.setColor(FIELD_COLOR);
        g.fillRect(
                fieldStart[0], fieldStart[1],
                fieldSize[0], fieldSize[1]);

        int cellSize = CellContainer.cellSize / zoom;
        int @NotNull [] cellCount = CellContainer.cellCount;
        for(int i = 0; i <= cellCount[0]; i++) {
            int cellX = fieldStart[0] + i * cellSize;
            g.setColor(GRID_COLOR);
            g.drawLine( // vertical line
                    cellX, fieldStart[1],
                    cellX, fieldStart[1] + fieldSize[1]);
            for (int j = 0; j <= cellCount[1]; j++) {
                int cellY = fieldStart[1] + j * cellSize;
                g.setColor(GRID_COLOR);
                g.drawLine( // horizontal line
                        fieldStart[0], cellY,
                        fieldStart[0] + fieldSize[0], cellY);
                if (i != cellCount[0] && j != cellCount[1]) {
                    drawCell(
                            g, zoom,
                            cellX, cellY, cellSize,
                            i, j);
                }
            }
        }
    }

    void drawCell(@NotNull Graphics g, int zoom,
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
        int
                lengthCoefficient = 30,//3,
                dx = (int) (lengthCoefficient * cell.windAmount * Math.cos(cell.windDirection) / zoom),
                dy = (int) (lengthCoefficient * cell.windAmount * Math.sin(cell.windDirection) / zoom);
        g.setColor(new Color(220, 200, 20));
        g.drawLine(
                cellCenter[0], cellCenter[1],
                cellCenter[0] + dx, cellCenter[1] + dy);

        /*
        //draw cell pressure & wind data
        g.setColor(Color.white);
        g.drawString(
                "p: " + NumberFormatter.doubleToString(cell.pressure, 2),
                cellX + 3, cellY + 13);
        g.drawString(
                "w: " + NumberFormatter.doubleToString(cell.windAmount, 2),
                cellX + 3, cellY + 28);

        */
    }
}