package graphics.playPage;

import graphics.Window;
import graphics.common.CommonPage;
import graphics.playPage.drawPanel.DrawPanel;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.DynamicPanel;
import graphicsEngine.parts.SimpleLabel;

import java.util.List;
import java.awt.*;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadoc
public class PlayPage extends CommonPage {
    private PlayPage() {
        this(null, null, null);
    }

    //TODO: add javadoc
    public PlayPage(@Nullable Window window,
                    @Nullable List<ActionListener> actionListenerList,
                    @Nullable SimpleColorScheme colors) {
        super(window, actionListenerList, colors);
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
        @Nullable Color backgroundColor = ColorUtilities.DEFAULT_COLOR_TRANSPARENT;
        return new DynamicPanel(new SimpleColorScheme(backgroundColor, null)) {
            {
                setLayout(new BorderLayout(0, 0));
                add(new LeftPanel(), BorderLayout.WEST);
                add(new DrawPanel(window));
            }
        };
    }
}