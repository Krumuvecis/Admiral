package graphics.playPage.leftPanel.sliders.abstraction;

import java.util.Arrays;
import java.util.Hashtable;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jetbrains.annotations.NotNull;

import consoleUtils.NumberFormatter;

//TODO: add javadocs
abstract class SimpleSlider extends JSlider {
    private final double @NotNull [] range;

    //TODO: add javadoc
    SimpleSlider(@NotNull Color backgroundColor,
                 double @NotNull [] range, double initialValue,
                 int majorTickCount, int minorTickCount) {
        super();
        setFocusable(false);
        setBackground(backgroundColor); //prevents flickering
        this.range = Arrays.copyOf(range, 2);

        setConversionConstants(majorTickCount, minorTickCount);

        setTicks(majorTickCount, minorTickCount);
        setLabels(majorTickCount, minorTickCount, 2);

        setInitialValue(initialValue);

        addChangeListener(new ChangeListener() {
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
        });
    }

    /**
     * prepares variables for tick-value conversion
     * TODO: finish this; rename and add javadoc
     *
     * @param majorTickCount
     * @param minorTickCount
     */
    abstract void setConversionConstants(int majorTickCount, int minorTickCount);

    private void setTicks(int majorTickCount, int minorTickCount) {
        setMinorTickSpacing(1);
        setMajorTickSpacing(minorTickCount);
        int totalTicks = majorTickCount * minorTickCount;
        setMaximum(totalTicks);
        setPaintTicks(true);
    }

    private void setLabels(int majorTickCount, int minorTickCount,
                           int labelDecimalPlaces) {
        @NotNull Hashtable<@NotNull Integer, @NotNull JLabel> labelTable = new Hashtable<>();
        for (int i = 0; i <= majorTickCount; i++) {
            int tickPosition = i * minorTickCount;
            labelTable.put(
                    tickPosition,
                    new JLabel(NumberFormatter.doubleToString(
                            getValueFromTick(tickPosition),
                            labelDecimalPlaces)));
        }
        setLabelTable(labelTable);
        setPaintLabels(true);
    }

    /**
     * Gets the value range of this slider.
     *
     * @return Range as double[] {min, max}.
     */
    final double @NotNull [] getRange() {
        return range;
    }

    private void setInitialValue(double value) {
        int tick = getTickFromValue(value); // gets the nearest tick
        setValue(tick);
        valueChanged(getValueFromTick(tick)); // sets the actual value to the value of the corresponding tick
    }

    //TODO: add javadoc
    abstract int getTickFromValue(double value);

    //TODO: add javadoc
    abstract double getValueFromTick(int tick);

    /**
     * Performed upon changing the value.
     *
     * @param value The new value.
     */
    abstract void valueChanged(double value);
}