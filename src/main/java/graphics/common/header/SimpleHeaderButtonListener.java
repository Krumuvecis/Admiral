package graphics.common.header;

import java.awt.event.ActionEvent;

import org.jetbrains.annotations.NotNull;

import graphics.common.CommonWindow;
import graphics.common.SimpleButtonListener;

/**
 * TODO: add javadocs
 */
public abstract class SimpleHeaderButtonListener extends SimpleButtonListener {

    /**
     * TODO: finish this javadoc
     */
    public SimpleHeaderButtonListener(@NotNull CommonWindow window) {
        super(window);
    }

    @Override
    public @NotNull String listenableName() {
        return "Header";
    }

    /**
     * TODO: finish this javadoc
     */
    public abstract boolean actionCheck(@NotNull ActionEvent e);
}