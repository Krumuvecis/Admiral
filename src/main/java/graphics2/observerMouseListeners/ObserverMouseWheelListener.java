package graphics2.observerMouseListeners;

import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

import org.jetbrains.annotations.NotNull;

import graphics2.observablePanels.ObservablePanel;
import graphics2.Observer;

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
            observer.zoom.adjustZoom(e.getWheelRotation());
        }
    }
}