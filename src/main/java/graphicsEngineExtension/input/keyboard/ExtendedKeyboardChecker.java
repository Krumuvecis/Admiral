package graphicsEngineExtension.input.keyboard;

import org.jetbrains.annotations.NotNull;

import graphicsEngine.pages.AbstractPage;

import graphicsEngineExtension.windows.ExtendedLayeredWindow;

//TODO: add javadocs
public abstract class ExtendedKeyboardChecker extends KeyboardChecker {
    private final @NotNull Class<? extends AbstractPage> pageClass;

    //
    public ExtendedKeyboardChecker(@NotNull ExtendedLayeredWindow window,
                                   @NotNull Class<? extends AbstractPage> checkablePageClass) {
        super(window);
        pageClass = checkablePageClass;
    }

    private @NotNull ExtendedLayeredWindow getExtendedLayeredWindow() {
        return (ExtendedLayeredWindow) getKeyboardListenableWindow();
    }

    //
    @Override
    public boolean getCheckerActiveState() {
        @NotNull ExtendedLayeredWindow window = getExtendedLayeredWindow();
        return window.pageListenersEnabled && pageClass.isInstance(window.getActivePage());
    }
}