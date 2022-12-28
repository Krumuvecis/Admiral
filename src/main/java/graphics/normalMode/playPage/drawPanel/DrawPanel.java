package graphics.normalMode.playPage.drawPanel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;

import graphics2.observablePanels.ObservableDynamicPanel;
import graphics2.observerMouseListeners.ObserverMouseListener;
import graphics2.observerMouseListeners.ObserverMouseMotionListener;
import graphics2.observerMouseListeners.ObserverMouseWheelListener;

import graphics.normalMode.playPage.observer.Observer;

//TODO: add javadocs
public class DrawPanel extends ObservableDynamicPanel {
    private static final int BACKGROUND_BRIGHTNESS = 30;
    private static final @Nullable Color
            BACKGROUND_COLOR = new Color(
                    BACKGROUND_BRIGHTNESS,
                    BACKGROUND_BRIGHTNESS,
                    BACKGROUND_BRIGHTNESS),
            TEXT_COLOR = null; // default - white
    private final @NotNull Observer observer;

    //TODO: add javadoc
    public DrawPanel(@NotNull Observer observer) {
        super(new SimpleColorScheme(BACKGROUND_COLOR, TEXT_COLOR));
        this.observer = observer;
        addMouseListeners(
                new ObserverMouseListener(this, observer),
                new ObserverMouseMotionListener(this, observer),
                new ObserverMouseWheelListener(this, observer));
    }

    //TODO: add javadoc
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        @NotNull Dimension drawCenter = getPanelCenter();
        drawTestLines(g, this.getSize());
        int zoom = observer.zoom;
        int @NotNull []
                observerPos = observer.observerPos,
                mousePos = observer.mousePos;
        FieldPainter.drawField(g, drawCenter, observerPos, zoom);
        ClickPointPainter.drawClickPoints(g, drawCenter, observerPos, zoom);
        drawCenterMarker(g, drawCenter);
        ObserverInfoPainter.drawMouseInfo(g, mousePos, zoom, getPanelColors().getSecondaryColor());
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