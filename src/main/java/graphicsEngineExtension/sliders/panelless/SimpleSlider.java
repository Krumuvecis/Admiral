package graphicsEngineExtension.sliders.panelless;

import java.util.Arrays;
import java.awt.Color;
import javax.swing.JSlider;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
abstract class SimpleSlider extends JSlider {
    private final double @NotNull [] range; //Range of the slider {min, max}

    //TODO: add javadoc
    protected SimpleSlider(@NotNull Color backgroundColor,
                           double @NotNull [] range) {
        super();
        setFocusable(false);
        setBackground(backgroundColor); //prevents flickering
        this.range = Arrays.copyOf(range, 2);
    }

    /**
     * Gets the value range of this slider.
     *
     * @return Range as double[] {min, max}.
     */
    protected final double @NotNull [] getRange() {
        return range;
    }
}