package graphics.common.overlays.pages.common;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

/**
 * TODO: add javadocs
 */
public class Button_Back extends SimpleJButton {
    public static final @NotNull String ACTION_COMMAND = "back";

    //TODO: add javadoc
    public Button_Back(@Nullable ActionListener actionListener) {
        super("Back", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}