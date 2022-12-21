package graphics.devMode.common.header;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

/**
 * TODO: add javadocs
 */
class Button_SelectionPage extends SimpleJButton {
    protected static final String ACTION_COMMAND = "page_selection";

    protected Button_SelectionPage(@Nullable ActionListener actionListener) {
        super("Selection page", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}