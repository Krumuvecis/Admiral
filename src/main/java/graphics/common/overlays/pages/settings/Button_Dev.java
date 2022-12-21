package graphics.common.overlays.pages.settings;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphics.common.overlays.pages.common.CommonSizeButton;

/**
 * TODO: add javadocs
 */
class Button_Dev extends CommonSizeButton {
    protected static final @NotNull String ACTION_COMMAND = "dev";

    //TODO: add javadoc
    protected Button_Dev(@Nullable ActionListener actionListener) {
        super("Dev settings", ACTION_COMMAND, actionListener);
    }
}