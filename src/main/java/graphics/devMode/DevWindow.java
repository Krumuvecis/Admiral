package graphics.devMode;

import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;

import graphicsEngine.windows.AbstractPage;
import graphicsEngine.windows.WindowManager;

import graphicsEngineExtension.KeyboardListener;

import graphics.common.Window;

/**
 * The window for this application
 * TODO: finish javadocs
 */
public class DevWindow extends Window {
    public KeyboardListener keyboardListener;
    /**
     * For determining the "enabled" state of non-overlay listeners
     */
    public boolean pageListenersEnabled;

    //TODO: add javadoc
    public DevWindow(@NotNull WindowManager windowManager) {
        super(windowManager);
        //TODO: return back to starting page after testing
        //setActivePage(StartingPage.getStaticPageKey());
        //setActivePage(PlayPage.getStaticPageKey());

        //setOverlay(new MenuOverlay(new OverlayButtonListener(this)));
    }

    /**
     * For multi-window purposes.
     *
     * @return The key of this window.
     */
    @Override
    public final @NotNull String getWindowKey() {
        return "devWindow";
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