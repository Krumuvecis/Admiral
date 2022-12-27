package graphics.devMode.page2;

import java.util.List;
import java.awt.*;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.StaticPanel;
import graphicsEngine.parts.labels.SimpleLabel;

import graphics.common.CommonWindow;
import graphics.devMode.common.DevSubPage;

//TODO: add javadocs
public class Page2 extends DevSubPage {

    private Page2() {
        this(null, null, null);
    }

    //TODO: add javadoc
    public Page2(@Nullable CommonWindow window,
                 @Nullable List<ActionListener> actionListenerList,
                 @Nullable SimpleColorScheme colors) {
        super(window, actionListenerList, colors);
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