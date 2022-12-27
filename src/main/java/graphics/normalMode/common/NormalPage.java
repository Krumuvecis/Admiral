package graphics.normalMode.common;

import java.util.List;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;

import graphics.common.CommonWindow;
import graphics.common.CommonPage;

/**
 * TODO: finish this and add javadocs
 */
public abstract class NormalPage extends CommonPage {
    /**
     * TODO: finish this javadoc
     */
    public NormalPage(@Nullable CommonWindow window,
                      @Nullable List<ActionListener> actionListenerList,
                      @Nullable SimpleColorScheme colors) {
        super(window, actionListenerList, colors);
    }
}