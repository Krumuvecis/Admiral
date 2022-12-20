package graphics.normalMode.playPage.leftPanel.leftDrawPanel;

import java.util.List;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;

import org.jetbrains.annotations.NotNull;

import graphics.normalMode.NormalWindow;
import graphics.normalMode.playPage.observer.Observer;

//TODO: add javadocs
class ObserverInfoSection extends AbstractTextSection {
    private final static int MAX_LINES = 6;
    private final @NotNull NormalWindow window;
    private final @NotNull Observer observer;

    //TODO: add javadoc
    ObserverInfoSection(@NotNull NormalWindow window,
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
        drawLineOfText(g, textColor, sectionLocation,
                "Pressed keys:");
        @NotNull List<Integer> keys = window.getPressedKeys();
        for (int i = 0; i < keys.size(); i++) {
            int key = keys.get(i);
            drawLineOfText(g, textColor, sectionLocation,
                    (i + 1) + " - " + key + " - " + KeyEvent.getKeyText(key));
        }
    }
}