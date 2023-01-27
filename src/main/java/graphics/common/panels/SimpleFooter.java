package graphics.common.panels;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.pages.panels.AbstractFooter;

//TODO: finish this
public class SimpleFooter extends AbstractFooter {
    private static final int HEIGHT = 40;

    /**
     * TODO: finish this javadoc
     */
    public SimpleFooter(@Nullable SimpleColorScheme colors,
                        @Nullable BorderProperties borderProperties) {
        super(colors, HEIGHT, borderProperties);
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public final void addParts() {}
}