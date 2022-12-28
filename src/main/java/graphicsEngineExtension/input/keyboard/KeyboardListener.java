package graphicsEngineExtension.input.keyboard;

import java.util.List;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public class KeyboardListener implements KeyListener {
    //TODO: add javadoc
    private final @NotNull List<Integer> pressedKeys = new ArrayList<>();

    public final @NotNull List<Integer> getKeys() {
        return List.copyOf(pressedKeys);
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */
    @Override
    public final void keyTyped(KeyEvent e) {
        //unused
    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e the event to be processed
     */
    @Override
    public final void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (Integer pressedKey : pressedKeys) {
            if (pressedKey == key) {
                return;
            }
        }
        pressedKeys.add(key);
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e the event to be processed
     */
    @Override
    public final void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < pressedKeys.size(); i++) {
            if (pressedKeys.get(i) == key) {
                pressedKeys.remove(i);
                return;
            }
        }
    }
}