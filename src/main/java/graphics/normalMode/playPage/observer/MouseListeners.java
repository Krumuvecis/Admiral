package graphics.normalMode.playPage.observer;

import java.awt.Dimension;
import java.awt.event.*;

import org.jetbrains.annotations.NotNull;

import staticData.StaticData;

import graphics.normalMode.playPage.drawPanel.DrawPanel;

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

        //TODO: add javadoc
        @Override
        public void mouseClicked(MouseEvent e) {
            mouseClickAction(e);
        }

        //TODO: add javadoc
        @Override
        public void mouseReleased(MouseEvent e) {} //unused

        //TODO: add javadoc
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

        //TODO: add javadoc
        @Override
        public void mouseEntered(MouseEvent e) {
            drawPanel.setPanelActive(true);
        }

        //TODO: add javadoc
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

        //TODO: add javadoc
        @Override
        public void mouseDragged(MouseEvent e) {
            if (drawPanel.panelActive) {
                observer.mousePos[0] = e.getX();
                observer.mousePos[1] = e.getY();
            }
        }

        //TODO: add javadoc
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

        //TODO: add javadoc
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