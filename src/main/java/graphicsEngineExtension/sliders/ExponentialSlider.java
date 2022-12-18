package graphicsEngineExtension.sliders;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;

import graphicsEngineExtension.sliders.panelless.PanellessSlider_Exponential;

//TODO: add javadocs
public abstract class ExponentialSlider extends PaneledSlider {

    //TODO: add javadoc
    public ExponentialSlider(@Nullable SimpleColorScheme colors,
                             double @NotNull [] range, double initialValue,
                             int majorTickCount, int minorTickCount) {
        this(
                colors, SliderConstants.DEFAULT_PANEL_HEIGHT,
                range, initialValue,
                majorTickCount, minorTickCount,
                SliderConstants.DEFAULT_TICK_LABEL_DECIMAL_PLACES);
    }

    //TODO: add javadoc
    public ExponentialSlider(@Nullable SimpleColorScheme colors, int panelHeight,
                             double @NotNull [] range, double initialValue,
                             int majorTickCount, int minorTickCount,
                             int tickLabelDecimalPlaces) {
        super(colors, panelHeight);
        @NotNull PaneledSlider panel = this;
        add(new PanellessSlider_Exponential(
                getPanelColors().getBaseColor(),
                range, initialValue,
                majorTickCount, minorTickCount,
                tickLabelDecimalPlaces) {
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