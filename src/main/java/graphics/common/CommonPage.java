package graphics.common;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.panels.DynamicPanel;
import graphicsEngine.presets.HeaderAndFooterPage;
import graphicsEngine.presets.panels.AbstractHeader;
import graphicsEngine.presets.panels.AbstractFooter;

import java.util.Objects;
import java.util.List;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: finish this and add javadoc
public abstract class CommonPage extends HeaderAndFooterPage {
    private HeaderButtonListener headerButtonListener;

    //TODO: add javadoc
    public CommonPage(@Nullable List<ActionListener> actionListenerList,
                      @Nullable SimpleColorScheme colors) {
        super(actionListenerList, null, colors, null);
        setBodyParameters();
        addBody(getPageBody());
    }

    /**
     * Adds known listeners to this page.
     * Override this to add custom listeners.
     *
     * @param list List of listeners to add.
     *
     * @return Remaining unknown listeners.
     */
    @Override
    public @NotNull List<ActionListener> addListeners(@Nullable List<ActionListener> list) {
        List<ActionListener> remainder = super.addListeners(list);
        for (int i = 0; i < remainder.size(); i++) {
            ActionListener listener = remainder.get(i);
            if (listener instanceof HeaderButtonListener) {
                headerButtonListener = (HeaderButtonListener) listener;
                remainder.remove(i);
                i--;
            }
        }
        return remainder;
    }

    //TODO: add javadoc
    @Override
    public @NotNull AbstractHeader getHeader(@Nullable SimpleColorScheme headerColors,
                                             @Nullable BorderProperties borderProperties) {
        return new CommonHeader(headerColors, borderProperties, headerButtonListener);
    }

    //TODO: add javadoc
    @Override
    public @Nullable AbstractFooter getFooter(@Nullable SimpleColorScheme footerColors,
                                              @Nullable BorderProperties borderProperties) {
        return null;
    }

    //TODO: add javadoc
    @Override
    public final void addParts() {}

    //TODO: add javadoc
    public abstract void setBodyParameters();

    private void addBody(@Nullable Component center) {
        add(new DynamicPanel(
                null,
                new SimpleColorScheme(
                        ColorUtilities.DEFAULT_COLOR_TRANSPARENT,
                        null),
                null) {
            @Override
            public void addParts() {
                setLayout(new BorderLayout(0, 0));
                add(Objects.requireNonNullElse(center, new JPanel()), BorderLayout.CENTER);
            }
        });
    }

    //TODO: add javadoc
    public abstract @Nullable Component getPageBody();
}