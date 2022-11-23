package graphics.playPage;

import graphics.Window;
import staticData.StaticData;

import java.awt.*;
import java.awt.event.*;

import org.jetbrains.annotations.NotNull;

public class ObserverInfo {
    private static final int[] ZOOM_LIMITS = new int[] {1, 10};
    private static final int INITIAL_ZOOM = 4, ZOOM_INCREMENT = 1;
    private final DrawPanel drawPanel;
    final int @NotNull []
            mousePos = new int[2],
            observerPos = getInitialObserverPos();
    int zoom = INITIAL_ZOOM;

    ObserverInfo(Window window,
                 @NotNull DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        ObserverKeyboardChecker keyboardChecker = new ObserverKeyboardChecker(window, this);
        keyboardChecker.start();
    }

    private int @NotNull [] getInitialObserverPos() {
        int @NotNull [] fieldSize = StaticData.fieldSize;
        return new int[] {fieldSize[0] / 2, fieldSize[1] / 2};
    }

    enum ObserverMovementDirection {
        RIGHT,
        LEFT,
        DOWN,
        UP
    }

    void moveObserver(ObserverMovementDirection direction) {
        switch (direction) {
            case RIGHT -> {
                observerPos[0] += getMovementAmount();
            }
            case LEFT -> {
                observerPos[0] -= getMovementAmount();
            }
            case DOWN -> {
                observerPos[1] += getMovementAmount();
            }
            case UP -> {
                observerPos[1] -= getMovementAmount();
            }
            default -> {}
        }
    }

    int getMovementAmount() {
        int velocity = 2;
        return velocity * zoom;
    }

    @NotNull MouseMotionListener getNewMouseMotionListener() {
        return new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (drawPanel.panelActive) {
                    mousePos[0] = e.getX();
                    mousePos[1] = e.getY();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (drawPanel.panelActive) {
                    mousePos[0] = e.getX();
                    mousePos[1] = e.getY();
                }
            }
        };
    }

    @NotNull MouseWheelListener getNewMouseWheelListener() {
        return new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (drawPanel.panelActive) {
                    zoom = getNewZoom(zoom, e.getWheelRotation() * ZOOM_INCREMENT);
                }
            }

            private int getNewZoom(int previous, int delta) {
                return Math.max(
                        ZOOM_LIMITS[0],
                        Math.min(
                                ZOOM_LIMITS[1],
                                previous + delta));
            }
        };
    }

    @NotNull MouseListener getNewMouseListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseClickAction(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mouseClickAction(e);
            }

            private void mouseClickAction(MouseEvent e) {
                if (drawPanel.panelActive) {
                    if (e.getButton() == 1) { //left click
                        @NotNull Dimension panelCenter = drawPanel.getPanelCenter();
                        StaticData.clickPoints.add(new int[] {
                                observerPos[0] + (e.getX() - panelCenter.width) * zoom,
                                observerPos[1] + (e.getY() - panelCenter.height) * zoom});
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                drawPanel.panelActive = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                drawPanel.panelActive = false;
            }
        };
    }
}