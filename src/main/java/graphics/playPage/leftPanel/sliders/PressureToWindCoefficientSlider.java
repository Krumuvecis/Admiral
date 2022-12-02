package graphics.playPage.leftPanel.sliders;

import staticData.StaticData;

import graphics.playPage.leftPanel.sliders.abstraction.ExponentialSliderPanel;

import graphicsEngine.colors.SimpleColorScheme;

import consoleUtils.NumberFormatter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadocs
public class PressureToWindCoefficientSlider extends ExponentialSliderPanel {
    private static final int
            MAJOR_TICK_COUNT = 5,
            MINOR_TICK_COUNT = 1;

    //TODO: add javadoc
    public PressureToWindCoefficientSlider(@Nullable SimpleColorScheme colors) {
        super(
                colors,
                StaticData.cells.barokineticSettings.getPressureToWindCoefficientSlideability().getRange(),
                StaticData.cells.barokineticSettings.getPressureToWindCoefficient(),
                MAJOR_TICK_COUNT, MINOR_TICK_COUNT);
    }

    /**
     * TODO: finish this javadoc
     * @return
     */
    @Override
    public @NotNull String getLabelText() {
        return "P-W coefficient: "
                + NumberFormatter.doubleToString(
                        StaticData.cells.barokineticSettings.getPressureToWindCoefficient(),
                        2);
    }

    /**
     * Performed upon changing the value.
     *
     * @param value The new value.
     */
    @Override
    public void valueChanged(double value) {
        StaticData.cells.barokineticSettings.setPressureToWindCoefficient(value);
    }
}