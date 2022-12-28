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
import graphicsEngine.panels.DynamicPanel;
import graphicsEngine.parts.labels.SimpleLabel;

import graphics.common.CommonWindow;
import graphics.common.panels.AbstractLeftPanel;
import graphics.common.panels.AbstractRightPanel;
import graphics.devMode.common.DevPage;

//TODO: add javadocs
public class Page1 extends DevPage {

    private Page1() {
        this(null, null);
    }

    //TODO: add javadoc
    public Page1(@Nullable CommonWindow window,
                 @Nullable SimpleColorScheme colors) {
        super(window, getNewListeners(window), colors);
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

    //
    @Override
    public @Nullable AbstractLeftPanel getLeftPanel(@NotNull CommonWindow window) {
        return null;
    }

    //
    @Override
    public @Nullable AbstractRightPanel getRightPanel(@NotNull CommonWindow window) {
        return null;
    }

    //
    @Override
    public @Nullable DynamicPanel getCentralPanel(@NotNull CommonWindow window) {
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