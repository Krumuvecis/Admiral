package graphics.playPage;

import graphics.staticData.StaticData;
import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.DynamicPanel;

import java.awt.*;
import java.awt.event.*;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public class DrawPanel extends DynamicPanel {
    private static final Color BACKGROUND_COLOR = new Color(50, 100, 150);
    private static final int[] ZOOM_LIMITS = new int[] {1, 10};
    private static final int INITIAL_ZOOM = 5, ZOOM_INCREMENT = 1;
    private final int[] mousePos = new int[2];
    private int zoom = INITIAL_ZOOM;
    private boolean panelActive = false;

    //TODO: add javadoc
    DrawPanel() {
        super(new SimpleColorScheme(BACKGROUND_COLOR, null));
        addMouseMotionListener(getNewMouseMotionListener());
        addMouseWheelListener(getNewMouseWheelListener());
        addMouseListener(getNewMouseListener());
        //setBackground(backgroundColor);
    }

    private @NotNull MouseMotionListener getNewMouseMotionListener() {
        return new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (panelActive) {
                    mousePos[0] = e.getX();
                    mousePos[1] = e.getY();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (panelActive) {
                    mousePos[0] = e.getX();
                    mousePos[1] = e.getY();
                }
            }
        };
    }

    private @NotNull MouseWheelListener getNewMouseWheelListener() {
        return new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (panelActive) {
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

    private @NotNull MouseListener getNewMouseListener() {
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
                if (panelActive) {
                    StaticData.clickPoints.add(new int[] {e.getX(), e.getY()});
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panelActive = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelActive = false;
            }
        };
    }

    //TODO: add javadoc
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension panelSize = this.getSize();
        g.setColor(Color.red);
        g.drawLine(0, 0, panelSize.width, panelSize.height);
        drawClickPoints(g);
        drawMouseInfo(g);
    }

    private void drawMouseInfo(@NotNull Graphics g) {
        g.setColor(getPanelColors().getSecondaryColor());
        g.drawString("x: " + mousePos[0] + ", y: " + mousePos[1], mousePos[0], mousePos[1]);
        g.drawString("zoom: " + zoom, mousePos[0], mousePos[1] + 15);
    }

    private void drawClickPoints(@NotNull Graphics g) {
        int radius = 10;
        g.setColor(Color.red);
        for (int[] point : StaticData.clickPoints) {
            g.fillOval(
                    point[0] - radius / 2,
                    point[1] - radius / 2,
                    radius,
                    radius);
        }
    }
}