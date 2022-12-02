package graphics.playPage.leftPanel.sliders.abstraction;

import java.awt.Color;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
abstract class LinearSlider extends SimpleSlider {
    private double tickValue;

    //TODO: add javadoc
    LinearSlider(@NotNull Color backgroundColor,
                 double[] range, double initialValue,
                 int majorTickCount, int minorTickCount) {
        super(
                backgroundColor,
                range, initialValue,
                majorTickCount, minorTickCount);
    }

    //TODO: add javadoc
    @Override
    final void setConversionConstants(int majorTickCount, int minorTickCount) {
        double @NotNull [] range = getRange();
        tickValue = (range[1] - range[0])
                / (majorTickCount * minorTickCount);
    }

    //TODO: add javadoc
    @Override
    final int getTickFromValue(double value) {
        return (int) ((value - getRange()[0]) / tickValue);
    }

    //TODO: add javadoc
    @Override
    final double getValueFromTick(int tick) {
        return getRange()[0] + tick * tickValue;
    }
}