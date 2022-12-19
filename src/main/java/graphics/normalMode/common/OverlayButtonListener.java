package graphics.normalMode.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static consoleUtils.ConsoleUtils.printLine;

import graphicsEngine.presets.SimpleJButton;

import graphics.normalMode.NormalWindow;

/**
 * TODO: add javadocs
 */
public class OverlayButtonListener implements ActionListener {
    private final NormalWindow window;

    /**
     * TODO: finish this javadoc
     */
    public OverlayButtonListener(@NotNull NormalWindow window) {
        this.window = window;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (actionCheck(e)) return;
        printLine("An overlay button has been pressed but no action set up");
    }

    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    private boolean actionCheck(@NotNull ActionEvent e) {
        switch (e.getActionCommand()) {
            case Button_HideOverlay.ACTION_COMMAND ->
                    window.toggleOverlay();
            //add new overlay button actions here
            default -> {
                return false;
            }
        }
        return true;
    }

    /**
     * TODO: add javadocs
     */
    public static class Button_HideOverlay extends SimpleJButton {
        public static final String ACTION_COMMAND = "overlay_back";

        protected Button_HideOverlay(@Nullable ActionListener actionListener) {
            super("Back", ACTION_COMMAND, actionListener);
            setFocusable(false);
        }
    }
}