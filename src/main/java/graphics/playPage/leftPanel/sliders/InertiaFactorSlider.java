package graphics.playPage.leftPanel.sliders;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import consoleUtils.NumberFormatter;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.parts.sliders.LinearSlider;

import staticData.StaticData;

//TODO: add javadocs
class InertiaFactorSlider extends LinearSlider {
    private static final int
            MAJOR_TICK_COUNT = 3,
            MINOR_TICK_COUNT = 3;

    //TODO: add javadoc
    protected InertiaFactorSlider(@Nullable SimpleColorScheme colors) {
        super(
                colors,
                StaticData.cells.barokineticSettings.getInertiaFactorSlideability().getRange(),
                StaticData.cells.barokineticSettings.getInertiaFactor(),
                MAJOR_TICK_COUNT, MINOR_TICK_COUNT);
    }

    /**
     * TODO: finish this javadoc
     * @return
     */
    @Override
    public @NotNull String getLabelText() {
        return "Inertia factor: "
                + NumberFormatter.doubleToString(
                        StaticData.cells.barokineticSettings.getInertiaFactor(),
                        2);
    }

    /**
     * Performed upon changing the value.
     *
     * @param value The new value.
     */
    @Override
    public void valueChanged(double value) {
        StaticData.cells.barokineticSettings.setInertiaFactor(value);
    }
}