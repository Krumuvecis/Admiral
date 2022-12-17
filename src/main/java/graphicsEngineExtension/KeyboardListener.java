package graphicsEngineExtension;

import java.util.List;
import java.util.ArrayList;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public class KeyboardListener implements KeyListener {
    //TODO: add javadoc
    public final @NotNull List<Integer> pressedKeys = new ArrayList<>();

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {
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
    public void keyPressed(KeyEvent e) {
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
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < pressedKeys.size(); i++) {
            if (pressedKeys.get(i) == key) {
                pressedKeys.remove(i);
                return;
            }
        }
    }
}