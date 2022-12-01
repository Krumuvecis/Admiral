package graphics.playPage.leftPanel.sliders;

import graphics.playPage.leftPanel.DynamicLabel;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.presets.panels.HorizontalPanel;

import java.awt.Color;
import javax.swing.BoxLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadocs
abstract class SliderPanel extends HorizontalPanel {
    private static final int DEFAULT_HEIGHT = 100;

    //TODO: add javadoc
    SliderPanel(@Nullable SimpleColorScheme colors,
                double @NotNull [] bounds, double initialValue,
                int majorTickCount, int minorTickCount) {
        super(colors, DEFAULT_HEIGHT, null);
        @NotNull Color background = getPanelColors().getBaseColor();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        @NotNull SliderPanel panel = this;
        add(new DynamicLabel(getPanelColors().getSecondaryColor(), background) {
            @Override
            public @NotNull String getLabelText() {
                return panel.getLabelText();
            }
        });

        add(new SimpleSlider(
                background,
                bounds, initialValue,
                majorTickCount, minorTickCount) {
            @Override
            void valueChanged(double value) {
                panel.valueChanged(value);
            }
        });
    }

    //TODO: add javadoc
    abstract @NotNull String getLabelText();

    //TODO: add javadoc
    abstract void valueChanged(double value);
}