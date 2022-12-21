package graphics.common.overlays.pages.main;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphics.common.overlays.pages.common.CommonSizeButton;

/**
 * TODO: add javadocs
 */
class Button_Settings extends CommonSizeButton {
    protected static final @NotNull String ACTION_COMMAND = "settings";

    //TODO: add javadoc
    protected Button_Settings(@Nullable ActionListener actionListener) {
        super("Settings", ACTION_COMMAND, actionListener);
    }
}