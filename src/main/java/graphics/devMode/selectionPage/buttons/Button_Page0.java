package graphics.devMode.selectionPage.buttons;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.parts.SimpleJButton;

/**
 * TODO: add javadocs
 */
public class Button_Page0 extends SimpleJButton {
    protected static final String ACTION_COMMAND = "page_0";

    public Button_Page0(@Nullable ActionListener actionListener) {
        super("Page0 - template", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}