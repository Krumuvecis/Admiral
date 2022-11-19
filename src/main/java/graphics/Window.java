package graphics;

import graphics.common.MenuOverlay;
import graphics.common.HeaderButtonListener;
import graphics.playPage.PlayPage;
import graphics.startingPage.StartingPage;

import graphicsEngine.windows.WindowConfig;
import graphicsEngine.windows.WindowManager;
import graphicsEngine.windows.windowTypes.MultiPageWindow;
import graphicsEngine.windows.AbstractPage;

import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadocs
public class Window extends MultiPageWindow {
    public boolean pageListenersEnabled;

    //TODO: add javadoc
    public Window(@NotNull WindowManager windowManager) {
        super(windowManager, config(), null, null);
        setPageListenersEnabled(true);
        setActivePage(StartingPage.getStaticPageKey());
        setIcon(graphicsEngine.Utilities.getSampleIcon());

        setOverlay(new MenuOverlay(null));
    }

    /**
     * Hardcoded configuration of a new Window object.
     *
     * @return Window configuration.
     */
    private static @NotNull WindowConfig config() {
        String title = "Admiral";
        int[]
                size = new int[] {600, 400},
                location = new int[] {50, 50};
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
        return new ArrayList<>() {{
            add(new StartingPage(getHeaderListener(), null));
            add(new PlayPage(getHeaderListener(), null));
        }};
    }

    private @NotNull List<ActionListener> getHeaderListener() {
        Window window = this;
        return new ArrayList<>() {{
            add(new HeaderButtonListener(window));
        }};
    }

    @Override
    public void setActivePage(@Nullable String key) {
        super.setActivePage(key);
        hideOverlay();
    }

    @Override
    public void showOverlay() {
        setPageListenersEnabled(false);
        super.showOverlay();
    }

    @Override
    public void hideOverlay() {
        super.hideOverlay();
        setPageListenersEnabled(true);
    }

    @Override
    public void toggleOverlay() {
        togglePageListenersEnabled();
        super.toggleOverlay();
    }
}