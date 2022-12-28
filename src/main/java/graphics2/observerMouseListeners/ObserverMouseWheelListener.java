package graphics2.observerMouseListeners;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import org.jetbrains.annotations.NotNull;

import graphics2.observablePanels.ObservablePanel;

import graphics.normalMode.playPage.observer.Observer;

/**
 * Observer mouse wheel listener.
 */
public class ObserverMouseWheelListener implements MouseWheelListener {
    private final @NotNull ObservablePanel panel;
    private final @NotNull Observer observer;

    //TODO: add javadoc
    public ObserverMouseWheelListener(@NotNull ObservablePanel panel,
                                      @NotNull Observer observer) {
        this.panel = panel;
        this.observer = observer;
    }

    //TODO: add javadoc
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (panel.getPanelActive()) {
            observer.zoom = getNewZoom(
                    observer.zoom,
                    e.getWheelRotation() * Observer.ZOOM_INCREMENT);
        }
    }

    private int getNewZoom(int previous, int delta) {
        return Math.max(
                Observer.ZOOM_LIMITS[0],
                Math.min(
                        Observer.ZOOM_LIMITS[1],
                        previous + delta));
    }
}