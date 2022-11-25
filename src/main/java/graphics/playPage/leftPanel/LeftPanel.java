package graphics.playPage.leftPanel;

import graphics.Window;
import graphics.playPage.observer.Observer;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.parts.SimpleLabel;
import graphicsEngine.presets.panels.VerticalPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LeftPanel extends VerticalPanel {
    private static final int PANEL_WIDTH = 150;
    private static final int BACKGROUND_BRIGHTNESS = 80;
    private static final @Nullable Color
            BACKGROUND_COLOR = new Color(
                    BACKGROUND_BRIGHTNESS,
                    BACKGROUND_BRIGHTNESS,
                    BACKGROUND_BRIGHTNESS),
            TEXT_COLOR = null; // default - white

    public LeftPanel(@NotNull Window window,
                     @NotNull Observer observer) {
        super(
                new SimpleColorScheme(BACKGROUND_COLOR, TEXT_COLOR),
                PANEL_WIDTH,
                null);
        setLayout(new BorderLayout(0, 0));
        add(new SimpleLabel(
                        "Play page",
                        getPanelColors().getSecondaryColor()),
                BorderLayout.NORTH);
        add(new LeftDrawPanel(window, observer));
    }
}