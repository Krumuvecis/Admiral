package graphics.playPage.leftPanel.sliders;

import staticData.StaticData;

import graphics.playPage.leftPanel.DynamicLabel;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.presets.panels.HorizontalPanel;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//
public class Slider1 extends HorizontalPanel {
    //
    public Slider1(@Nullable SimpleColorScheme colors) {
        super(colors, 100, null);
        @NotNull Color background = getPanelColors().getBaseColor();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new DynamicLabel(getPanelColors().getSecondaryColor(), background) {
            @Override
            public @NotNull String getLabelText() {
                return "Slider 1: " + StaticData.sliderTestValue;
            }
        });
        add(new MySlider(background));
    }

    //
    public static class MySlider extends JSlider {
        MySlider(@NotNull Color backgroundColor) {
            super(0, 20, 10);
            setFocusable(false);
            setBackground(backgroundColor); //prevents flickering
            setMinorTickSpacing(5);
            setSnapToTicks(true);
            setMajorTickSpacing(10);

            //setPaintTrack(false);
            setPaintTicks(true);
            setPaintLabels(true);
            //setVisible(true);
            addChangeListener(new SliderListener(getValue()));
        }
    }

    //
    private static class SliderListener implements ChangeListener {

        //
        SliderListener(int initialValue) {
            updateValue(initialValue);
        }

        /**
         * Invoked when the target of the listener has changed its state.
         *
         * @param e a ChangeEvent object
         */
        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
                updateValue(source.getValue());
            }
        }

        private void updateValue(int value) {
            StaticData.sliderTestValue = value;
        }
    }
}