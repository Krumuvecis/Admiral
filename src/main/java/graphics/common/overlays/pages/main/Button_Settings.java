package graphics.common.overlays.pages.main;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

/**
 * TODO: add javadocs
 */
class Button_Settings extends SimpleJButton {
    protected static final @NotNull String ACTION_COMMAND = "settings";

    //TODO: add javadoc
    protected Button_Settings(@Nullable ActionListener actionListener) {
        super("Settings", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}