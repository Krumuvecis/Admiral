package graphics.normalMode.playPage.leftPanel.labelSection;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.BoxLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.HorizontalPanel;
import graphicsEngine.parts.labels.SimpleLabel;

//TODO: add javadocs
public class LabelSection extends HorizontalPanel {
    private static final int HEIGHT = 40;

    //TODO: add javadoc
    public LabelSection(@Nullable SimpleColorScheme colors) {
        super(colors, HEIGHT, null);

        // Prevents left-side alignment flickering; TODO: needs better solution
        setMinimumSize(new Dimension(Integer.MAX_VALUE, HEIGHT));

        @SuppressWarnings("unused") @NotNull Color
                textColor = getPanelColors().getSecondaryColor(),
                background = getPanelColors().getBaseColor(); //prevents flickering for dynamic labels
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new SimpleLabel(
                "Play page",
                textColor));
        // add more labels here
    }
}