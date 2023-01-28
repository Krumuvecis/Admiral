package graphics.devMode.page0_template;

import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.panels.DynamicPanel;
import graphicsEngine.pages.panels.AbstractLeftPanel;
import graphicsEngine.pages.panels.AbstractRightPanel;
import graphicsEngine.parts.labels.SimpleLabel;

import graphics.common.CommonWindow;
import graphics.devMode.common.DevPage;

//TODO: add javadocs
public class Page0 extends DevPage {

    private Page0() {
        this(null);
    }

    //TODO: add javadoc
    public Page0(@Nullable CommonWindow window) {
        super(window, getNewListeners(window));
    }

    //TODO: add javadoc
    @Override
    public final @NotNull String getPageKey() {
        return "page0";
    }

    //TODO: add javadoc
    public static @NotNull String getStaticPageKey() {
        return (new Page0()).getPageKey();
    }

    private static @NotNull List<@NotNull ActionListener> getNewListeners(@Nullable CommonWindow window) {
        return new ArrayList<>() {{
            if (window != null) {
                add(DevPage.getNewHeaderListener(window));
            }
        }};
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public final @Nullable AbstractLeftPanel getLeftPanel(@Nullable SimpleColorScheme colors,
                                                          @Nullable BorderProperties borderProperties) {
        return null;
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public final @Nullable AbstractRightPanel getRightPanel(@Nullable SimpleColorScheme colors,
                                                            @Nullable BorderProperties borderProperties) {
        return null;
    }

    /**
     * TODO: finish this javadoc
     */
    public final @NotNull DynamicPanel getCentralPanel(@Nullable BorderProperties borderProperties) {
        return new DynamicPanel(
                null,
                new SimpleColorScheme(ColorUtilities.DEFAULT_COLOR_TRANSPARENT, Color.white),
                null) {
            {
                setLayout(new BorderLayout(0, 0));
                add(new SimpleLabel("Page 0", getPanelColors().getSecondaryColor()), BorderLayout.NORTH);
                //Add parts to body here
            }
        };
    }
}