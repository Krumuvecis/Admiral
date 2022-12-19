package graphics.common.overlays;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;

import static consoleUtils.ConsoleUtils.printLine;

import graphics.common.CommonWindow;

/**
 * TODO: add javadocs
 */
public abstract class OverlayButtonListener implements ActionListener {
    private final @NotNull CommonWindow window;

    /**
     * TODO: finish this javadoc
     */
    public OverlayButtonListener(@NotNull CommonWindow window) {
        this.window = window;
    }

    /**
     * TODO: finish this javadoc
     */
    public final @NotNull CommonWindow getWindow() {
        return window;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!actionCheck(e)) {
            printLine("An overlay button has been pressed but no action set up");
        }
    }

    /**
     * TODO: finish this javadoc
     */
    public abstract boolean actionCheck(@NotNull ActionEvent e);

    /**
     * TODO: finish this javadoc
     */
    public final void switchPage(OverlayPageType page) {
        ((PagedOverlay) (getWindow().getOverlay())).setPage(page);
    }
}