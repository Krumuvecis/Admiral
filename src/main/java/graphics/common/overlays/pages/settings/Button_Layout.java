package graphics.common.overlays.pages.settings;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

/**
 * TODO: add javadocs
 */
class Button_Layout extends SimpleJButton {
    protected static final @NotNull String ACTION_COMMAND = "layout";

    //TODO: add javadoc
    protected Button_Layout(@Nullable ActionListener actionListener) {
        super("Layout settings", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}