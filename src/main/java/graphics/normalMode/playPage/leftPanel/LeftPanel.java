package graphics.normalMode.playPage.leftPanel;

import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;

import graphicsEngineExtension.windows.KeyboardListenableWindow;

import graphics.normalMode.playPage.leftPanel.labelSection.LabelSection;
import graphics.normalMode.playPage.leftPanel.sliders.SliderPanel;
import graphics.normalMode.playPage.leftPanel.leftDrawPanel.LeftDrawPanel;

//TODO: add javadocs
public class LeftPanel extends graphicsEngine.pages.panels.AbstractLeftPanel {
    private static final int PANEL_WIDTH = 200;
    private static final int BACKGROUND_BRIGHTNESS = 80;
    private static final @Nullable Color
            BACKGROUND_COLOR = new Color(
                    BACKGROUND_BRIGHTNESS,
                    BACKGROUND_BRIGHTNESS,
                    BACKGROUND_BRIGHTNESS),
            TEXT_COLOR = null; // default - white

    //TODO: add javadoc
    public LeftPanel(@NotNull KeyboardListenableWindow window) {
        super(
                new SimpleColorScheme(BACKGROUND_COLOR, TEXT_COLOR),
                PANEL_WIDTH,
                null);
        LayoutManager layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        add(new LabelSection(getPanelColors()), layout);
        add(new SliderPanel(getPanelColors()), layout);
        add(new LeftDrawPanel(window), layout);
    }
}