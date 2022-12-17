package graphics.playPage.drawPanel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import staticData.StaticData;
import cells.CellContainer;

import graphics.playPage.observer.Observer;

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
        int @NotNull [] cellCount = StaticData.cells.getCellCount();
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
                    CellPainter.drawCell(
                            g, zoom,
                            cellX, cellY, cellSize,
                            i, j);
                }
            }
        }
    }
}