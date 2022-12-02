package graphics.playPage.leftPanel.sliders.abstraction;

import graphics.playPage.leftPanel.DynamicLabel;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.presets.panels.HorizontalPanel;

import javax.swing.BoxLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadocs
public abstract class SliderPanel extends HorizontalPanel {
    private static final int DEFAULT_HEIGHT = 70;

    //TODO: add javadoc
    public SliderPanel(@Nullable SimpleColorScheme colors) {
        super(colors, DEFAULT_HEIGHT, null);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        @NotNull SliderPanel panel = this;
        add(new DynamicLabel(
                getPanelColors().getSecondaryColor(),
                getPanelColors().getBaseColor()) {
            //TODO: add javadoc
            @Override
            public @NotNull String getLabelText() {
                return panel.getLabelText();
            }
        });
    }

    //TODO: add javadoc
    public abstract @NotNull String getLabelText();

    /**
     * Performed upon changing the value.
     *
     * @param value The new value.
     */
    public abstract void valueChanged(double value);
}