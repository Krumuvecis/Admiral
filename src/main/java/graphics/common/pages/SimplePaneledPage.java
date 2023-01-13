package graphics.common.pages;

import java.util.List;
import java.awt.Color;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.pages.FullyPaneledPage;

import graphics.common.CommonWindow;

/**
 * TODO: finish this and add javadocs
 */
public abstract class SimplePaneledPage extends FullyPaneledPage {
    private static final @NotNull Color COMMON_BACKGROUND_COLOR = ColorUtilities.defaultColorByOpacity(true);
    private static final int HEADER_AND_FOOTER_BACKGROUND_VALUE = 50, SIDE_PANEL_BACKGROUND_VALUE = 100;
    private static final @NotNull SimpleColorScheme
            COMMON_HEADER_AND_FOOTER_COLORS = new SimpleColorScheme(
                    new Color(
                            HEADER_AND_FOOTER_BACKGROUND_VALUE,
                            HEADER_AND_FOOTER_BACKGROUND_VALUE,
                            HEADER_AND_FOOTER_BACKGROUND_VALUE
                    ),
                    null),
            COMMON_SIDE_PANEL_COLORS = new SimpleColorScheme(
                    new Color(
                            SIDE_PANEL_BACKGROUND_VALUE,
                            SIDE_PANEL_BACKGROUND_VALUE,
                            SIDE_PANEL_BACKGROUND_VALUE
                    ),
                    null);

    private final @Nullable CommonWindow window;

    /**
     * TODO: finish this javadoc
     */
    public SimplePaneledPage(@Nullable CommonWindow window,
                             @Nullable List<@Nullable ActionListener> actionListenerList) {
        super(actionListenerList, COMMON_BACKGROUND_COLOR);
        this.window = window;

        if (window != null) {
            initializePanels(COMMON_HEADER_AND_FOOTER_COLORS, COMMON_SIDE_PANEL_COLORS, null);
        }
    }

    //TODO: add javadoc
    public final @Nullable CommonWindow getCommonWindow() {
        return window;
    }

    /**
     * Adds known listeners to this page.
     * Override this to add custom listeners.
     *
     * @param list List of listeners to add.
     *
     * @return Remaining unknown listeners.
     */
    @Override
    public final @NotNull List<ActionListener> addListeners(@Nullable List<ActionListener> list) {
        @NotNull List<ActionListener> remainder = super.addListeners(list);
        for (int i = 0; i < remainder.size(); i++) {
            ActionListener listener = remainder.get(i);
            if (addParticularListener(listener)) {
                remainder.remove(i);
                i--;
            }
        }
        return remainder;
    }

    //TODO: add javadoc
    public abstract boolean addParticularListener(@Nullable ActionListener listener);

    /*
    private boolean leftPanelVisibility = true;

    public void toggleLeftPanelVisibility() {
        leftPanelVisibility = !leftPanelVisibility;
        if (leftPanel != null) {
            leftPanel.setVisible(leftPanelVisibility);
        }
    }
    */
}