package graphics.common.overlays.pages.common;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.presets.SimpleJButton;

//TODO: add javadocs
public abstract class CommonSizeButton extends SimpleJButton {
    private static final @NotNull Dimension BUTTON_SIZE = new Dimension(150, 25);

    //TODO: add javadoc
    public CommonSizeButton(@Nullable String title,
                            @NotNull String actionCommand,
                            @Nullable ActionListener actionListener) {
        super(title, actionCommand, actionListener);
        setFocusable(false);
        setButtonSize(BUTTON_SIZE);
    }

    @SuppressWarnings("SameParameterValue")
    private void setButtonSize(@NotNull Dimension size) {
        setSize(size);
        setPreferredSize(getSize()); //ensures vertical sizing
        setMaximumSize(getSize()); //ensures horizontal sizing
        setMinimumSize(getSize()); //prevents resizing
    }
}