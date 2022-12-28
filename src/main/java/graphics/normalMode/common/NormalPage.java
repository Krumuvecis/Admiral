package graphics.normalMode.common;

import java.util.List;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.presets.panels.AbstractHeader;

import graphics.common.CommonWindow;
import graphics.common.pages.SimplePaneledPage;
import graphics.normalMode.common.header.*;

/**
 * TODO: finish this and add javadocs
 */
public abstract class NormalPage extends SimplePaneledPage {
    private HeaderButtonListener headerButtonListener;

    /**
     * TODO: finish this javadoc
     */
    public NormalPage(@Nullable CommonWindow window,
                      @Nullable List<ActionListener> actionListenerList,
                      @Nullable SimpleColorScheme colors) {
        super(window, actionListenerList, colors);
    }

    //TODO: add javadoc
    public static @NotNull HeaderButtonListener getNewHeaderListener(@NotNull CommonWindow window) {
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
    public @NotNull AbstractHeader getHeader(@Nullable SimpleColorScheme headerColors,
                                             @Nullable BorderProperties borderProperties) {
        return new Header(headerColors, borderProperties, headerButtonListener);
    }
}