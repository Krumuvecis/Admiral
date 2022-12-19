package graphics.common.overlays.pages.main;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

/**
 * TODO: add javadocs
 */
class Button_Exit extends SimpleJButton {
    protected static final @NotNull String ACTION_COMMAND = "exit";

    //TODO: add javadoc
    protected Button_Exit(@Nullable ActionListener actionListener) {
        super("Exit (unfinished)", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}