package graphics.common.overlays;

import java.awt.Color;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;

import graphics.common.overlays.centering.CenteringPanel;

//
public abstract class OverlayPage extends CenteringPanel {
    private static final double DEFAULT_TRANSPARENCY = 0.5;
    private static final Color BACKGROUND_COLOR = new Color(
            0, 0, 0,
            (int) (255 * DEFAULT_TRANSPARENCY));

    //
    public OverlayPage(@Nullable ActionListener actionListener) {
        super(getColors(), actionListener);
    }

    private static @NotNull SimpleColorScheme getColors() {
        return new SimpleColorScheme(
                BACKGROUND_COLOR,
                null);
    }
}