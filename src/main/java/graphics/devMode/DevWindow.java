package graphics.devMode;

import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;

import graphicsEngine.windows.AbstractPage;
import graphicsEngine.windows.WindowManager;

import graphics.common.CommonWindow;

/**
 * The window for this application
 * TODO: finish javadocs
 */
public class DevWindow extends CommonWindow {
    private static final int @NotNull []
            STARTING_SIZE = new int[] {1000, 600},
            STARTING_LOCATION = new int[] {200, 30};

    //TODO: add javadoc
    public DevWindow(@NotNull WindowManager windowManager) {
        super(windowManager, "dev mode", STARTING_SIZE, STARTING_LOCATION);
        //TODO: return back to starting page after testing
        //setActivePage(StartingPage.getStaticPageKey());
        //setActivePage(PlayPage.getStaticPageKey());

        //setOverlay(new MenuOverlay(new OverlayButtonListener(this)));
    }

    /**
     * TODO: finish this
     * @return
     */
    @Override
    public @NotNull List<AbstractPage> getInitialPages() {
        DevWindow window = this;
        return new ArrayList<>() {{
            //add(new StartingPage(window, getListenerList_StartingPage(), null));
            //add(new PlayPage(window, getListenerList_PlayPage(), null));
        }};
    }

    private @NotNull List<ActionListener> getListenerList_StartingPage() {
        return new ArrayList<>() {{
            add(getHeaderListener());
        }};
    }

    private @NotNull List<ActionListener> getListenerList_PlayPage() {
        return new ArrayList<>() {{
            add(getHeaderListener());
        }};
    }

    private @NotNull ActionListener getHeaderListener() {
        return null;//new HeaderButtonListener(this);
    }
}