package graphics.playPage;

import graphics.Window;
import staticData.Cell;
import staticData.StaticData;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.DynamicPanel;

import java.awt.*;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadocs
public class DrawPanel extends DynamicPanel {
    private static final Color
            BACKGROUND_COLOR = new Color(100, 100, 100),
            FIELD_COLOR = new Color(50, 100, 150),
            GRID_COLOR = new Color(100, 80, 60);

    private final Window window;
    private final ObserverInfo observerInfo;
    boolean panelActive = false;

    //TODO: add javadoc
    DrawPanel(@Nullable Window window) {
        super(new SimpleColorScheme(BACKGROUND_COLOR, null));
        this.window = window;
        observerInfo = new ObserverInfo(window, this);
        addMouseMotionListener(observerInfo.getNewMouseMotionListener());
        addMouseWheelListener(observerInfo.getNewMouseWheelListener());
        addMouseListener(observerInfo.getNewMouseListener());
    }

    @NotNull Dimension getPanelCenter() {
        @NotNull Dimension panelSize = this.getSize();
        return new Dimension(
                panelSize.width / 2,
                panelSize.height / 2);
    }

    //TODO: add javadoc
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        @NotNull Dimension drawCenter = getPanelCenter();
        drawTestLines(g, this.getSize());
        if (observerInfo == null) {
            drawUninitializedObserver(g);
        } else {
            drawField(g, drawCenter);
            drawClickPoints(g, drawCenter);
            drawCenterMarker(g, drawCenter);
            drawKeyInfo(g);
            drawMouseInfo(g);
        }
    }

    private void drawTestLines(@NotNull Graphics g,
                               @NotNull Dimension drawSize) {
        g.setColor(Color.red);
        g.drawLine(
                0, 0,
                drawSize.width, drawSize.height);
        g.drawLine(
                drawSize.width, 0,
                0, drawSize.height);
    }

    private void drawUninitializedObserver(@NotNull Graphics g) {
        int[] textPosition = new int[] {10, 25};
        g.setColor(getPanelColors().getSecondaryColor());
        g.drawString("Observer not initialized.", textPosition[0], textPosition[1]);
    }

    private void drawKeyInfo(@NotNull Graphics g) {
        if (window.keyboardListener != null) {
            int[] textPosition = new int[] {10, 25};
            int dt = 15;
            g.setColor(getPanelColors().getSecondaryColor());
            g.drawString("Pressed keys:", textPosition[0], textPosition[1]);
            for (int i = 0; i < window.keyboardListener.pressedKeys.size(); i++) {
                int key = window.keyboardListener.pressedKeys.get(i);
                g.drawString((i + 1) + " - " + key, textPosition[0], textPosition[1] + dt * (i + 1));
            }
        }
    }

    private void drawMouseInfo(@NotNull Graphics g) {
        g.setColor(getPanelColors().getSecondaryColor());
        int[] mousePos = observerInfo.mousePos;
        g.drawString("x: " + mousePos[0] + ", y: " + mousePos[1], mousePos[0], mousePos[1]);
        g.drawString("zoom: " + observerInfo.zoom, mousePos[0], mousePos[1] + 15);
    }

    private void drawClickPoints(@NotNull Graphics g,
                                 @NotNull Dimension drawCenter) {
        int
                unscaledRadius = 30,
                radius = unscaledRadius / observerInfo.zoom;

        g.setColor(new Color(220, 170, 20));
        for (int[] point : StaticData.clickPoints) {
            g.fillOval(
                    drawCenter.width + (point[0] - observerInfo.observerPos[0]) / observerInfo.zoom - radius / 2,
                    drawCenter.height + (point[1] - observerInfo.observerPos[1]) / observerInfo.zoom - radius / 2,
                    radius,
                    radius);
        }
    }

    private void drawField(@NotNull Graphics g,
                           @NotNull Dimension drawCenter) {
        int zoom = observerInfo.zoom;
        int[]
                fieldStart = new int[] {
                        drawCenter.width - observerInfo.observerPos[0] / zoom,
                        drawCenter.height - observerInfo.observerPos[1] / zoom
                },
                fieldSize = new int[] {
                        StaticData.fieldSize[0] / zoom,
                        StaticData.fieldSize[1] / zoom
                };

        g.setColor(FIELD_COLOR);
        g.fillRect(
                fieldStart[0], fieldStart[1],
                fieldSize[0], fieldSize[1]);

        int cellSize = StaticData.cellSize / zoom;
        int imax = StaticData.cellCount[0];
        for(int i = 0; i <= imax; i++) {
            int cellX = fieldStart[0] + i * cellSize;
            g.setColor(GRID_COLOR);
            g.drawLine( // vertical line
                    cellX, fieldStart[1],
                    cellX, fieldStart[1] + fieldSize[1]);
            int jmax = StaticData.cellCount[1];
            for (int j = 0; j <= jmax; j++) {
                int cellY = fieldStart[1] + j * cellSize;
                g.setColor(GRID_COLOR);
                g.drawLine( // horizontal line
                        fieldStart[0], cellY,
                        fieldStart[0] + fieldSize[0], cellY);
                if (i != imax && j != jmax) {
                    Cell cell = StaticData.cells.get(i).get(j);
                    // draw cell {i, j} here
                    int alpha = (int) (255 * cell.value / Cell.VALUE_MAX);
                    g.setColor(new Color(150, 0, 50, alpha));
                    g.fillRect(
                            cellX, cellY,
                            cellSize, cellSize);
                }
            }
        }
    }

    private void drawCenterMarker(@NotNull Graphics g,
                                  @NotNull Dimension drawCenter) {
        g.setColor(new Color(0, 80, 60));
        int markerSize = 20;
        int[] center = new int[] {drawCenter.width, drawCenter.height};
        g.drawLine( // vertical line
                center[0], center[1] - markerSize / 2,
                center[0], center[1] + markerSize / 2
        );
        g.drawLine( // horizontal line
                center[0] - markerSize / 2, center[1],
                center[0] + markerSize / 2, center[1]
        );
    }
}