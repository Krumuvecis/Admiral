package graphicsEngineExtension.sliders.panelless;

import java.awt.Color;

import org.jetbrains.annotations.NotNull;

//TODO: inherit this from exponential slider with base 1; add javadocs
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

    /**
     * Prepares variables for tick-value conversion.
     *
     * @param majorTickCount Number of major ticks. (excludes start; has to be greater than 1)
     * @param minorTickCount Number of minor ticks between major ticks. (has to be greater than 1)
     */
    @Override
    public final void setConversionConstants(int majorTickCount, int minorTickCount) {
        double @NotNull [] range = getRange();
        tickValue = (range[1] - range[0])
                / (majorTickCount * minorTickCount);
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
        return (int) ((value - getRange()[0]) / tickValue);
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
        return getRange()[0] + tick * tickValue;
    }
}