package graphics.normalMode.playPage;

import java.util.List;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.DynamicPanel;

import graphics2.Observer;

import graphics.common.CommonWindow;
import graphics.normalMode.NormalWindow;
import graphics.normalMode.common.NormalPage;
import graphics.normalMode.playPage.leftPanel.LeftPanel;
import graphics.normalMode.playPage.drawPanel.DrawPanel;

//TODO: add javadocs
public class PlayPage extends NormalPage {
    private Observer observer;

    private PlayPage() {
        this(null, null);
    }

    //TODO: add javadoc
    public PlayPage(@Nullable NormalWindow window,
                    @Nullable SimpleColorScheme colors) {
        super(window, getNewListeners(window), colors);
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

    private static @NotNull List<@NotNull ActionListener> getNewListeners(@Nullable CommonWindow window) {
        return new ArrayList<>() {{
            if (window != null) {
                add(NormalPage.getNewHeaderListener(window));
            }
        }};
    }

    //TODO: add javadoc
    @Override
    public final void setBodyParameters() {
        //TODO: set body parameters here
    }

    //TODO: add javadoc
    @Override
    public final @Nullable Component getPageBody() {
        @Nullable NormalWindow window = (NormalWindow) getWindow();
        if (window == null) {
            return null;
        } else {
            @Nullable Color backgroundColor = ColorUtilities.DEFAULT_COLOR_TRANSPARENT;
            return new DynamicPanel(new SimpleColorScheme(backgroundColor, null)) {
                {
                    setLayout(new BorderLayout(0, 0));
                    add(new LeftPanel(window), BorderLayout.WEST);

                    observer = new Observer();
                    new ObserverKeyboardChecker(window, observer).start();
                    add(new DrawPanel(observer));
                }
            };
        }
    }
}