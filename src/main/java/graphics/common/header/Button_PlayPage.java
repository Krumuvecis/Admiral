package graphics.common.header;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

/**
 * TODO: add javadocs
 */
class Button_PlayPage extends SimpleJButton {
    protected static final String ACTION_COMMAND = "page_play";

    protected Button_PlayPage(@Nullable ActionListener actionListener) {
        super("Play page", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}
