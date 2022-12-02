package graphics.playPage.leftPanel.sliders.abstraction;

import java.awt.Color;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
abstract class ExponentialSlider extends SimpleSlider {
    private double base;

    //TODO: add javadoc
    ExponentialSlider(@NotNull Color backgroundColor,
                 double[] bounds, double initialValue,
                 int majorTickCount, int minorTickCount) {
        super(
                backgroundColor,
                bounds, initialValue,
                majorTickCount, minorTickCount);
    }

    //TODO: add javadoc
    @Override
    final void setConversionConstants(int majorTickCount, int minorTickCount) {
        double @NotNull [] range = getRange();
        double tickCount = majorTickCount * minorTickCount;
        base = Math.pow(
                range[1] - range[0] + 1,
                1 / tickCount);
    }

    //TODO: add javadoc
    @Override
    final int getTickFromValue(double value) {
        double @NotNull [] range = getRange();
        double
                dividend = Math.log(value + 1 - range[0]),
                divisor = Math.log(base),
                quotient = dividend / divisor;
        return (int) quotient;
    }

    //TODO: add javadoc
    @Override
    final double getValueFromTick(int tick) {
        return Math.pow(base, tick) - 1 + getRange()[0];
    }
}