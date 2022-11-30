package graphics.playPage.leftPanel;

import staticData.StaticData;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.parts.SimpleLabel;
import graphicsEngine.presets.panels.HorizontalPanel;

import java.awt.*;
import javax.swing.*;

import consoleUtils.NumberFormatter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//
class LabelSection extends HorizontalPanel {
    private static final int HEIGHT = 100;

    //
    LabelSection(@Nullable SimpleColorScheme colors) {
        super(colors, HEIGHT, null);

        // Prevents left-side alignment flickering; TODO: needs better solution
        setMinimumSize(new Dimension(Integer.MAX_VALUE, HEIGHT));

        @NotNull Color
                textColor = getPanelColors().getSecondaryColor(),
                background = getPanelColors().getBaseColor();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new SimpleLabel(
                "Play page",
                textColor));
        add(new DynamicLabel(textColor, background) {
            @Override
            public @NotNull String getLabelText() {
                return "Total pressure: "
                        + NumberFormatter.doubleToString(
                                StaticData.cells.getTotalPressure(),
                                3);
            }
        });
        // add more labels here
    }

    //
}