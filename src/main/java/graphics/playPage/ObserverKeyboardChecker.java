package graphics.playPage;

import graphics.Window;
import graphics.common.KeyboardListener;

import ThreadAbstraction.AbstractUpdater;

import java.awt.event.KeyEvent;

import consoleUtils.ConsoleUtils;

public class ObserverKeyboardChecker extends AbstractUpdater {
    private final Window window;

    ObserverKeyboardChecker(Window window) {
        super(20);
        this.window = window;
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
            case "A", "LEFT" -> {
                ConsoleUtils.printLine("left");
            }
            case "D", "RIGHT" -> {
                ConsoleUtils.printLine("right");
            }
            case "W", "UP" -> {
                ConsoleUtils.printLine("up");
            }
            case "S", "DOWN" -> {
                ConsoleUtils.printLine("down");
            }
            default -> {}
        }
    }
}