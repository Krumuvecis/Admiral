package graphics.devMode.common;

import java.util.List;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.pages.panels.AbstractHeader;
import graphicsEngine.pages.panels.AbstractFooter;
import graphicsEngine.pages.panels.AbstractRightPanel;

import graphics.common.CommonWindow;
import graphics.common.pages.SimplePaneledPage;
import graphics.devMode.common.header.*;

/**
 * TODO: finish this and add javadocs
 */
public abstract class DevPage extends SimplePaneledPage {
    private HeaderButtonListener headerButtonListener;

    /**
     * TODO: finish this javadoc
     */
    public DevPage(@Nullable CommonWindow window,
                   @Nullable List<ActionListener> actionListenerList) {
        super(window, actionListenerList);
    }

    public static @NotNull ActionListener getNewHeaderListener(@NotNull CommonWindow window) {
        return new HeaderButtonListener(window);
    }

    //TODO: add javadoc
    @Override
    public boolean addParticularListener(@Nullable ActionListener listener) {
        if (listener instanceof HeaderButtonListener) {
            headerButtonListener = (HeaderButtonListener) listener;
            return true;
        }
        return false;
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public @Nullable AbstractHeader getHeader(@Nullable SimpleColorScheme headerColors,
                                              @Nullable BorderProperties borderProperties) {
        return new Header(headerColors, borderProperties, headerButtonListener);
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
    public final @Nullable AbstractRightPanel getRightPanel(
            @Nullable SimpleColorScheme colors,
            @Nullable BorderProperties borderProperties) {
        return null;
    }
}