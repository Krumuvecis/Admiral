package graphics.playPage.leftPanel.sliders;

import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jetbrains.annotations.NotNull;

//
abstract class SimpleSlider extends JSlider {

    //
    SimpleSlider(@NotNull Color backgroundColor,
                 int min, int max, int initial,
                 int minorTickSpacing, int majorTickSpacing) {
        super(min, max, initial);
        setFocusable(false);
        setBackground(backgroundColor); //prevents flickering
        setMinorTickSpacing(minorTickSpacing);
        setSnapToTicks(true);
        setMajorTickSpacing(majorTickSpacing);

        setPaintTicks(true);
        setPaintLabels(true);

        addChangeListener(new ChangeListener() {
            /**
             * Invoked when the target of the listener has changed its state.
             *
             * @param e a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    valueChanged(source.getValue());
                }
            }
        });
    }

    //
    abstract void valueChanged(int value);
}