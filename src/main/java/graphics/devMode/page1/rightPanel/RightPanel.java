package graphics.devMode.page1.rightPanel;

import java.awt.LayoutManager;
import javax.swing.BoxLayout;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.pages.panels.AbstractRightPanel;

import graphics.devMode.page1.rightPanel.labelSection.LabelSection;
import graphics.devMode.page1.rightPanel.sliders.SliderPanel;

//TODO: add javadocs
public class RightPanel extends AbstractRightPanel {
    private static final int PANEL_WIDTH = 200;

    //TODO: add javadoc
    public RightPanel(@Nullable SimpleColorScheme colors,
                      @Nullable BorderProperties borderProperties) {
        super(colors, PANEL_WIDTH, borderProperties);
        LayoutManager layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        add(new LabelSection(getPanelColors()), layout);
        add(new SliderPanel(getPanelColors()), layout);
        //add more panels here
    }
}