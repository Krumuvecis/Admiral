package graphics.playPage.leftPanel.sliders;

import java.util.Hashtable;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import consoleUtils.NumberFormatter;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
abstract class SimpleSlider extends JSlider {
    private double tickValue;

    //new model; TODO: finish this and add javadoc
    SimpleSlider(@NotNull Color backgroundColor,
                 double[] bounds, double initialValue,
                 int majorTickCount, int minorTickCount) {
        super();
        setFocusable(false);
        setBackground(backgroundColor); //prevents flickering

        setTicksAndLabels(bounds, majorTickCount, minorTickCount);

        setInitialValue(bounds[0], initialValue);

        addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                valueChanged(bounds[0] + source.getValue() * getTickValue());
            }
        });
    }

    private void setTicksAndLabels(double @NotNull [] bounds,
                                   int majorTickCount, int minorTickCount) {
        setMinorTickSpacing(1);
        setMajorTickSpacing(minorTickCount);
        int totalTicks = majorTickCount * minorTickCount;
        setMaximum(totalTicks);
        double range = Math.abs(bounds[1] - bounds[0]);
        setTickValue(range / totalTicks);

        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        for (int i = 0; i <= majorTickCount; i++) {
            int tickPosition = i * minorTickCount;
            labelTable.put(
                    tickPosition,
                    new JLabel(NumberFormatter.doubleToString(
                            bounds[0] + tickPosition * getTickValue(),
                            2)));
        }
        setLabelTable(labelTable);

        setPaintTicks(true);
        setPaintLabels(true);
    }

    private void setTickValue(double value) {
        tickValue = value;
    }

    private double getTickValue() {
        return tickValue;
    }

    private void setInitialValue(double lowerBound, double value) {
        setValue((int) ((value - lowerBound) / getTickValue()));
        valueChanged(lowerBound + getValue() * getTickValue());
    }

    //TODO: add javadoc
    abstract void valueChanged(double value);
}