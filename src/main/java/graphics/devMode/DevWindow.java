package graphics.devMode;

import java.util.List;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

import graphicsEngine.windows.WindowManager;
import graphicsEngine.pages.AbstractPage;

import graphics.common.CommonWindow;
import graphics.devMode.selectionPage.SelectionPage;
import graphics.devMode.page1.Page1;
import graphics.devMode.page0_template.Page0;

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
            add(new SelectionPage(window));
            add(new Page1(window));
            //add more pages here
            add(new Page0(window)); //template
        }};
    }
}