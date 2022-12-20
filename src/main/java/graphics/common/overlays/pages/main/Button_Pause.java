package graphics.common.overlays.pages.main;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphics.common.overlays.pages.common.CommonSizeButton;

/**
 * TODO: add javadocs
 */
class Button_Pause extends CommonSizeButton {
    protected static final @NotNull String ACTION_COMMAND = "pause";

    //TODO: add javadoc
    protected Button_Pause(@Nullable ActionListener actionListener) {
        super("Toggle pause", ACTION_COMMAND, actionListener);
    }
}