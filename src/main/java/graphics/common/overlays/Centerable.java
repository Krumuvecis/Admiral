package graphics.common.overlays;

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
public interface Centerable {
    /**
     * TODO: finish this javadoc
     */
    static @NotNull JPanel getVerticalOffsetPanel(int minimumOffset) {
        return getOffsetPanel(new Dimension(Integer.MAX_VALUE, minimumOffset));
    }

    /**
     * TODO: finish this javadoc
     */
    static @NotNull JPanel getHorizontalOffsetPanel(int minimumOffset) {
        return getOffsetPanel(new Dimension(minimumOffset, Integer.MAX_VALUE));
    }

    private static @NotNull JPanel getOffsetPanel(@NotNull Dimension preferredSize) {
        @NotNull Color transparentColor = ColorUtilities.defaultColorByOpacity(false);
        return new JPanel() {{
            setBackground(transparentColor);
            setPreferredSize(preferredSize);
        }};
    }

    /**
     * TODO: finish this javadoc
     */
    @NotNull StaticPanel getCenter(@Nullable ActionListener actionListener);
}