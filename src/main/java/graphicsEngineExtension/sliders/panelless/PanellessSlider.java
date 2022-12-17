package graphicsEngineExtension.sliders.panelless;

import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
abstract class PanellessSlider extends TickedSlider {

    //TODO: add javadoc
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
        int tick = getTickFromValue(value); // gets the nearest tick
        setValue(tick);
        valueChanged(getValueFromTick(tick)); // sets the actual value to the value of the corresponding tick
    }

    private @NotNull ChangeListener newChangeListener() {
        return new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                valueChanged(getValueFromTick(source.getValue()));
            }
        };
    }
}