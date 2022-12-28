package graphicsEngineExtension.mouse;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import org.jetbrains.annotations.NotNull;

/**
 * A simple mouse listener.
 */
public class SimpleMouseListener implements MouseListener {
    private final @NotNull MouseActionInterface actionInterface;

    /**
     * Creates a new simple mouse listener.
     *
     * @param actionInterface Reference acton interface.
     */
    public SimpleMouseListener(@NotNull MouseActionInterface actionInterface) {
        this.actionInterface = actionInterface;
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(@NotNull MouseEvent e) {
        buttonCheck(e);
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(@NotNull MouseEvent e) {
        buttonCheck(e);
    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(@NotNull MouseEvent e) {
        //unused
    }

    private void buttonCheck(@NotNull MouseEvent e) {
        switch (e.getButton()) {
            case 1 -> actionInterface.leftClick(getMouseLocation(e)); //left click
            case 2 -> actionInterface.rightClick(getMouseLocation(e)); //right click
            default -> {}
        }
    }

    private int @NotNull [] getMouseLocation(@NotNull MouseEvent e) {
        return new int[] {e.getX(), e.getY()};
    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(@NotNull MouseEvent e) {
        actionInterface.mouseEntered();
    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(@NotNull MouseEvent e) {
        actionInterface.mouseExited();
    }
}