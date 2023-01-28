package graphics.common;

import java.awt.Color;

import org.jetbrains.annotations.NotNull;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.colors.SimpleColorScheme;

//TODO: add javadocs
public class StaticColors {
    public static final @NotNull Color PAGE_BACKGROUND_COLOR = ColorUtilities.defaultColorByOpacity(true); //black
    private static final int
            HEADER_AND_FOOTER_BACKGROUND_LIGHTNESS_VALUE = 50,
            SIDE_PANEL_BACKGROUND_LIGHTNESS_VALUE = 80;
    public static final @NotNull SimpleColorScheme
            PAGE_HEADER_AND_FOOTER_COLORS = new SimpleColorScheme(
                    getGray(HEADER_AND_FOOTER_BACKGROUND_LIGHTNESS_VALUE),
                    null),
            PAGE_SIDE_PANEL_COLORS = new SimpleColorScheme(
                    getGray(SIDE_PANEL_BACKGROUND_LIGHTNESS_VALUE),
                    null);

    private static @NotNull Color getGray(int lightness) throws IllegalArgumentException {
        if (lightness < 0 || lightness > 255) throw new IllegalArgumentException();
        return new Color(lightness, lightness, lightness);
    }
}