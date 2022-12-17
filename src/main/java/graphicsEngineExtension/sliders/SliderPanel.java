package graphicsEngineExtension.sliders;

import javax.swing.BoxLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.presets.panels.HorizontalPanel;

import graphics.playPage.leftPanel.DynamicLabel;

//TODO: add javadocs
abstract class SliderPanel extends HorizontalPanel {

    //TODO: add javadoc
    public SliderPanel(@Nullable SimpleColorScheme colors, int height) {
        super(colors, height, null);
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