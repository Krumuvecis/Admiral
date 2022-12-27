package graphics.devMode;

import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;

import graphicsEngine.windows.AbstractPage;
import graphicsEngine.windows.WindowManager;

import graphics.common.CommonWindow;
import graphics.devMode.common.header.HeaderButtonListener;
import graphics.devMode.selectionPage.SelectionPage;
import graphics.devMode.selectionPage.buttons.SelectionPageButtonListener;
import graphics.devMode.page1.Page1;
import graphics.devMode.page2.Page2;

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
        super(
                windowManager, "dev mode",
                STARTING_SIZE, STARTING_LOCATION,
                SelectionPage.getStaticPageKey());
    }

    /**
     * TODO: finish this
     * @return
     */
    @Override
    public final @NotNull List<AbstractPage> getInitialPages() {
        @NotNull CommonWindow window = this;
        return new ArrayList<>() {{
            add(new SelectionPage(window, getListenerList_SelectionPage(window), null));
            add(new Page1(window, getListenerList_Page1(window), null));
            add(new Page2(window, getListenerList_Page2(window), null));
        }};
    }

    private @NotNull List<ActionListener> getListenerList_SelectionPage(@NotNull CommonWindow window) {
        return new ArrayList<>() {{
            add(new SelectionPageButtonListener(window));
        }};
    }

    private @NotNull List<ActionListener> getListenerList_Page1(@NotNull CommonWindow window) {
        return new ArrayList<>() {{
            add(getHeaderListener(window));
        }};
    }

    private @NotNull List<ActionListener> getListenerList_Page2(@NotNull CommonWindow window) {
        return new ArrayList<>() {{
            add(getHeaderListener(window));
        }};
    }

    private @NotNull ActionListener getHeaderListener(@NotNull CommonWindow window) {
        return new HeaderButtonListener(window);
    }
}