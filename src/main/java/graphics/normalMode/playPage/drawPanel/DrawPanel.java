package graphics.normalMode.playPage.drawPanel;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;

import graphics2.observablePanels.ObservableDynamicPanel;
import graphics2.Observer;

import graphics3.AbstractCoordinatePainter;
import graphics3.FieldPainter;
import graphics3.ClickPointPainter;

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

    private final @NotNull AbstractCoordinatePainter
            fieldPainter,
            clickPointPainter;

    //TODO: add javadoc
    public DrawPanel(@NotNull Observer observer) {
        super(new SimpleColorScheme(BACKGROUND_COLOR, TEXT_COLOR), observer);
        fieldPainter = new FieldPainter(this);
        clickPointPainter = new ClickPointPainter(this);
    }

    //TODO: add javadoc
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTestLines(g, null);
        int zoom = observer.zoom.getZoom();
        int @NotNull []
                observerPos = observer.location.getLocation(),
                mousePos = observer.mousePos;
        fieldPainter.paint(g, observerPos, zoom);
        clickPointPainter.paint(g, observerPos, zoom);
        drawCenterMarker(g, CENTER_MARKER_COLOR, CENTER_MARKER_SIZE);
        ObserverInfoPainter.drawMouseInfo(g, mousePos, zoom, getPanelColors().getSecondaryColor());
    }
}