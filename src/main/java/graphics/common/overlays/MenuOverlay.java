package graphics.common.overlays;

import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.panels.StaticPanel;

/**
 * TODO: add javadocs
 */
public class MenuOverlay extends CenteringOverlay {
    /**
     * TODO: finish this javadoc
     */
    public MenuOverlay(@Nullable ActionListener actionListener) {
        super(actionListener);
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public @NotNull StaticPanel getCenter(@Nullable ActionListener actionListener) {
        return new ButtonContainer(actionListener);
    }
}