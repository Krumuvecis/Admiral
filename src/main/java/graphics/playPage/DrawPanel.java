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

    boolean panelActive = false;
    private ObserverInfo observerInfo;

    //TODO: add javadoc
    DrawPanel() {
        super(new SimpleColorScheme(BACKGROUND_COLOR, null));
        observerInfo = new ObserverInfo(this);
        addMouseMotionListener(observerInfo.getNewMouseMotionListener());
        addMouseWheelListener(observerInfo.getNewMouseWheelListener());
        addMouseListener(observerInfo.getNewMouseListener());
        //setBackground(backgroundColor);
    }

    //TODO: add javadoc
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension panelSize = this.getSize();
        g.setColor(Color.red);
        g.drawLine(0, 0, panelSize.width, panelSize.height);
        if (observerInfo == null) {
            drawUninitializedObserver(g);
        } else {
            drawClickPoints(g);
            drawMouseInfo(g);
        }
    }

    private void drawUninitializedObserver(@NotNull Graphics g) {
        int[] textPosition = new int[] {10, 25};
        g.setColor(getPanelColors().getSecondaryColor());
        g.drawString("Observer not initialized.", textPosition[0], textPosition[1]);
    }

    private void drawMouseInfo(@NotNull Graphics g) {
        g.setColor(getPanelColors().getSecondaryColor());
        int[] mousePos = observerInfo.mousePos;
        g.drawString("x: " + mousePos[0] + ", y: " + mousePos[1], mousePos[0], mousePos[1]);
        g.drawString("zoom: " + observerInfo.zoom, mousePos[0], mousePos[1] + 15);
    }

    private void drawClickPoints(@NotNull Graphics g) {
        int radius = 10;
        g.setColor(new Color(100, 70, 0));
        for (int[] point : StaticData.clickPoints) {
            g.fillOval(
                    point[0] - radius / 2,
                    point[1] - radius / 2,
                    radius,
                    radius);
        }
    }
}