package graphicsEngineExtension.sliders.panelless;

import java.awt.Color;

import org.jetbrains.annotations.NotNull;

/**
 * TODO:
 *      add customizable base
 *      add reversibility
 *      add javadocs
 */
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

    /**
     * Prepares variables for tick-value conversion.
     *
     * @param majorTickCount Number of major ticks. (excludes start; has to be greater than 1)
     * @param minorTickCount Number of minor ticks between major ticks. (has to be greater than 1)
     */
    @Override
    public final void setConversionConstants(int majorTickCount, int minorTickCount) {
        double @NotNull [] range = getRange();
        double tickCount = majorTickCount * minorTickCount;
        base = Math.pow(
                range[1] - range[0] + 1,
                1 / tickCount);
    }

    /**
     * Gets the closest tick to a particular value.
     *
     * @param value Reference value.
     *
     * @return Closest tick number.
     */
    @Override
    public final int getTickFromValue(double value) {
        double @NotNull [] range = getRange();
        double
                dividend = Math.log(value + 1 - range[0]),
                divisor = Math.log(base),
                quotient = dividend / divisor;
        return (int) quotient;
    }

    /**
     * Gets a value corresponding to a tick.
     *
     * @param tick Reference tick number.
     *
     * @return Corresponding value.
     */
    @Override
    public final double getValueFromTick(int tick) {
        return Math.pow(base, tick) - 1 + getRange()[0];
    }
}