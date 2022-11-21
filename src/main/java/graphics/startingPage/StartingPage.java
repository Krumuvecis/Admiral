package graphics.startingPage;

import graphics.Window;
import graphics.common.CommonPage;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.StaticPanel;
import graphicsEngine.parts.SimpleLabel;

import java.util.List;
import java.awt.Color;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadoc
public class StartingPage extends CommonPage {
    private StartingPage() {
        this(null, null, null);
    }

    //TODO: add javadoc
    public StartingPage(@Nullable Window window,
                        @Nullable List<ActionListener> actionListenerList,
                        @Nullable SimpleColorScheme colors) {
        super(window, actionListenerList, colors);
    }

    //TODO: add javadoc
    @Override
    public final @NotNull String getPageKey() {
        return "startingPage";
    }

    //TODO: add javadoc
    public static @NotNull String getStaticPageKey() {
        return (new StartingPage()).getPageKey();
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
                add(new SimpleLabel("Starting page", getPanelColors().getSecondaryColor()), BorderLayout.NORTH);
                //Add parts to body here
            }
        };
    }
}