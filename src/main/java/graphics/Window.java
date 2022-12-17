package graphics;

import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.windows.WindowConfig;
import graphicsEngine.windows.WindowManager;
import graphicsEngine.windows.windowTypes.MultiPageWindow;
import graphicsEngine.windows.AbstractPage;

import graphicsEngineExtension.KeyboardListener;

import graphics.common.MenuOverlay;
import graphics.common.OverlayButtonListener;
import graphics.common.HeaderButtonListener;
import graphics.playPage.PlayPage;
import graphics.startingPage.StartingPage;

/**
 * The window for this application
 * TODO: finish javadocs
 */
public class Window extends MultiPageWindow {
    public KeyboardListener keyboardListener;
    /**
     * For determining the "enabled" state of non-overlay listeners
     */
    public boolean pageListenersEnabled;

    //TODO: add javadoc
    public Window(@NotNull WindowManager windowManager) {
        super(windowManager, config(), null, null);
        keyboardListener = new KeyboardListener();
        addKeyListener(keyboardListener);
        setPageListenersEnabled(true);
        //TODO: return back to starting page after testing
        //setActivePage(StartingPage.getStaticPageKey());
        setActivePage(PlayPage.getStaticPageKey());
        setIcon(graphicsEngine.Utilities.getSampleIcon());

        setOverlay(new MenuOverlay(new OverlayButtonListener(this)));
    }

    /**
     * Hardcoded configuration of a new Window object.
     *
     * @return Window configuration.
     */
    private static @NotNull WindowConfig config() {
        String title = "Admiral";
        int[]
                size = new int[] {1000, 600},
                location = new int[] {200, 30};
        WindowConfig config = new WindowConfig(title, size, location);
        config.closeOperation = EXIT_ON_CLOSE;
        return config;
    }

    /**
     * For multi-window purposes.
     *
     * @return The key of this window.
     */
    @Override
    public final @NotNull String getWindowKey() {
        return "window";
    }

    private void setPageListenersEnabled(boolean state) {
        pageListenersEnabled = state;
    }

    private void togglePageListenersEnabled() {
       setPageListenersEnabled(!pageListenersEnabled);
    }

    /**
     * TODO: finish this
     * @return
     */
    @Override
    public @NotNull List<AbstractPage> getInitialPages() {
        Window window = this;
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

    //TODO: add javadoc
    @Override
    public void setActivePage(@Nullable String key) {
        super.setActivePage(key);
        hideOverlay();
    }

    //TODO: add javadoc
    @Override
    public void showOverlay() {
        setPageListenersEnabled(false);
        super.showOverlay();
    }

    //TODO: add javadoc
    @Override
    public void hideOverlay() {
        super.hideOverlay();
        setPageListenersEnabled(true);
    }

    //TODO: add javadoc
    @Override
    public void toggleOverlay() {
        togglePageListenersEnabled();
        super.toggleOverlay();
    }
}