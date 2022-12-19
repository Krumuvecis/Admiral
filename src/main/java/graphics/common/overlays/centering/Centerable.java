package graphics.common.overlays.centering;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.panels.StaticPanel;

/**
 * TODO: finish this javadoc
 */
interface Centerable {
    //
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
    @NotNull StaticPanel getCenter(@Nullable ActionListener actionListener);
}