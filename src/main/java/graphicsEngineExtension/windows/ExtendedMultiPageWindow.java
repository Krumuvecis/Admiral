package graphicsEngineExtension.windows;

import java.util.List;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.windows.WindowConfig;
import graphicsEngine.windows.WindowManager;
import graphicsEngine.presets.SimpleOverlay;

/**
 * TODO:
 *      move keyboardListener to higher level of abstraction
 *      extend this from MultiPageWindow
 *      add javadocs where needed
 */
public abstract class ExtendedMultiPageWindow extends ExtendedLayeredWindow  {
    private final @Nullable String mainPageKey;

    //TODO: add javadoc
    public ExtendedMultiPageWindow(@NotNull WindowManager windowManager,
                                   @NotNull WindowConfig config,
                                   @Nullable List<ActionListener> actionListenerList,
                                   @Nullable SimpleOverlay overlay,
                                   @Nullable String mainPageKey) {
        super(
                windowManager,
                config,
                actionListenerList,
                overlay);
        // icon paths don't work after graphicsEngine compilation! TODO: fix
        //setIcon(graphicsEngine.Utilities.getSampleIcon());
        this.mainPageKey = mainPageKey;
        switchToMainPage();
    }

    //TODO: add javadoc
    @Override
    public final void setActivePage(@Nullable String key) {
        super.setActivePage(key);
        hideOverlay();
    }

    //TODO: add javadoc
    public final void switchToMainPage() {
        setActivePage(mainPageKey);
    }
}