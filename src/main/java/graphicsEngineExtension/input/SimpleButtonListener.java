package graphicsEngineExtension.input;

import java.util.Objects;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static consoleUtils.ConsoleUtils.printLine;
import graphicsEngine.windows.AbstractWindow;

//TODO: add javadocs
public abstract class SimpleButtonListener implements ActionListener {
    private final @NotNull AbstractWindow window;

    /**
     * TODO: finish this javadoc
     */
    public SimpleButtonListener(@NotNull AbstractWindow window) {
        this.window = window;
    }

    /**
     * TODO: finish this javadoc
     */
    public final @NotNull AbstractWindow getWindow() {
        return window;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public final void actionPerformed(ActionEvent e) {
        if (!actionCheck(e)) {
            printLine("A button has been pressed but no action set up");
            @NotNull String nonNullLocationName = Objects.requireNonNullElse(
                    listenableName(),
                    "name not defined");
            printLine("Location: " + nonNullLocationName);
        }
    }

    /**
     * TODO: finish this javadoc
     */
    public abstract @Nullable String listenableName();

    /**
     * TODO: finish this javadoc
     */
    public abstract boolean actionCheck(@NotNull ActionEvent e);
}