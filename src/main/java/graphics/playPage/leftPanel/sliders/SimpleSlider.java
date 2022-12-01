package graphics.playPage.leftPanel.sliders;

import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
abstract class SimpleSlider extends JSlider {
    private static final boolean DEFAULT_TICK_SNAP = false;

    //TODO: add javadoc
    SimpleSlider(@NotNull Color backgroundColor,
                 int min, int max, int initial,
                 int majorTickSpacing, int minorTickSpacing) {
        super(min, max, initial);
        setFocusable(false);
        setBackground(backgroundColor); //prevents flickering

        setSnapToTicks(DEFAULT_TICK_SNAP);
        setMajorTickSpacing(majorTickSpacing);
        setMinorTickSpacing(minorTickSpacing);

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
                if (!source.getSnapToTicks() || !source.getValueIsAdjusting()) {
                    valueChanged(source.getValue());
                }
            }
        });
    }

    //TODO: add javadoc
    abstract void valueChanged(int value);
}