package graphics.common.centering;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.panels.StaticPanel;

/**
 * TODO: add javadocs
 */
public abstract class CentralContainer extends StaticPanel {
    //TODO: add javadoc
    public CentralContainer(@Nullable ActionListener actionListener) {
        super(getSizeLimits(), getContainerColors(), new BorderProperties(Color.red, true));
        //setMinimumSize(getSizeLimits()); //uncomment, if constant size required
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addComponents(actionListener);
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

    //TODO: add javadoc
    public abstract void addComponents(@Nullable ActionListener actionListener);
}