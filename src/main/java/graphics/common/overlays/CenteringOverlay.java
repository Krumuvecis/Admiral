package graphics.common.overlays;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.presets.SimpleOverlay;

public abstract class CenteringOverlay extends SimpleOverlay implements Centerable {
    private static final double DEFAULT_TRANSPARENCY = 0.5;
    private static final Color BACKGROUND_COLOR = new Color(
            0, 0, 0,
            (int) (255 * DEFAULT_TRANSPARENCY));

    /**
     * TODO: finish this javadoc
     */
    public CenteringOverlay(@Nullable ActionListener actionListener) {
        super(BACKGROUND_COLOR);
        addCenteredCenter(actionListener);
    }

    private void addCenteredCenter(@Nullable ActionListener actionListener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        int[] minimumOffset = new int[] {1, 1}; //for symmetrical centering

        add(Centerable.getVerticalOffsetPanel(minimumOffset[1])); //top offset
        add(new JPanel() {{
            setBackground(ColorUtilities.defaultColorByOpacity(false));
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            add(Centerable.getHorizontalOffsetPanel(minimumOffset[0])); //left offset
            add(getCenter(actionListener)); //actual button container
            add(Centerable.getHorizontalOffsetPanel(minimumOffset[0])); //right offset
        }});
        add(Centerable.getVerticalOffsetPanel(minimumOffset[1])); //bottom offset
    }
}