package graphics.common;

import java.util.Objects;
import java.util.List;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.panels.DynamicPanel;
import graphicsEngine.presets.HeaderAndFooterPage;
import graphicsEngine.presets.panels.AbstractHeader;
import graphicsEngine.presets.panels.AbstractFooter;

import graphics.Window;

/**
 * TODO: finish this and add javadocs
 */
public abstract class CommonPage extends HeaderAndFooterPage {
    public final Window window;
    private HeaderButtonListener headerButtonListener;

    /**
     * TODO: finish this javadoc
     */
    public CommonPage(@Nullable Window window,
                      @Nullable List<ActionListener> actionListenerList,
                      @Nullable SimpleColorScheme colors) {
        super(actionListenerList, null, colors, null);
        this.window = window;
        if (window != null) {
            setBodyParameters();
            addBody(getPageBody());
        }
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

    /**
     * TODO: finish this javadoc
     */
    @Override
    public @NotNull AbstractHeader getHeader(@Nullable SimpleColorScheme headerColors,
                                             @Nullable BorderProperties borderProperties) {
        return new CommonHeader(headerColors, borderProperties, headerButtonListener);
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public @Nullable AbstractFooter getFooter(@Nullable SimpleColorScheme footerColors,
                                              @Nullable BorderProperties borderProperties) {
        return null;
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public final void addParts() {}

    /**
     * TODO: finish this javadoc
     */
    public abstract void setBodyParameters();

    private void addBody(@Nullable Component center) {
        add(new DynamicPanel(
                null,
                new SimpleColorScheme(
                        null,
                        null),
                null) {
            @Override
            public void addParts() {
                setLayout(new BorderLayout(0, 0));
                add(Objects.requireNonNullElse(center, new JPanel()), BorderLayout.CENTER);
            }
        });
    }

    /**
     * TODO: finish this javadoc
     */
    public abstract @Nullable Component getPageBody();
}