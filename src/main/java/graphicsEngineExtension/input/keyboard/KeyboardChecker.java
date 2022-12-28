package graphicsEngineExtension.input.keyboard;

import java.awt.event.KeyEvent;

import org.jetbrains.annotations.NotNull;

import ThreadAbstraction.AbstractUpdater;

import graphicsEngineExtension.windows.KeyboardListenableWindow;

//TODO: add javadocs
public abstract class KeyboardChecker extends AbstractUpdater {
    private static final int CHECK_DELAY = 20; //in milliseconds
    private final @NotNull KeyboardListenableWindow window;

    //TODO: add javadoc
    public KeyboardChecker(@NotNull KeyboardListenableWindow window) {
        super(CHECK_DELAY);
        this.window = window;
    }

    //
    public final @NotNull KeyboardListenableWindow getKeyboardListenableWindow() {
        return window;
    }

    /**
     * Gets called when thread runs.
     */
    @Override
    public final void update() {
        if (getCheckerActiveState()) {
            for (int keyCode : window.getPressedKeys()) {
                @NotNull String key = KeyEvent.getKeyText(keyCode);
                keyCheck(key);
            }
        }
    }

    //
    public abstract boolean getCheckerActiveState();

    //
    public abstract void keyCheck(@NotNull String key);
}