package graphicsEngineExtension.sliders.panelless;

import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jetbrains.annotations.NotNull;

/**
 * A ticked slider with a change listener supporting dynamic tick value-conversion.
 */
abstract class PanellessSlider extends TickedSlider {
    /**
     * Creates a new panelless slider.
     *
     * @param backgroundColor        Background color. (prevents flickering)
     * @param range                  Value range. {min, max}
     * @param initialValue           Preferred initial value. (will change to the nearest corresponding tick)
     * @param majorTickCount         Number of major ticks. (excludes start; has to be greater than 1)
     * @param minorTickCount         Number of minor ticks between major ticks. (has to be greater than 1)
     * @param tickLabelDecimalPlaces Number of decimal places for tick labels.
     */
    protected PanellessSlider(@NotNull Color backgroundColor,
                              double @NotNull [] range, double initialValue,
                              int majorTickCount, int minorTickCount,
                              int tickLabelDecimalPlaces) {
        super(
                backgroundColor,
                range,
                majorTickCount, minorTickCount,
                tickLabelDecimalPlaces);
        setInitialValue(initialValue);
        addChangeListener(newChangeListener());
    }

    private void setInitialValue(double value) {
        double valueInRange = getValueInRange(value); // ensures that the value is within range
        int tick = getTickFromValue(valueInRange); // gets the nearest tick
        setValue(tick); // sets the initial tick
        valueChanged(getValueFromTick(tick)); // sets the actual value to the value of the corresponding tick
    }

    private @NotNull ChangeListener newChangeListener() {
        return new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e A ChangeEvent object.
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                valueChanged(getValueFromTick(source.getValue()));
            }
        };
    }
}