package graphics2.observerMouseListeners;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.jetbrains.annotations.NotNull;

import staticData.StaticData;

import graphics2.observablePanels.ObservablePanel;

import graphics.normalMode.playPage.observer.Observer;

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
                StaticData.clickPoints.add(new int[]{
                        observer.observerPos[0] + (e.getX() - panelCenter.width) * observer.zoom,
                        observer.observerPos[1] + (e.getY() - panelCenter.height) * observer.zoom});
            }
        }
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