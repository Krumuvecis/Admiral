package graphics.playPage.leftPanel.sliders;

import staticData.StaticData;

import graphics.playPage.leftPanel.DynamicLabel;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.presets.panels.HorizontalPanel;

import java.awt.*;
import javax.swing.*;

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
    public static class MySlider extends SimpleSlider {
        MySlider(@NotNull Color backgroundColor) {
            super(
                    backgroundColor,
                    0, 20, 10,
                    5, 10);
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
}