package graphics.common.overlays.pages.settings;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

/**
 * TODO: add javadocs
 */
class Button_Dev extends SimpleJButton {
    protected static final @NotNull String ACTION_COMMAND = "dev";

    //TODO: add javadoc
    protected Button_Dev(@Nullable ActionListener actionListener) {
        super("Dev settings", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}