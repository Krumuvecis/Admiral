package graphics.playPage.leftPanel.sliders;

import java.awt.LayoutManager;
import javax.swing.BoxLayout;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.DynamicPanel;

/**
 * A panel containing all the sliders.
 */
public class SliderPanel extends DynamicPanel {
    /**
     * Creates a new SliderPanel.
     *
     * @param colors A SimpleColorScheme object.
     */
    public SliderPanel(@Nullable SimpleColorScheme colors) {
        super(colors);
        LayoutManager layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        add(new InertiaFactorSlider(getPanelColors()), layout);
        add(new PressureToWindCoefficientSlider(getPanelColors()), layout);
    }
}