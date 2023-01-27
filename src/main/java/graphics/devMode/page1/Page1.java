package graphics.devMode.page1;

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
import graphicsEngine.parts.labels.SimpleLabel;

import graphics.common.CommonWindow;
import graphics.devMode.common.DevPage;
import graphics.devMode.page1.leftPanel.LeftPanel;

//TODO: add javadocs
public class Page1 extends DevPage {

    private Page1() {
        this(null);
    }

    //TODO: add javadoc
    public Page1(@Nullable CommonWindow window) {
        super(window, getNewListeners(window));
    }

    //TODO: add javadoc
    @Override
    public final @NotNull String getPageKey() {
        return "page1";
    }

    //TODO: add javadoc
    public static @NotNull String getStaticPageKey() {
        return (new Page1()).getPageKey();
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
        @Nullable CommonWindow commonWindow = getCommonWindow();
        if (commonWindow == null) {
            return null;
        } else {
            return new LeftPanel(getCommonWindow(), colors, borderProperties);
        }
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
                add(new SimpleLabel("Page 1", getPanelColors().getSecondaryColor()), BorderLayout.NORTH);
                //Add parts to body here
            }
        };
    }
}