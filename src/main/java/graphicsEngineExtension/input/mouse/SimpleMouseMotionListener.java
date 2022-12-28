package graphicsEngineExtension.input.mouse;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

import org.jetbrains.annotations.NotNull;

/**
 * A simple mouse motion listener.
 */
public class SimpleMouseMotionListener implements MouseMotionListener {
    private final @NotNull MouseActionInterface actionInterface;

    /**
     * Creates a new simple mouse motion listener.
     *
     * @param actionInterface Reference acton interface.
     */
    public SimpleMouseMotionListener(@NotNull MouseActionInterface actionInterface) {
        this.actionInterface = actionInterface;
    }

    /**
     * Invoked when the mouse cursor has been moved onto a component
     * but no buttons have been pushed.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseMoved(@NotNull MouseEvent e) {
        actionInterface.moved(new int[] {e.getX(), e.getY()});
    }

    /**
     * Invoked when a mouse button is pressed on a component and then
     * dragged.  {@code MOUSE_DRAGGED} events will continue to be
     * delivered to the component where the drag originated until the
     * mouse button is released (regardless of whether the mouse position
     * is within the bounds of the component).
     * <p>
     * Due to platform-dependent Drag&amp;Drop implementations,
     * {@code MOUSE_DRAGGED} events may not be delivered during a native
     * Drag&amp;Drop operation.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(@NotNull MouseEvent e) {
        actionInterface.dragged(new int[] {e.getX(), e.getY()}, e.getButton());
    }
}