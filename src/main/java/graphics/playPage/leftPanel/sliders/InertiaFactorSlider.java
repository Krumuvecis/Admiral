package graphics.playPage.leftPanel.sliders;

import staticData.StaticData;

import graphicsEngine.colors.SimpleColorScheme;

import consoleUtils.NumberFormatter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadocs
public class InertiaFactorSlider extends SliderPanel {
    private static final int
            MAJOR_TICK_COUNT = 3,
            MINOR_TICK_COUNT = 3;

    //TODO: add javadoc
    public InertiaFactorSlider(@Nullable SimpleColorScheme colors) {
        super(
                colors,
                StaticData.cells.barokineticSettings.getInertiaFactorRange(),
                StaticData.cells.barokineticSettings.getInertiaFactor(),
                MAJOR_TICK_COUNT, MINOR_TICK_COUNT);
    }

    /**
     * TODO: finish this javadoc
     * @return
     */
    @Override
    @NotNull String getLabelText() {
        return "Inertia factor: "
                + NumberFormatter.doubleToString(
                        StaticData.cells.barokineticSettings.getInertiaFactor(),
                        2);
    }

    /**
     * TODO: finish this javadoc
     * @param value
     */
    @Override
    void valueChanged(double value) {
        StaticData.cells.barokineticSettings.setInertiaFactor(value);
    }
}