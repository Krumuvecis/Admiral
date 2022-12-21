package graphics.common.header;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.presets.panels.AbstractHeader;

/**
 * TODO: finish this and add javadocs
 */
public abstract class SimpleHeader extends AbstractHeader {
    private static final int HEIGHT = 40;

    /**
     * TODO: finish this javadoc
     */
    public SimpleHeader(@Nullable SimpleColorScheme colors,
                        @Nullable BorderProperties borderProperties,
                        @Nullable SimpleHeaderButtonListener buttonListener) {
        super(colors, HEIGHT, borderProperties);
        addButtons(buttonListener);
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public final void addParts() {}

    /**
     * TODO: finish this javadoc
     */
    public abstract void addButtons(@Nullable SimpleHeaderButtonListener buttonListener);
}