package graphics3;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import graphicsEngineExtension.ExtendedDynamicPanel;

import staticData.StaticData;
import cells.CellContainer;

public class FieldPainter extends AbstractCoordinatePainter {
    private static final @NotNull Color
            FIELD_COLOR = new Color(50, 100, 150),
            GRID_COLOR = new Color(100, 80, 60);

    public FieldPainter(@NotNull ExtendedDynamicPanel panel) {
        super(panel);
    }

    //
    @Override
    public void paint(@NotNull Graphics g, int @NotNull [] observerPos, int scale) {
        @NotNull Dimension drawCenter = getDrawCenter();

        int @NotNull []
                fieldStart = new int[] {
                        drawCenter.width - scaleDown(observerPos[0], scale),
                        drawCenter.height - scaleDown(observerPos[1], scale)},
                fieldSize = new int[] {
                        scaleDown(CellContainer.fieldSize[0], scale),
                        scaleDown(CellContainer.fieldSize[1], scale)};
        fillBackground(g, fieldStart, fieldSize);
        drawGridAndCells(g, fieldStart, fieldSize, scale);
    }

    private static void fillBackground(@NotNull Graphics g,
                                       int @NotNull [] fieldStart,
                                       int @NotNull [] fieldSize) {
        g.setColor(FIELD_COLOR);
        g.fillRect(
                fieldStart[0], fieldStart[1],
                fieldSize[0], fieldSize[1]);
    }

    private static void drawGridAndCells(@NotNull Graphics g,
                                         int @NotNull [] fieldStart,
                                         int @NotNull [] fieldSize,
                                         int scale) {
        int cellSize = scaleDown(CellContainer.cellSize, scale);
        int @NotNull [] cellCount = StaticData.cells.getCellCount();
        for(int i = 0; i <= cellCount[0]; i++) {
            int cellX = fieldStart[0] + i * cellSize;
            drawVerticalLine(g, fieldStart[1], fieldSize[1], cellX);
            for (int j = 0; j <= cellCount[1]; j++) {
                int cellY = fieldStart[1] + j * cellSize;
                drawHorizontalLine(g, fieldStart[0], fieldSize[0], cellY);
                if (i != cellCount[0] && j != cellCount[1]) {
                    CellPainter.drawCell(
                            g, scale,
                            cellX, cellY, cellSize,
                            i, j);
                }
            }
        }
    }

    private static void drawVerticalLine(@NotNull Graphics g,
                                         int fieldStartY,
                                         int fieldHeight,
                                         int cellX) {
        g.setColor(GRID_COLOR);
        g.drawLine(
                cellX, fieldStartY,
                cellX, fieldStartY + fieldHeight);
    }

    private static void drawHorizontalLine(@NotNull Graphics g,
                                           int fieldStartX,
                                           int fieldWidth,
                                           int cellY) {
        g.setColor(GRID_COLOR);
        g.drawLine(
                fieldStartX, cellY,
                fieldStartX + fieldWidth, cellY);
    }
}