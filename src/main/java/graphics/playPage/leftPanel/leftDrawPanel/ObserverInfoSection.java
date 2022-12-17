package graphics.playPage.leftPanel.leftDrawPanel;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngineExtension.KeyboardListener;

import graphics.Window;
import graphics.playPage.observer.Observer;

//TODO: add javadocs
class ObserverInfoSection extends AbstractTextSection {
    private final static int MAX_LINES = 6;
    private final @NotNull Window window;
    private final @NotNull Observer observer;

    //TODO: add javadoc
    ObserverInfoSection(@NotNull Window window,
                        @NotNull Observer observer) {
        super();
        this.window = window;
        this.observer = observer;
    }

    //TODO: add javadoc
    @Override
    final void draw(@NotNull Graphics g,
              @NotNull Color textColor,
              int verticalOffset) {
        super.draw(g, textColor, verticalOffset);
        drawKeyInfo(g, textColor);
    }

    //TODO: add javadoc
    @Override
    final int getLastLineIndex() {
        return MAX_LINES;
    }

    private void drawKeyInfo(@NotNull Graphics g,
                             @NotNull Color textColor) {
        @Nullable KeyboardListener keyboardListener = window.keyboardListener;
        drawLineOfText(g, textColor, sectionLocation,
                "Pressed keys:");

        if (keyboardListener == null) {
            drawLineOfText(g, textColor, sectionLocation,
                    "Keyboard listener not initialized.");
        } else {
            for (int i = 0; i < keyboardListener.pressedKeys.size(); i++) {
                int key = keyboardListener.pressedKeys.get(i);
                drawLineOfText(g, textColor, sectionLocation,
                        (i + 1) + " - " + key + " - " + KeyEvent.getKeyText(key));
            }
        }
    }
}