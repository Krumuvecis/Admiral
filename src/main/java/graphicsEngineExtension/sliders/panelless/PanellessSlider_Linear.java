package graphicsEngineExtension.sliders.panelless;

import java.awt.Color;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public abstract class PanellessSlider_Linear extends PanellessSlider {
    private double tickValue; //Value of a tick for tick-value conversion.

    //TODO: add javadoc
    public PanellessSlider_Linear(@NotNull Color backgroundColor,
                                  double[] range, double initialValue,
                                  int majorTickCount, int minorTickCount,
                                  int tickLabelDecimalPlaces) {
        super(
                backgroundColor,
                range, initialValue,
                majorTickCount, minorTickCount,
                tickLabelDecimalPlaces);
    }

    //TODO: add javadoc
    @Override
    public final void setConversionConstants(int majorTickCount, int minorTickCount) {
        double @NotNull [] range = getRange();
        tickValue = (range[1] - range[0])
                / (majorTickCount * minorTickCount);
    }

    //TODO: add javadoc
    @Override
    public final int getTickFromValue(double value) {
        return (int) ((value - getRange()[0]) / tickValue);
    }

    //TODO: add javadoc
    @Override
    public final double getValueFromTick(int tick) {
        return getRange()[0] + tick * tickValue;
    }
}