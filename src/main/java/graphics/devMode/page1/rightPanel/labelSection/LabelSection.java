package graphics.devMode.page1.rightPanel.labelSection;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.BoxLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.HorizontalPanel;

//TODO: add javadocs
public class LabelSection extends HorizontalPanel {
    private static final int HEIGHT = 40;

    //TODO: add javadoc
    public LabelSection(@Nullable SimpleColorScheme colors) {
        super(colors, HEIGHT, null);

        // Prevents left-side alignment flickering; TODO: needs better solution
        setMinimumSize(new Dimension(Integer.MAX_VALUE, HEIGHT));

        @NotNull Color
                textColor = getPanelColors().getSecondaryColor(),
                background = getPanelColors().getBaseColor(); //prevents flickering for dynamic labels
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new TotalPressureLabel(textColor, background));
        // add more labels here
    }
}