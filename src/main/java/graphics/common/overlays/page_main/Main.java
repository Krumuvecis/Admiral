package graphics.common.overlays.page_main;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.panels.StaticPanel;

import graphics.common.CommonWindow;
import graphics.common.overlays.CenteringPanel;
import graphics.common.overlays.ButtonContainer;

/**
 * TODO: add javadocs
 */
public class Main extends CenteringPanel {

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
        return new ButtonContainer(actionListener) {
            //
            @Override
            public void addButtons(@Nullable ActionListener actionListener) {
                add(new Button_HideOverlay(actionListener));
            }
        };
    }
}