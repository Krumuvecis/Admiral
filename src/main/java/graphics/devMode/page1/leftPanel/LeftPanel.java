package graphics.devMode.page1.leftPanel;

import java.awt.LayoutManager;
import javax.swing.BoxLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.pages.panels.AbstractLeftPanel;

import graphicsEngineExtension.windows.KeyboardListenableWindow;

//TODO: add javadocs
public class LeftPanel extends AbstractLeftPanel {
    private static final int PANEL_WIDTH = 200;

    //TODO: add javadoc
    public LeftPanel(@NotNull KeyboardListenableWindow window,
                     @Nullable SimpleColorScheme colors,
                     @Nullable BorderProperties borderProperties) {
        super(colors, PANEL_WIDTH, borderProperties);
        LayoutManager layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        //add(new LabelSection(getPanelColors()), layout);
        //add(new SliderPanel(getPanelColors()), layout);
        //add(new LeftDrawPanel(window), layout);
    }
}