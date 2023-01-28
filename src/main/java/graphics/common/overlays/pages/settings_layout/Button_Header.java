package graphics.common.overlays.pages.settings_layout;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphics.common.overlays.pages.common.CommonSizeButton;

/**
 * TODO: add javadocs
 */
class Button_Header extends CommonSizeButton {
    protected static final @NotNull String ACTION_COMMAND = "toggle_header";

    //TODO: add javadoc
    protected Button_Header(@Nullable ActionListener actionListener) {
        super("Toggle header", ACTION_COMMAND, actionListener);
    }
}