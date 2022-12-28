package graphics.common.panels.header;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

/**
 * TODO: add javadocs
 */
public class Button_Menu extends SimpleJButton {
    public static final String ACTION_COMMAND = "overlay_menu";

    public Button_Menu(@Nullable ActionListener actionListener) {
        super("Menu", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}