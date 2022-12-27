package graphics.devMode.selectionPage.buttons;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

/**
 * TODO: add javadocs
 */
public class Button_Page2 extends SimpleJButton {
    protected static final String ACTION_COMMAND = "page_2";

    public Button_Page2(@Nullable ActionListener actionListener) {
        super("Page2", ACTION_COMMAND, actionListener);
        setFocusable(false);
    }
}