package graphics.playPage.leftPanel.sliders;

import staticData.StaticData;

import graphicsEngine.colors.SimpleColorScheme;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//
public class InertiaFactorSlider extends SliderPanel {
    private static final int
            MAJOR_TICK_COUNT = 3,
            MINOR_TICK_COUNT = 1;

    //
    public InertiaFactorSlider(@Nullable SimpleColorScheme colors) {
        super(
                colors,
                MAJOR_TICK_COUNT, MINOR_TICK_COUNT,
                (int)StaticData.cells.barokineticSettings.getInertiaFactorRange()[0],
                (int)StaticData.cells.barokineticSettings.getInertiaFactorRange()[1],
                (int)StaticData.cells.barokineticSettings.getInertiaFactor());
    }

    /**
     * TODO: finish this javadoc
     * @return
     */
    @Override
    @NotNull String getLabelText() {
        return "Inertia factor: "
                + (int)StaticData.cells.barokineticSettings.getInertiaFactor();
    }

    /**
     * TODO: finish this javadoc
     * @param value
     */
    @Override
    void valueChanged(int value) {
        StaticData.cells.barokineticSettings.setInertiaFactor(value);
    }
}