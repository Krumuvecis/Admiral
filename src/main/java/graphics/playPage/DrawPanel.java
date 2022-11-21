package graphics.playPage;

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

    //TODO: add javadoc
    DrawPanel() {
        super(new SimpleColorScheme(BACKGROUND_COLOR, null));
        addMouseMotionListener(getNewMouseMotionListener());
        addMouseWheelListener(getNewMouseWheelListener());
        //setBackground(backgroundColor);
    }

    private @NotNull MouseMotionListener getNewMouseMotionListener() {
        return new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mousePos[0] = e.getX();
                mousePos[1] = e.getY();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mousePos[0] = e.getX();
                mousePos[1] = e.getY();
            }
        };
    }

    private @NotNull MouseWheelListener getNewMouseWheelListener() {
        return new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                zoom = getNewZoom(zoom, e.getWheelRotation() * ZOOM_INCREMENT);
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

    //TODO: add javadoc
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension panelSize = this.getSize();
        g.setColor(Color.red);
        g.drawLine(0, 0, panelSize.width, panelSize.height);
        g.setColor(getPanelColors().getSecondaryColor());
        g.drawString("x: " + mousePos[0] + ", y: " + mousePos[1], mousePos[0], mousePos[1]);
        g.drawString("zoom: " + zoom, mousePos[0], mousePos[1] + 15);
    }
}