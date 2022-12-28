package graphics.common.pages;

import java.util.List;
import java.awt.Color;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.panels.DynamicPanel;
import graphicsEngine.presets.panels.AbstractFooter;

import graphics.common.CommonWindow;
import graphics.common.panels.AbstractLeftPanel;
import graphics.common.panels.AbstractRightPanel;

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

    //TODO: add javadoc
    @Override
    public final void setBodyParameters() {
        //TODO: set body parameters here
    }

    //TODO: add javadoc
    @Override
    public final @Nullable Component getPageBody() {
        @Nullable CommonWindow window = getWindow();
        if (window == null) {
            return null;
        } else {
            @Nullable Color backgroundColor = ColorUtilities.DEFAULT_COLOR_TRANSPARENT;
            return new DynamicPanel(new SimpleColorScheme(backgroundColor, null)) {
                {
                    setLayout(new BorderLayout(0, 0));
                    addLeftPanel(window, this);
                    addRightPanel(window, this);
                    addCentralPanel(window, this);
                }
            };
        }
    }

    private void addLeftPanel(@NotNull CommonWindow window, @NotNull DynamicPanel panel) {
        @Nullable AbstractLeftPanel leftPanel = getLeftPanel(window);
        if (leftPanel != null) {
            panel.add(leftPanel, BorderLayout.WEST);
        }
    }

    private void addRightPanel(@NotNull CommonWindow window, @NotNull DynamicPanel panel) {
        @Nullable AbstractRightPanel rightPanel = getRightPanel(window);
        if (rightPanel != null) {
            panel.add(rightPanel, BorderLayout.EAST);
        }
    }

    private void addCentralPanel(@NotNull CommonWindow window, @NotNull DynamicPanel panel) {
        @Nullable DynamicPanel centralPanel = getCentralPanel(window);
        if (centralPanel != null) {
            panel.add(centralPanel, BorderLayout.CENTER);
        }
    }

    //
    public abstract @Nullable AbstractLeftPanel getLeftPanel(@NotNull CommonWindow window);

    //
    public abstract @Nullable AbstractRightPanel getRightPanel(@NotNull CommonWindow window);

    //
    public abstract @Nullable DynamicPanel getCentralPanel(@NotNull CommonWindow window);
}