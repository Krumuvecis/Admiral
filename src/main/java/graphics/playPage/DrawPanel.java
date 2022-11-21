package graphics.playPage;

import graphics.Window;
import staticData.StaticData;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.DynamicPanel;

import java.awt.*;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadocs
public class DrawPanel extends DynamicPanel {
    private static final Color BACKGROUND_COLOR = new Color(50, 100, 150);

    private Window window;
    private final ObserverInfo observerInfo;
    boolean panelActive = false;

    //TODO: add javadoc
    DrawPanel(@Nullable Window window) {
        super(new SimpleColorScheme(BACKGROUND_COLOR, null));
        this.window = window;
        observerInfo = new ObserverInfo(this);
        addMouseMotionListener(observerInfo.getNewMouseMotionListener());
        addMouseWheelListener(observerInfo.getNewMouseWheelListener());
        addMouseListener(observerInfo.getNewMouseListener());
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
            drawKeyInfo(g);
            drawMouseInfo(g);
        }
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