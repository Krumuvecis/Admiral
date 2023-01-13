package graphics.normalMode.startingPage.buttons;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.parts.SimpleJButton;

/**
 * TODO: add javadocs
 */
public class Button_Play extends SimpleJButton {
    protected static final String ACTION_COMMAND = "page_play";

    public Button_Play(@Nullable ActionListener actionListener) {
        super("Play", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}