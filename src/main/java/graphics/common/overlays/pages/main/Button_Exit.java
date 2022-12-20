package graphics.common.overlays.pages.main;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphics.common.overlays.pages.common.CommonSizeButton;

/**
 * TODO: add javadocs
 */
class Button_Exit extends CommonSizeButton {
    protected static final @NotNull String ACTION_COMMAND = "exit";

    //TODO: add javadoc
    protected Button_Exit(@Nullable ActionListener actionListener) {
        super("Exit", ACTION_COMMAND, actionListener);
    }
}