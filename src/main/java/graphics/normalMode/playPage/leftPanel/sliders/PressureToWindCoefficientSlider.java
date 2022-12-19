package graphics.normalMode.playPage.leftPanel.sliders;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import consoleUtils.NumberFormatter;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.parts.sliders.ExponentialSlider;

import staticData.StaticData;

//TODO: add javadocs
class PressureToWindCoefficientSlider extends ExponentialSlider {
    private static final int
            MAJOR_TICK_COUNT = 5,
            MINOR_TICK_COUNT = 3;

    //TODO: add javadoc
    protected PressureToWindCoefficientSlider(@Nullable SimpleColorScheme colors) {
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