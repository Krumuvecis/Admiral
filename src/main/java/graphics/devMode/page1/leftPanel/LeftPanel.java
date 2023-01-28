package graphics.devMode.page1.leftPanel;

import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.pages.panels.AbstractLeftPanel;
import graphicsEngine.parts.labels.SimpleLabel;

//TODO: add javadocs
public class LeftPanel extends AbstractLeftPanel {
    private static final int PANEL_WIDTH = 200;

    //TODO: add javadoc
    public LeftPanel(@Nullable SimpleColorScheme colors,
                     @Nullable BorderProperties borderProperties) {
        super(colors, PANEL_WIDTH, borderProperties);
        LayoutManager layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        @NotNull Color textColor = getPanelColors().getSecondaryColor();
        add(new PageNameLabel(textColor));
        //add more stuff here
    }

    private static class PageNameLabel extends SimpleLabel {
        private static final @NotNull String LABEL_TEXT = "Page 1 - Barokinetics test";
        private PageNameLabel(@Nullable Color textColor) {
            super(LABEL_TEXT, textColor);
        }
    }
}