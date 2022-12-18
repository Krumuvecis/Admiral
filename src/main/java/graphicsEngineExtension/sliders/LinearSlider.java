package graphicsEngineExtension.sliders;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;

import graphicsEngineExtension.sliders.panelless.PanellessSlider_Linear;

//TODO: add javadocs
public abstract class LinearSlider extends SliderPanel {

    //TODO: add javadoc
    public LinearSlider(@Nullable SimpleColorScheme colors,
                        double @NotNull [] range, double initialValue,
                        int majorTickCount, int minorTickCount) {
        this(
                colors, SliderConstants.DEFAULT_PANEL_HEIGHT,
                range, initialValue,
                majorTickCount, minorTickCount,
                SliderConstants.DEFAULT_TICK_LABEL_DECIMAL_PLACES);
    }

    //TODO: add javadoc
    public LinearSlider(@Nullable SimpleColorScheme colors, int panelHeight,
                        double @NotNull [] range, double initialValue,
                        int majorTickCount, int minorTickCount,
                        int tickLabelDecimalPlaces) {
        super(colors, panelHeight);
        @NotNull SliderPanel panel = this;
        add(new PanellessSlider_Linear(
                getPanelColors().getBaseColor(),
                range, initialValue,
                majorTickCount, minorTickCount, tickLabelDecimalPlaces) {
            /**
             * Performed upon changing the value.
             *
             * @param value The new value.
             */
            @Override
            public void valueChanged(double value) {
                panel.valueChanged(value);
            }
        });
    }
}