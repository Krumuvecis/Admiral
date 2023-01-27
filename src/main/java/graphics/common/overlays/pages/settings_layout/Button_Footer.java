package graphics.common.overlays.pages.settings_layout;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphics.common.overlays.pages.common.CommonSizeButton;

/**
 * TODO: add javadocs
 */
class Button_Footer extends CommonSizeButton {
    protected static final @NotNull String ACTION_COMMAND = "toggle_footer";

    //TODO: add javadoc
    protected Button_Footer(@Nullable ActionListener actionListener) {
        super("Toggle footer", ACTION_COMMAND, actionListener);
    }
}