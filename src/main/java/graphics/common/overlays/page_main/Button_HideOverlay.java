package graphics.common.overlays.page_main;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

/**
 * TODO: add javadocs
 */
class Button_HideOverlay extends SimpleJButton {
    protected static final String ACTION_COMMAND = "overlay_back";

    //
    protected Button_HideOverlay(@Nullable ActionListener actionListener) {
        super("Back", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}