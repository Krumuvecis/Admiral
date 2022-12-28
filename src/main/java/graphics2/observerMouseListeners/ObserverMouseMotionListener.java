package graphics2.observerMouseListeners;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

import org.jetbrains.annotations.NotNull;

import graphics2.observablePanels.ObservablePanel;
import graphics2.Observer;

/**
 * Observer mouse motion listener.
 */
public class ObserverMouseMotionListener implements MouseMotionListener {
    private final @NotNull ObservablePanel panel;
    private final @NotNull Observer observer;

    //TODO: add javadoc
    public ObserverMouseMotionListener(@NotNull ObservablePanel panel,
                                       @NotNull Observer observer) {
        this.panel = panel;
        this.observer = observer;
    }

    //TODO: add javadoc
    @Override
    public void mouseDragged(MouseEvent e) {
        if (panel.getPanelActive()) {
            observer.mousePos[0] = e.getX();
            observer.mousePos[1] = e.getY();
        }
    }

    //TODO: add javadoc
    @Override
    public void mouseMoved(MouseEvent e) {
        if (panel.getPanelActive()) {
            observer.mousePos[0] = e.getX();
            observer.mousePos[1] = e.getY();
        }
    }
}