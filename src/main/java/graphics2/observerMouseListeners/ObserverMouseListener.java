package graphics2.observerMouseListeners;

import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import org.jetbrains.annotations.NotNull;

import staticData.StaticData;

import graphics2.observablePanels.ObservablePanel;
import graphics2.Observer;

/**
 * Observer mouse listener.
 */
public class ObserverMouseListener implements MouseListener {
    private final @NotNull ObservablePanel panel;
    private final @NotNull Observer observer;

    //TODO: add javadoc
    public ObserverMouseListener(@NotNull ObservablePanel panel,
                                 @NotNull Observer observer) {
        this.panel = panel;
        this.observer = observer;
    }

    //TODO: add javadoc
    @Override
    public void mouseClicked(MouseEvent e) {
        mouseClickAction(e);
    }

    //TODO: add javadoc
    @Override
    public void mouseReleased(MouseEvent e) {
    } //unused

    //TODO: add javadoc
    @Override
    public void mousePressed(MouseEvent e) {
        mouseClickAction(e);
    }

    private void mouseClickAction(MouseEvent e) {
        if (panel.getPanelActive()) {
            if (e.getButton() == 1) { //left click
                @NotNull Dimension panelCenter = panel.getPanelCenter();
                int @NotNull []
                        mousePosition = new int[] {e.getX(), e.getY()},
                        observerLocation = observer.location.getLocation();
                int zoom = observer.zoom.getZoom();
                int @NotNull [] clickPointLocation = getClickPointLocation(
                        panelCenter,
                        mousePosition,
                        observerLocation,
                        zoom);
                addClickPoint(clickPointLocation);
            }
        }
    }

    private int @NotNull [] getClickPointLocation(@NotNull Dimension panelCenter,
                                                  int @NotNull [] mousePosition,
                                                  int @NotNull [] observerLocation,
                                                  int zoom) {
        return new int[] {
                observerLocation[0] + (mousePosition[0] - panelCenter.width) * zoom,
                observerLocation[1] + (mousePosition[1] - panelCenter.height) * zoom};
    }

    private void addClickPoint(int @NotNull [] location) {
        StaticData.clickPoints.add(location);
    }

    //TODO: add javadoc
    @Override
    public void mouseEntered(MouseEvent e) {
        panel.setPanelActive(true);
    }

    //TODO: add javadoc
    @Override
    public void mouseExited(MouseEvent e) {
        panel.setPanelActive(false);
    }
}