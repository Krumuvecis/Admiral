package graphics.common.overlays.centering;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.ColorUtilities;

/**
 * TODO: finish this javadoc
 */
interface Centerable {
    //TODO: add javadoc
    static @NotNull JPanel getOffsetPanel() {
        @NotNull Color transparentColor = ColorUtilities.defaultColorByOpacity(false);
        return new JPanel() {{
            setBackground(transparentColor);
            setPreferredSize(new Dimension(1, 1));
        }};
    }

    /**
     * TODO: finish this javadoc
     */
    @NotNull CentralContainer getCenter(@Nullable ActionListener actionListener);
}