package graphics.normalMode.playPage;

import java.util.List;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.DynamicPanel;

import graphics.normalMode.NormalWindow;
import graphics.normalMode.common.NormalPage;
import graphics.normalMode.playPage.observer.Observer;
import graphics.normalMode.playPage.leftPanel.LeftPanel;
import graphics.normalMode.playPage.drawPanel.DrawPanel;

//TODO: add javadocs
public class PlayPage extends NormalPage {
    private Observer observer;

    private PlayPage() {
        this(null, null, null);
    }

    //TODO: add javadoc
    public PlayPage(@Nullable NormalWindow window,
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
        @Nullable NormalWindow window = (NormalWindow) getWindow();
        if (window == null) {
            return null;
        } else {
            observer = new Observer(window);
            @Nullable Color backgroundColor = ColorUtilities.DEFAULT_COLOR_TRANSPARENT;
            return new DynamicPanel(new SimpleColorScheme(backgroundColor, null)) {
                {
                    setLayout(new BorderLayout(0, 0));
                    add(new LeftPanel(window, observer), BorderLayout.WEST);
                    add(new DrawPanel(observer));
                }
            };
        }
    }
}