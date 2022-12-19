package graphics.common.overlays;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;

import static consoleUtils.ConsoleUtils.printLine;

import graphics.common.CommonWindow;

/**
 * TODO: add javadocs
 */
public class OverlayButtonListener implements ActionListener {
    private final CommonWindow window;

    /**
     * TODO: finish this javadoc
     */
    public OverlayButtonListener(@NotNull CommonWindow window) {
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
}