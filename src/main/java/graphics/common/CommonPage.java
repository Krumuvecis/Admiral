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
import graphicsEngine.presets.panels.AbstractFooter;

/**
 * TODO: finish this and add javadocs
 */
public abstract class CommonPage extends HeaderAndFooterPage {
    private final @Nullable CommonWindow window;

    /**
     * TODO: finish this javadoc
     */
    public CommonPage(@Nullable CommonWindow window,
                      @Nullable List<ActionListener> actionListenerList,
                      @Nullable SimpleColorScheme colors) {
        super(actionListenerList, null, colors, null);
        this.window = window;
        if (window != null) {
            setBodyParameters();
            addBody(getPageBody());
        }
    }

    //TODO: add javadoc
    public final @Nullable CommonWindow getWindow() {
        return window;
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
        @NotNull List<ActionListener> remainder = super.addListeners(list);
        for (int i = 0; i < remainder.size(); i++) {
            ActionListener listener = remainder.get(i);
            if (addParticularListener(listener)) {
                remainder.remove(i);
                i--;
            }
        }
        return remainder;
    }

    //TODO: add javadoc
    public abstract boolean addParticularListener(@Nullable ActionListener listener);

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

    private void addBody(@Nullable Component body) {
        add(new DynamicPanel(
                null,
                new SimpleColorScheme(
                        null,
                        null),
                null) {
            @Override
            public void addParts() {
                setLayout(new BorderLayout(0, 0));
                add(Objects.requireNonNullElse(body, new JPanel()), BorderLayout.CENTER);
            }
        });
    }

    /**
     * TODO: finish this javadoc
     */
    public abstract @Nullable Component getPageBody();
}