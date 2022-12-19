package graphics.common.overlays.pages.main;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

/**
 * TODO: add javadocs
 */
class Button_Pause extends SimpleJButton {
    protected static final @NotNull String ACTION_COMMAND = "pause";

    //TODO: add javadoc
    protected Button_Pause(@Nullable ActionListener actionListener) {
        super("Pause", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}