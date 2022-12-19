package graphics.common.overlays;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

/**
 * TODO: add javadocs
 */
public class Button_HideOverlay extends SimpleJButton {
    public static final String ACTION_COMMAND = "overlay_back";

    protected Button_HideOverlay(@Nullable ActionListener actionListener) {
        super("Back", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}