package graphics.common.overlays;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.panels.StaticPanel;

/**
 * TODO: add javadocs
 */
public class ButtonContainer extends StaticPanel {
    public ButtonContainer(@Nullable ActionListener actionListener) {
        super(getSizeLimits(), getContainerColors(), getBorderProperties());
        //setMinimumSize(getSizeLimits()); //uncomment, if constant size required
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addButtons(actionListener);
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

    private void addButtons(@Nullable ActionListener actionListener) {
        add(new Button_HideOverlay(actionListener));
    }
}