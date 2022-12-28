package graphics.common.overlays.pages.settings_layout;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphics.common.overlays.pages.common.CommonSizeButton;

/**
 * TODO: add javadocs
 */
class Button_LeftPanel extends CommonSizeButton {
    protected static final @NotNull String ACTION_COMMAND = "toggle_leftPanel";

    //TODO: add javadoc
    protected Button_LeftPanel(@Nullable ActionListener actionListener) {
        super("Toggle left panel", ACTION_COMMAND, actionListener);
    }
}