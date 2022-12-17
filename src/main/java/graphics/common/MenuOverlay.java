package graphics.common;

import java.awt.Dimension;
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
import graphicsEngine.presets.SimpleOverlay;

/**
 * TODO: add javadocs
 */
public class MenuOverlay extends SimpleOverlay {
    private static final double DEFAULT_TRANSPARENCY = 0.5;
    private static final Color BACKGROUND_COLOR = new Color(
            0, 0, 0,
            (int) (255 * DEFAULT_TRANSPARENCY));

    /**
     * TODO: finish this javadoc
     */
    public MenuOverlay(@Nullable ActionListener actionListener) {
        super(BACKGROUND_COLOR);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        int[] minimumOffset = new int[] {1, 1}; //for symmetrical centering

        add(getOffsetPanel(new Dimension(Integer.MAX_VALUE, minimumOffset[1]))); //top offset
        add(new JPanel() {{
            setBackground(ColorUtilities.defaultColorByOpacity(false));
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            add(getOffsetPanel(new Dimension(minimumOffset[0], Integer.MAX_VALUE))); //left offset
            add(new ButtonContainer(actionListener));
            add(getOffsetPanel(new Dimension(minimumOffset[0], Integer.MAX_VALUE))); //right offset
        }});
        add(getOffsetPanel(new Dimension(Integer.MAX_VALUE, minimumOffset[1]))); //bottom offset
    }

    private static @NotNull JPanel getOffsetPanel(@NotNull Dimension preferredSize) {
        @NotNull Color transparentColor = ColorUtilities.defaultColorByOpacity(false);
        return new JPanel() {{
            setBackground(transparentColor);
            setPreferredSize(preferredSize);
        }};
    }

    /**
     * TODO: add javadocs
     */
    public static class ButtonContainer extends StaticPanel {
        public ButtonContainer(@Nullable ActionListener actionListener) {
            super(getSizeLimits(), getContainerColors(), getBorderProperties());
            //setMinimumSize(getSizeLimits()); //uncomment, if constant size required
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            add(new OverlayButtonListener.Button_HideOverlay(actionListener));
        }

        private static @Nullable Dimension getSizeLimits() {
            //TODO: finish this
            //return new Dimension(200, 200); //uncomment, if constant size required
            return null;
        }

        private static @NotNull SimpleColorScheme getContainerColors() {
            return new SimpleColorScheme(
                    ColorUtilities.defaultColorByOpacity(false),
                    null);
        }

        private static @Nullable BorderProperties getBorderProperties() {
            //TODO: finish this
            return new BorderProperties(Color.red, true);
        }
    }
}