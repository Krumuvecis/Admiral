package graphics.playPage;

import graphics.Window;
import graphics.common.KeyboardListener;

import ThreadAbstraction.AbstractUpdater;

import java.awt.event.KeyEvent;

public class ObserverKeyboardChecker extends AbstractUpdater {
    private final Window window;
    private final ObserverInfo observerInfo;

    ObserverKeyboardChecker(Window window, ObserverInfo observerInfo) {
        super(20);
        this.window = window;
        this.observerInfo = observerInfo;
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
                observerInfo.moveObserver(ObserverInfo.ObserverMovementDirection.LEFT);
            }
            case "D", "Right" -> {
                observerInfo.moveObserver(ObserverInfo.ObserverMovementDirection.RIGHT);
            }
            case "W", "Up" -> {
                observerInfo.moveObserver(ObserverInfo.ObserverMovementDirection.UP);
            }
            case "S", "Down" -> {
                observerInfo.moveObserver(ObserverInfo.ObserverMovementDirection.DOWN);
            }
            default -> {}
        }
    }
}