package graphics2;

import java.awt.Dimension;

import org.jetbrains.annotations.NotNull;

import graphicsEngineExtension.mouseListeners.MouseActionInterface;

import graphics2.observablePanels.ObservablePanel;

import staticData.StaticData;

//TODO: add javadocs
public class ObserverMouseActions implements MouseActionInterface {
    private final @NotNull ObservablePanel panel;
    private final @NotNull Observer observer;

    //TODO: add javadoc
    public ObserverMouseActions(@NotNull ObservablePanel panel,
                                @NotNull Observer observer) {
        this.panel = panel;
        this.observer = observer;
    }

    /**
     * Invoked when the mouse enters a component.
     */
    @Override
    public void mouseEntered() {
        panel.setPanelActive(true);
    }

    /**
     * Invoked when the mouse exits a component.
     */
    @Override
    public void mouseExited() {
        panel.setPanelActive(false);
    }

    /**
     * Invoked when the mouse cursor has been moved onto a component
     * but no buttons have been pushed.
     *
     * @param location Location {x, y} of the mouse cursor.
     */
    @Override
    public void moved(int @NotNull [] location) {
        setObserverMousePos(location);
    }

    /**
     * Invoked when a mouse button is pressed on a component and then
     * dragged.
     *
     * @param location Location {x, y} of the mouse cursor.
     * @param button   The number of the pressed button. (1 - left, 2 - right)
     */
    @Override
    public void dragged(int @NotNull [] location, int button) {
        setObserverMousePos(location);
    }

    private void setObserverMousePos(int @NotNull [] location) {
        if (panel.getPanelActive()) {
            observer.mousePos[0] = location[0];
            observer.mousePos[1] = location[1];
        }
    }

    /**
     * Invoked when the left mouse button has been pressed on a component.
     *
     * @param location Location {x, y} of the mouse cursor.
     */
    @Override
    public void leftClick(int @NotNull [] location) {
        if (panel.getPanelActive()) {
            @NotNull Dimension panelCenter = panel.getPanelCenter();
            int zoom = observer.zoom.getZoom();
            int @NotNull []
                    observerLocation = observer.location.getLocation(),
                    clickPointLocation = getClickPointLocation(panelCenter, location, observerLocation, zoom);
            addClickPoint(clickPointLocation);
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

    /**
     * Invoked when the right mouse button has been pressed on a component.
     *
     * @param location Location {x, y} of the mouse cursor.
     */
    @Override
    public void rightClick(int @NotNull [] location) {
        //unused
    }

    /**
     * Invoked when the mouse wheel is rotated.
     *
     * @param amount The number of "clicks" the mouse wheel was rotated, as an integer.
     *               Negative values if the mouse wheel was rotated up/away from
     *               the user, and positive values if the mouse wheel was rotated
     *               down/towards the user.
     */
    @Override
    public void scroll(int amount) {
        if (panel.getPanelActive()) {
            observer.zoom.adjustZoom(amount);
        }
    }
}