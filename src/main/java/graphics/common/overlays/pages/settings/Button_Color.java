package graphics.common.overlays.pages.settings;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphics.common.overlays.pages.common.CommonSizeButton;

/**
 * TODO: add javadocs
 */
class Button_Color extends CommonSizeButton {
    protected static final @NotNull String ACTION_COMMAND = "color";

    //TODO: add javadoc
    protected Button_Color(@Nullable ActionListener actionListener) {
        super("Color settings", ACTION_COMMAND, actionListener);
    }
}