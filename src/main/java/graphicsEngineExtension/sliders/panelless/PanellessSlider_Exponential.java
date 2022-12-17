package graphicsEngineExtension.sliders.panelless;

import java.awt.Color;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public abstract class PanellessSlider_Exponential extends PanellessSlider {
    private double base; //Base of exponent for tick-value conversion.

    //TODO: add javadoc
    public PanellessSlider_Exponential(@NotNull Color backgroundColor,
                                       double[] bounds, double initialValue,
                                       int majorTickCount, int minorTickCount,
                                       int tickLabelDecimalPlaces) {
        super(
                backgroundColor,
                bounds, initialValue,
                majorTickCount, minorTickCount,
                tickLabelDecimalPlaces);
    }

    //TODO: add javadoc
    @Override
    public final void setConversionConstants(int majorTickCount, int minorTickCount) {
        double @NotNull [] range = getRange();
        double tickCount = majorTickCount * minorTickCount;
        base = Math.pow(
                range[1] - range[0] + 1,
                1 / tickCount);
    }

    //TODO: add javadoc
    @Override
    public final int getTickFromValue(double value) {
        double @NotNull [] range = getRange();
        double
                dividend = Math.log(value + 1 - range[0]),
                divisor = Math.log(base),
                quotient = dividend / divisor;
        return (int) quotient;
    }

    //TODO: add javadoc
    @Override
    public final double getValueFromTick(int tick) {
        return Math.pow(base, tick) - 1 + getRange()[0];
    }
}