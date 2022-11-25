package graphics.playPage.observer;

import graphics.Window;
import graphics.common.KeyboardListener;
import graphics.playPage.PlayPage;

import java.awt.event.KeyEvent;

import ThreadAbstraction.AbstractUpdater;

public class ObserverKeyboardChecker extends AbstractUpdater {
    private final Window window;
    private final Observer observer;

    ObserverKeyboardChecker(Window window, Observer observer) {
        super(20);
        this.window = window;
        this.observer = observer;
    }

    /**
     * Gets called when thread runs.
     */
    @Override
    public void update() {
        if (window != null && window.getActivePage() instanceof PlayPage) {
            KeyboardListener keyboardListener = window.keyboardListener;
            if (keyboardListener != null) {
                for (int keyCode : keyboardListener.pressedKeys) {
                    keyCheck(keyCode);
                }
            }
        }
    }

    private void keyCheck(int keyCode) {
        String key = KeyEvent.getKeyText(keyCode);
        switch (key) {
            case "A", "Left" -> {
                observer.movement.moveObserver(ObserverMovement.MovementDirection.LEFT);
            }
            case "D", "Right" -> {
                observer.movement.moveObserver(ObserverMovement.MovementDirection.RIGHT);
            }
            case "W", "Up" -> {
                observer.movement.moveObserver(ObserverMovement.MovementDirection.UP);
            }
            case "S", "Down" -> {
                observer.movement.moveObserver(ObserverMovement.MovementDirection.DOWN);
            }
            default -> {}
        }
    }
}