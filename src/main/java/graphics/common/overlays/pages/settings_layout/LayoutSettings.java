package graphics.common.overlays.pages.settings_layout;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphics.common.CommonWindow;
import graphics.common.overlays.OverlayPage;
import graphics.common.overlays.centering.CentralContainer;
import graphics.common.overlays.pages.common.Button_Back;

/**
 * TODO: add javadocs
 */
public class LayoutSettings extends OverlayPage {

    /**
     * TODO: finish this javadoc
     */
    public LayoutSettings(@NotNull CommonWindow window) {
        super(new ButtonListener(window));
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public final @NotNull CentralContainer getCenter(@Nullable ActionListener actionListener) {
        return new CentralContainer(actionListener) {
            //TODO: add javadoc
            @Override
            public void addComponents(@Nullable ActionListener actionListener) {
                //TODO: add buttons here
                add(new Button_Back(actionListener));
            }
        };
    }
}