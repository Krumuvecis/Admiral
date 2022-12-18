package graphicsEngineExtension.sliders.panelless;

import java.util.Arrays;
import java.awt.Color;
import javax.swing.JSlider;

import org.jetbrains.annotations.NotNull;

/**
 * A simple slider with the most basic swing settings and a range.
 */
abstract class SimpleSlider extends JSlider {
    private final double @NotNull [] range; //Range of the slider {min, max}

    /**
     * Creates a new SimpleSlider.
     *
     * @param backgroundColor Background color. (prevents flickering)
     * @param range           Value range. {min, max}
     */
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

    /**
     * Ensures that the provided value is within the value range.
     * TODO: add reversibility support
     *
     * @param value Value to check.
     *
     * @return Value within range.
     */
    protected final double getValueInRange(double value) {
        double @NotNull [] range = getRange();
        return Math.max(range[0], Math.min(range[1], value));
    }
}