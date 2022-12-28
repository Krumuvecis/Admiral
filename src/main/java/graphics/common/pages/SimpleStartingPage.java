package graphics.common.pages;

import java.util.List;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.presets.panels.AbstractHeader;
import graphicsEngine.presets.panels.AbstractFooter;

import graphics.common.CommonWindow;

/**
 * TODO: finish this and add javadocs
 */
public abstract class SimpleStartingPage extends AbstractSimplePage {
    /**
     * TODO: finish this javadoc
     */
    public SimpleStartingPage(@Nullable CommonWindow window,
                              @Nullable List<ActionListener> actionListenerList,
                              @Nullable SimpleColorScheme colors) {
        super(window, actionListenerList, colors);
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public final @Nullable AbstractHeader getHeader(@Nullable SimpleColorScheme headerColors,
                                                    @Nullable BorderProperties borderProperties) {
        return null;
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public final @Nullable AbstractFooter getFooter(@Nullable SimpleColorScheme footerColors,
                                                    @Nullable BorderProperties borderProperties) {
        return null;
    }
}