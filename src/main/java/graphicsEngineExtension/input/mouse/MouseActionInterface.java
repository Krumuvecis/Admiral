package graphicsEngineExtension.input.mouse;

import org.jetbrains.annotations.NotNull;

/**
 * An interface for the most common mouse actions.
 */
public interface MouseActionInterface {
    /**
     * Invoked when the mouse enters a component.
     */
    void mouseEntered();

    /**
     * Invoked when the mouse exits a component.
     */
    void mouseExited();

    /**
     * Invoked when the mouse cursor has been moved onto a component
     * but no buttons have been pushed.
     *
     * @param location Location {x, y} of the mouse cursor.
     */
    void moved(int @NotNull [] location);

    /**
     * Invoked when a mouse button is pressed on a component and then
     * dragged.
     *
     * @param location Location {x, y} of the mouse cursor.
     * @param button   The number of the pressed button. (1 - left, 2 - right)
     */
    void dragged(int @NotNull [] location, int button);

    /**
     * Invoked when the left mouse button has been pressed on a component.
     *
     * @param location Location {x, y} of the mouse cursor.
     */
    void leftClick(int @NotNull [] location);

    /**
     * Invoked when the right mouse button has been pressed on a component.
     *
     * @param location Location {x, y} of the mouse cursor.
     */
    void rightClick(int @NotNull [] location);

    /**
     * Invoked when the mouse wheel is rotated.
     *
     * @param amount The number of "clicks" the mouse wheel was rotated, as an integer.
     *               Negative values if the mouse wheel was rotated up/away from
     *               the user, and positive values if the mouse wheel was rotated
     *               down/towards the user.
     */
    void scroll(int amount);
}