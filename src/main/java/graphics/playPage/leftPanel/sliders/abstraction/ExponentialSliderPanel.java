package graphics.playPage.leftPanel.sliders.abstraction;

import graphicsEngine.colors.SimpleColorScheme;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ExponentialSliderPanel extends SliderPanel {
    public ExponentialSliderPanel(@Nullable SimpleColorScheme colors,
                                  double @NotNull [] range, double initialValue,
                                  int majorTickCount, int minorTickCount) {
        super(colors);
        @NotNull SliderPanel panel = this;
        add(new ExponentialSlider(
                getPanelColors().getBaseColor(),
                range, initialValue,
                majorTickCount, minorTickCount) {
            /**
             * Performed upon changing the value.
             *
             * @param value The new value.
             */
            @Override
            void valueChanged(double value) {
                panel.valueChanged(value);
            }
        });
    }
}