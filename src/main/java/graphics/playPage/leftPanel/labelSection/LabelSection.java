package graphics.playPage.leftPanel.labelSection;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.BoxLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import consoleUtils.NumberFormatter;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.parts.labels.*;
import graphicsEngine.presets.panels.HorizontalPanel;

import staticData.StaticData;

//TODO: add javadocs
public class LabelSection extends HorizontalPanel {
    private static final int HEIGHT = 100;

    //TODO: add javadoc
    public LabelSection(@Nullable SimpleColorScheme colors) {
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
            //TODO: add javadoc
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
}