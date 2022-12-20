package graphics.common.header;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;

import static consoleUtils.ConsoleUtils.printLine;

import graphics.common.CommonWindow;

/**
 * TODO: add javadocs
 */
public abstract class SimpleHeaderButtonListener implements ActionListener {
    private final @NotNull CommonWindow window;

    /**
     * TODO: finish this javadoc
     */
    public SimpleHeaderButtonListener(@NotNull CommonWindow window) {
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
    public final void actionPerformed(ActionEvent e) {
        if (window.pageListenersEnabled) {
            if (actionCheck(e)) return;
            printLine("A header button has been pressed but no action set up");
        }
    }

    /**
     * TODO: finish this javadoc
     */
    public abstract boolean actionCheck(@NotNull ActionEvent e);
}