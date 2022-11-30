package graphics.playPage.leftPanel.sliders;

import graphics.playPage.leftPanel.DynamicLabel;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.presets.panels.HorizontalPanel;

import java.awt.Color;
import javax.swing.BoxLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//
abstract class SliderPanel extends HorizontalPanel {
    private static final int DEFAULT_HEIGHT = 100;

    //
    SliderPanel(@Nullable SimpleColorScheme colors,
                int majorTickCount, int minorTickCount,
                int min, int max, int initial) {
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

        int
                majorTickSpacing = getMajorTickSpacing(min, max, majorTickCount),
                minorTickSpacing = getMinorTickSpacing(majorTickSpacing, minorTickCount);

        add(new SimpleSlider(
                background,
                min, max, initial,
                majorTickSpacing, minorTickSpacing) {
            @Override
            void valueChanged(int value) {
                panel.valueChanged(value);
            }
        });
    }

    private int getMajorTickSpacing(int min, int max, int tickCount) {
        int amplitude = max - min;
        return (int) Math.floor((double) amplitude / tickCount);
    }

    private int getMinorTickSpacing(int majorTickSpacing, int minorTickCount) {
        return (int) Math.floor((double) majorTickSpacing / minorTickCount);
    }

    //
    abstract @NotNull String getLabelText();

    //
    abstract void valueChanged(int value);
}