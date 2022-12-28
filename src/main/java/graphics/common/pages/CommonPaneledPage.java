package graphics.common.pages;

import java.util.List;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.presets.panels.AbstractFooter;

import graphics.common.CommonWindow;

/**
 * TODO: finish this and add javadocs
 */
public abstract class CommonPaneledPage extends CommonPage {

    /**
     * TODO: finish this javadoc
     */
    public CommonPaneledPage(@Nullable CommonWindow window,
                             @Nullable List<ActionListener> actionListenerList,
                             @Nullable SimpleColorScheme colors) {
        super(window, actionListenerList, colors);
    }

    /**
     * TODO: finish this and add javadoc
     */
    @Override
    public @Nullable AbstractFooter getFooter(@Nullable SimpleColorScheme footerColors,
                                              @Nullable BorderProperties borderProperties) {
        return null;
    }
}