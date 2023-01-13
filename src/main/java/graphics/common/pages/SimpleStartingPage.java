package graphics.common.pages;

import java.util.List;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.pages.panels.AbstractHeader;
import graphicsEngine.pages.panels.AbstractFooter;
import graphicsEngine.pages.panels.AbstractLeftPanel;
import graphicsEngine.pages.panels.AbstractRightPanel;

import graphics.common.CommonWindow;

/**
 * TODO: finish this and add javadocs
 */
public abstract class SimpleStartingPage extends SimplePaneledPage {
    /**
     * TODO: finish this javadoc
     */
    public SimpleStartingPage(@Nullable CommonWindow window,
                              @Nullable List<@Nullable ActionListener> actionListenerList) {
        super(window, actionListenerList);
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public final @Nullable AbstractHeader getHeader(
            @Nullable SimpleColorScheme headerColors,
            @Nullable BorderProperties borderProperties) {
        return null;
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public final @Nullable AbstractFooter getFooter(
            @Nullable SimpleColorScheme footerColors,
            @Nullable BorderProperties borderProperties) {
        return null;
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public final @Nullable AbstractLeftPanel getLeftPanel(
            @Nullable SimpleColorScheme colors,
            @Nullable BorderProperties borderProperties) {
        return null;
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public final @Nullable AbstractRightPanel getRightPanel(
            @Nullable SimpleColorScheme colors,
            @Nullable BorderProperties borderProperties) {
        return null;
    }
}