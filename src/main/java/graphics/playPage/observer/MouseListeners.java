package graphics.playPage.observer;

import staticData.StaticData;

import graphics.playPage.drawPanel.DrawPanel;

import java.awt.*;
import java.awt.event.*;

import org.jetbrains.annotations.NotNull;

/**
 * A utility class for containing various observer mouse listeners.
 */
public class MouseListeners {
    /**
     * Adds observer listeners to a panel.
     *
     * @param drawPanel Panel
     * @param observer  Observer
     */
    public static void addListeners(@NotNull DrawPanel drawPanel,
                                    @NotNull Observer observer) {
        drawPanel.addMouseListener(new ObserverMouseListener(drawPanel, observer));
        drawPanel.addMouseMotionListener(new ObserverMouseMotionListener(drawPanel, observer));
        drawPanel.addMouseWheelListener(new ObserverMouseWheelListener(drawPanel, observer));
    }

    /**
     * Observer mouse listener.
     */
    public static class ObserverMouseListener implements MouseListener {
        private final @NotNull DrawPanel drawPanel;
        private final @NotNull Observer observer;

        private ObserverMouseListener(@NotNull DrawPanel drawPanel,
                                      @NotNull Observer observer) {
            this.drawPanel = drawPanel;
            this.observer = observer;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            mouseClickAction(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {} //unused

        @Override
        public void mousePressed(MouseEvent e) {
            mouseClickAction(e);
        }

        private void mouseClickAction(MouseEvent e) {
            if (drawPanel.panelActive) {
                if (e.getButton() == 1) { //left click
                    @NotNull Dimension panelCenter = drawPanel.getPanelCenter();
                    StaticData.clickPoints.add(new int[] {
                            observer.observerPos[0] + (e.getX() - panelCenter.width) * observer.zoom,
                            observer.observerPos[1] + (e.getY() - panelCenter.height) * observer.zoom});
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            drawPanel.setPanelActive(true);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            drawPanel.setPanelActive(false);
        }
    }

    /**
     * Observer mouse motion listener.
     */
    public static class ObserverMouseMotionListener implements MouseMotionListener {
        private final @NotNull DrawPanel drawPanel;
        private final @NotNull Observer observer;

        private ObserverMouseMotionListener(@NotNull DrawPanel drawPanel,
                                            @NotNull Observer observer) {
            this.drawPanel = drawPanel;
            this.observer = observer;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (drawPanel.panelActive) {
                observer.mousePos[0] = e.getX();
                observer.mousePos[1] = e.getY();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if (drawPanel.panelActive) {
                observer.mousePos[0] = e.getX();
                observer.mousePos[1] = e.getY();
            }
        }
    }

    /**
     * Observer mouse wheel listener.
     */
    public static class ObserverMouseWheelListener implements MouseWheelListener {
        private final @NotNull DrawPanel drawPanel;
        private final @NotNull Observer observer;

        private ObserverMouseWheelListener(@NotNull DrawPanel drawPanel,
                                           @NotNull Observer observer) {
            this.drawPanel = drawPanel;
            this.observer = observer;
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            if (drawPanel.panelActive) {
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
}