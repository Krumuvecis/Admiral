package graphics.common.overlays;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.panels.StaticPanel;

/**
 * TODO: finish this javadoc
 */
public abstract class CenteringPanel extends StaticPanel implements Centerable {
    private static final double DEFAULT_TRANSPARENCY = 0.5;
    private static final Color BACKGROUND_COLOR = new Color(
            0, 0, 0,
            (int) (255 * DEFAULT_TRANSPARENCY));


    /**
     * TODO: finish this javadoc
     */
    public CenteringPanel(@Nullable ActionListener actionListener) {
        super(null, getColors(), new BorderProperties(Color.red, true));
        addCenteredCenter(actionListener);
    }

    private static @NotNull SimpleColorScheme getColors() {
        return new SimpleColorScheme(
                BACKGROUND_COLOR,
                null);
    }

    private void addCenteredCenter(@Nullable ActionListener actionListener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Centerable.getOffsetPanel()); //top offset
        add(getHorizontallyCenteredCenter(actionListener));
        add(Centerable.getOffsetPanel()); //bottom offset
    }

    private @NotNull JPanel getHorizontallyCenteredCenter(@Nullable ActionListener actionListener) {
        return new JPanel() {{
            setBackground(ColorUtilities.defaultColorByOpacity(false));
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            add(Centerable.getOffsetPanel()); //left offset
            add(getCenter(actionListener)); //actual button container
            add(Centerable.getOffsetPanel()); //right offset
        }};
    }
}