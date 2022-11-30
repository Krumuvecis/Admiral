package graphics.playPage.leftPanel.sliders;

import staticData.StaticData;

import graphicsEngine.colors.SimpleColorScheme;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//
public class Slider1 extends SliderPanel {
    //
    public Slider1(@Nullable SimpleColorScheme colors) {
        super(
                colors,
                4, 2,
                1, 25, 10);
    }

    /**
     * TODO: finish this javadoc
     * @return
     */
    @Override
    @NotNull String getLabelText() {
        return "Slider 1: " + StaticData.sliderTestValue;
    }

    /**
     * TODO: finish this javadoc
     * @param value
     */
    @Override
    void valueChanged(int value) {
        StaticData.sliderTestValue = value;
    }
}