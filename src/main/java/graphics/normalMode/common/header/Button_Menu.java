package graphics.normalMode.common.header;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

/**
 * TODO: add javadocs
 */
class Button_Menu extends SimpleJButton {
    protected static final String ACTION_COMMAND = "overlay_menu";

    protected Button_Menu(@Nullable ActionListener actionListener) {
        super("Menu", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}