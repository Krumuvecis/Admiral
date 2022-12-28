package graphics.common.panels;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.presets.panels.VerticalPanel;

//TODO: is this really necessary?
public abstract class AbstractLeftPanel extends VerticalPanel {
    public AbstractLeftPanel(@Nullable SimpleColorScheme colors,
                             int width,
                             @Nullable BorderProperties borderProperties) {
        super(colors, width, borderProperties);
    }
}