package graphics.common.panels.header;

import java.awt.event.ActionEvent;

import org.jetbrains.annotations.NotNull;

import graphicsEngineExtension.input.SimpleButtonListener;

import graphics.common.CommonWindow;

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