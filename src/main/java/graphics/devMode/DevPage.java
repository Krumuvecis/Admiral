package graphics.devMode;

import java.util.List;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.presets.panels.AbstractHeader;

import graphics.common.CommonWindow;
import graphics.common.CommonPage;
import graphics.normalMode.common.header.HeaderButtonListener;

/**
 * TODO: finish this and add javadocs
 */
public abstract class DevPage extends CommonPage {
    private HeaderButtonListener headerButtonListener;

    /**
     * TODO: finish this javadoc
     */
    public DevPage(@Nullable CommonWindow window,
                   @Nullable List<ActionListener> actionListenerList,
                   @Nullable SimpleColorScheme colors) {
        super(window, actionListenerList, colors);
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
        return null;
        //return new CommonHeader(headerColors, borderProperties, headerButtonListener);
    }
}