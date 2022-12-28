package graphics.normalMode.playPage;

import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.DynamicPanel;

import graphics2.Observer;

import graphics.common.CommonWindow;
import graphics.common.panels.AbstractLeftPanel;
import graphics.common.panels.AbstractRightPanel;
import graphics.normalMode.NormalWindow;
import graphics.normalMode.common.NormalPage;
import graphics.normalMode.playPage.leftPanel.LeftPanel;
import graphics.normalMode.playPage.drawPanel.DrawPanel;

//TODO: add javadocs
public class PlayPage extends NormalPage {
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

    //
    @Override
    public final @NotNull AbstractLeftPanel getLeftPanel(@NotNull CommonWindow window) {
        return new LeftPanel(window);
    }

    //
    @Override
    public final @Nullable AbstractRightPanel getRightPanel(@NotNull CommonWindow window) {
        return null;
    }

    //
    @Override
    public final @NotNull DynamicPanel getCentralPanel(@NotNull CommonWindow window) {
        @NotNull Observer observer = new Observer();
        new KeyboardActions(window, observer).start();
        return new DrawPanel(observer);
    }
}