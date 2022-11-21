package graphics.playPage;

import staticData.StaticData;

import java.awt.event.*;

import org.jetbrains.annotations.NotNull;

public class ObserverInfo {
    private static final int[] ZOOM_LIMITS = new int[] {1, 10};
    private static final int INITIAL_ZOOM = 5, ZOOM_INCREMENT = 1;

    private final DrawPanel drawPanel;
    final int @NotNull [] mousePos = new int[2];

    int zoom = INITIAL_ZOOM;

    ObserverInfo(@NotNull DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
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
                    StaticData.clickPoints.add(new int[] {e.getX(), e.getY()});
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