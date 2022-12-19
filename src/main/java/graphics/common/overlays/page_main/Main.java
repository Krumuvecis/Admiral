package graphics.common.overlays.page_main;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.panels.StaticPanel;

import graphics.common.CommonWindow;
import graphics.common.overlays.OverlayPage;
import graphics.common.overlays.centering.CentralContainer;

/**
 * TODO: add javadocs
 */
public class Main extends OverlayPage {

    /**
     * TODO: finish this javadoc
     */
    public Main(@NotNull CommonWindow window) {
        super(new ButtonListener(window));
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public final @NotNull StaticPanel getCenter(@Nullable ActionListener actionListener) {
        return new CentralContainer(actionListener) {
            //
            @Override
            public void addComponents(@Nullable ActionListener actionListener) {
                add(new Button_HideOverlay(actionListener));
            }
        };
    }
}