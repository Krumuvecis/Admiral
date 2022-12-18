package graphics.common.header;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

/**
 * TODO: add javadocs
 */
class Button_StartingPage extends SimpleJButton {
    protected static final String ACTION_COMMAND = "page_starting";

    protected Button_StartingPage(@Nullable ActionListener actionListener) {
        super("Starting page", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}
