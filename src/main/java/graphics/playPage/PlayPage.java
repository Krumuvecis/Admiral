package graphics.playPage;

import graphics.common.CommonPage;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.StaticPanel;
import graphicsEngine.parts.SimpleLabel;

import java.util.List;
import java.awt.*;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadoc
public class PlayPage extends CommonPage {
    private PlayPage() {
        this(null, null);
    }


    public PlayPage(@Nullable List<ActionListener> actionListenerList,
                    @Nullable SimpleColorScheme colors) {
        super(actionListenerList, colors);
    }

    //TODO: add javadoc
    @Override
    public String getPageKey() {
        return "playPage";
    }

    //TODO: add javadoc
    public static @NotNull String getStaticPageKey() {
        return (new PlayPage()).getPageKey();
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
                add(new SimpleLabel("Play page", getPanelColors().getSecondaryColor()), BorderLayout.NORTH);
                //Add parts to body here
            }
        };
    }
}