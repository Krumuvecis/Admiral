package graphics.devMode.common;

import java.util.List;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;

import graphics.common.CommonWindow;
import graphics.common.CommonPage;

/**
 * TODO: finish this and add javadocs
 */
public abstract class DevPage extends CommonPage {
    /**
     * TODO: finish this javadoc
     */
    public DevPage(@Nullable CommonWindow window,
                   @Nullable List<ActionListener> actionListenerList,
                   @Nullable SimpleColorScheme colors) {
        super(window, actionListenerList, colors);
    }
}