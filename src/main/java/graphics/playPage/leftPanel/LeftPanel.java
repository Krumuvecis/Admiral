package graphics.playPage.leftPanel;

import graphics.Window;
import graphics.playPage.observer.Observer;
import graphics.playPage.leftPanel.labelSection.LabelSection;
import graphics.playPage.leftPanel.sliders.InertiaFactorSlider;
import graphics.playPage.leftPanel.sliders.PressureToWindCoefficientSlider;
import graphics.playPage.leftPanel.leftDrawPanel.LeftDrawPanel;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.presets.panels.VerticalPanel;

import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadocs
public class LeftPanel extends VerticalPanel {
    private static final int PANEL_WIDTH = 200;
    private static final int BACKGROUND_BRIGHTNESS = 80;
    private static final @Nullable Color
            BACKGROUND_COLOR = new Color(
                    BACKGROUND_BRIGHTNESS,
                    BACKGROUND_BRIGHTNESS,
                    BACKGROUND_BRIGHTNESS),
            TEXT_COLOR = null; // default - white

    //TODO: add javadoc
    public LeftPanel(@NotNull Window window,
                     @NotNull Observer observer) {
        super(
                new SimpleColorScheme(BACKGROUND_COLOR, TEXT_COLOR),
                PANEL_WIDTH,
                null);
        LayoutManager layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        add(new LabelSection(getPanelColors()), layout);
        add(new InertiaFactorSlider(getPanelColors()), layout);
        add(new PressureToWindCoefficientSlider(getPanelColors()), layout);
        add(new LeftDrawPanel(window, observer), layout);
    }
}