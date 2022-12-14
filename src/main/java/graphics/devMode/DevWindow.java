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
import graphics.devMode.page1.Page1;

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
    public @NotNull List<AbstractPage> getInitialPages() {
        DevWindow window = this;
        return new ArrayList<>() {{
            add(new SelectionPage(window, getListenerList_SelectionPage(), null));
            add(new Page1(window, getListenerList_Page1(), null));
        }};
    }

    private @NotNull List<ActionListener> getListenerList_SelectionPage() {
        return new ArrayList<>() {{
            add(getHeaderListener());
        }};
    }

    private @NotNull List<ActionListener> getListenerList_Page1() {
        return new ArrayList<>() {{
            add(getHeaderListener());
        }};
    }

    private @NotNull ActionListener getHeaderListener() {
        return new HeaderButtonListener(this);
    }
}