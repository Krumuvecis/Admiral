package graphics.devMode.page2;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.StaticPanel;
import graphicsEngine.parts.labels.SimpleLabel;

import graphics.common.CommonWindow;
import graphics.devMode.common.DevPage;

//TODO: add javadocs
public class Page2 extends DevPage {

    private Page2() {
        this(null, null);
    }

    //TODO: add javadoc
    public Page2(@Nullable CommonWindow window,
                 @Nullable SimpleColorScheme colors) {
        super(window, getNewListeners(window), colors);
    }

    //TODO: add javadoc
    @Override
    public final @NotNull String getPageKey() {
        return "page2";
    }

    //TODO: add javadoc
    public static @NotNull String getStaticPageKey() {
        return (new Page2()).getPageKey();
    }

    private static @NotNull List<@NotNull ActionListener> getNewListeners(@Nullable CommonWindow window) {
        return new ArrayList<>() {{
            if (window != null) {
                add(DevPage.getNewHeaderListener(window));
            }
        }};
    }

    //TODO: add javadoc
    @Override
    public void setBodyParameters() {
        //TODO: set body parameters here
    }

    //TODO: add javadoc
    @Override
    public @Nullable Component getPageBody() {
        return new StaticPanel(
                null,
                new SimpleColorScheme(ColorUtilities.DEFAULT_COLOR_TRANSPARENT, Color.white),
                null) {
            {
                setLayout(new BorderLayout(0, 0));
                add(new SimpleLabel("Page 2", getPanelColors().getSecondaryColor()), BorderLayout.NORTH);
                //Add parts to body here
            }
        };
    }
}