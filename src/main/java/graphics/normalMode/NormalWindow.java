package graphics.normalMode;

import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;

import graphicsEngine.windows.WindowManager;
import graphicsEngine.windows.AbstractPage;

import graphicsEngineExtension.KeyboardListener;

import graphics.common.Window;
import graphics.normalMode.common.MenuOverlay;
import graphics.normalMode.common.OverlayButtonListener;
import graphics.normalMode.common.header.HeaderButtonListener;
import graphics.normalMode.playPage.PlayPage;
import graphics.normalMode.startingPage.StartingPage;

/**
 * The window for this application
 * TODO: finish javadocs
 */
public class NormalWindow extends Window {
    public KeyboardListener keyboardListener;
    /**
     * For determining the "enabled" state of non-overlay listeners
     */
    public boolean pageListenersEnabled;

    //TODO: add javadoc
    public NormalWindow(@NotNull WindowManager windowManager) {
        super(windowManager);
        //TODO: return back to starting page after testing
        //setActivePage(StartingPage.getStaticPageKey());
        setActivePage(PlayPage.getStaticPageKey());

        setOverlay(new MenuOverlay(new OverlayButtonListener(this)));
    }

    /**
     * For multi-window purposes.
     *
     * @return The key of this window.
     */
    @Override
    public final @NotNull String getWindowKey() {
        return "normalWindow";
    }

    /**
     * TODO: finish this
     * @return
     */
    @Override
    public @NotNull List<AbstractPage> getInitialPages() {
        NormalWindow window = this;
        return new ArrayList<>() {{
            add(new StartingPage(window, getListenerList_StartingPage(), null));
            add(new PlayPage(window, getListenerList_PlayPage(), null));
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
        return new HeaderButtonListener(this);
    }
}