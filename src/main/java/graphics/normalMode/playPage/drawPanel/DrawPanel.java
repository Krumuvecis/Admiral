package graphics.normalMode.playPage.drawPanel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;

import graphics2.observablePanels.ObservableDynamicPanel;
import graphics2.Observer;

//TODO: add javadocs
public class DrawPanel extends ObservableDynamicPanel {
    private static final int BACKGROUND_BRIGHTNESS = 30;
    private static final @Nullable Color
            BACKGROUND_COLOR = new Color(
                    BACKGROUND_BRIGHTNESS,
                    BACKGROUND_BRIGHTNESS,
                    BACKGROUND_BRIGHTNESS),
            TEXT_COLOR = null, // default - white
            CENTER_MARKER_COLOR = new Color(0, 80, 60);

    private static final int CENTER_MARKER_SIZE = 20;

    //TODO: add javadoc
    public DrawPanel(@NotNull Observer observer) {
        super(new SimpleColorScheme(BACKGROUND_COLOR, TEXT_COLOR), observer);
    }

    //TODO: add javadoc
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        @NotNull Dimension drawCenter = getPanelCenter();
        drawTestLines(g, null);
        int zoom = observer.zoom.getZoom();
        int @NotNull []
                observerPos = observer.location.getLocation(),
                mousePos = observer.mousePos;
        FieldPainter.drawField(g, drawCenter, observerPos, zoom);
        ClickPointPainter.drawClickPoints(g, drawCenter, observerPos, zoom);
        drawCenterMarker(g, CENTER_MARKER_COLOR, CENTER_MARKER_SIZE);
        ObserverInfoPainter.drawMouseInfo(g, mousePos, zoom, getPanelColors().getSecondaryColor());
    }
}