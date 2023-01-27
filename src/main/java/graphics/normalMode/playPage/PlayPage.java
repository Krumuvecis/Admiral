package graphics.normalMode.playPage;

import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.panels.DynamicPanel;
import graphicsEngine.pages.panels.AbstractLeftPanel;

import graphics2.Observer;

import graphics.common.CommonWindow;
import graphics.normalMode.NormalWindow;
import graphics.normalMode.common.NormalPage;
import graphics.normalMode.playPage.leftPanel.LeftPanel;
import graphics.normalMode.playPage.drawPanel.DrawPanel;

//TODO: add javadocs
public class PlayPage extends NormalPage {
    private PlayPage() {
        this(null);
    }

    //TODO: add javadoc
    public PlayPage(@Nullable NormalWindow window) {
        super(window, getNewListeners(window));
    }

    //TODO: add javadoc
    @Override
    public @NotNull String getPageKey() {
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
    public final @Nullable DynamicPanel getCentralPanel(@Nullable BorderProperties borderProperties) {
        @Nullable CommonWindow commonWindow = getCommonWindow();
        if (commonWindow == null) {
            return null;
        } else {
            @NotNull Observer observer = new Observer();
            new KeyboardActions(commonWindow, observer).start();
            return new DrawPanel(observer);
        }
    }
}