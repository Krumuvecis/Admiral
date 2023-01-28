package graphics.common.overlays.pages.settings_layout;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphics.common.overlays.pages.common.CommonSizeButton;

/**
 * TODO: add javadocs
 */
class Button_RightPanel extends CommonSizeButton {
    protected static final @NotNull String ACTION_COMMAND = "toggle_rightPanel";

    //TODO: add javadoc
    protected Button_RightPanel(@Nullable ActionListener actionListener) {
        super("Toggle right panel", ACTION_COMMAND, actionListener);
    }
}