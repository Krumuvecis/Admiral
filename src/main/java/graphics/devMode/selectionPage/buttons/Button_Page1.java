package graphics.devMode.selectionPage.buttons;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

/**
 * TODO: add javadocs
 */
public class Button_Page1 extends SimpleJButton {
    protected static final String ACTION_COMMAND = "page_1";

    public Button_Page1(@Nullable ActionListener actionListener) {
        super("Page1", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}