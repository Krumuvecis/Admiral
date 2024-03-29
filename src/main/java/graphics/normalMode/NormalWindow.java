package graphics.normalMode;

import java.util.List;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

import graphicsEngine.windows.WindowManager;
import graphicsEngine.pages.AbstractPage;

import graphics.common.CommonWindow;
import graphics.normalMode.startingPage.StartingPage;
import graphics.normalMode.playPage.PlayPage;

/**
 * The window for this application
 * TODO: finish javadocs
 */
public class NormalWindow extends CommonWindow {
    private static final int @NotNull [] STARTING_SIZE = new int[] {1000, 600};

    //TODO: add javadoc
    public NormalWindow(@NotNull WindowManager windowManager) {
        super(
                windowManager, null,
                STARTING_SIZE, null,
                StartingPage.getStaticPageKey());
    }

    /**
     * TODO: finish this
     * @return
     */
    @Override
    public final @NotNull List<@NotNull AbstractPage> getInitialPages() {
        @NotNull NormalWindow window = this;
        return new ArrayList<>() {{
            add(new StartingPage(window));
            add(new PlayPage(window));
        }};
    }
}