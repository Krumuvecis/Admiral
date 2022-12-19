package graphics.normalMode.common.header;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

/**
 * TODO: add javadocs
 */
class Button_Pause extends SimpleJButton {
    protected static final String ACTION_COMMAND = "pause";

    protected Button_Pause(@Nullable ActionListener actionListener) {
        super("Toggle pause", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}