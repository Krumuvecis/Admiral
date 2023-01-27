package graphics.common.pages;

import java.util.List;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.pages.FullyPaneledPage;
import graphicsEngine.pages.panels.PanelLocation;
import graphicsEngine.panels.SimplePanel;

import graphics.common.CommonWindow;
import graphics.common.StaticColors;

/**
 * TODO: finish this and add javadocs
 */
public abstract class SimplePaneledPage extends FullyPaneledPage {
    private final @Nullable CommonWindow window;

    /**
     * TODO: finish this javadoc
     */
    public SimplePaneledPage(@Nullable CommonWindow window,
                             @Nullable List<@Nullable ActionListener> actionListenerList) {
        super(actionListenerList, StaticColors.PAGE_BACKGROUND_COLOR);
        this.window = window;

        if (window != null) {
            initializePanels(
                    StaticColors.PAGE_HEADER_AND_FOOTER_COLORS,
                    StaticColors.PAGE_SIDE_PANEL_COLORS,
                    null);
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

    public void togglePanelVisibilityByPanelLocation(@NotNull PanelLocation panelLocation) {
        @Nullable SimplePanel panel = getPanelByLocation(panelLocation);
        if (panel != null) {
            boolean currentVisibilityStatus = panel.isVisible();
            panel.setVisible(!currentVisibilityStatus);
        }
    }
}