package graphics.normalMode.playPage;

import org.jetbrains.annotations.NotNull;

import graphicsEngine.pages.AbstractPage;

import graphicsEngineExtension.windows.ExtendedLayeredWindow;

import graphics2.Observer;
import graphics2.CommonObserverKeyboardActions;

//TODO: add javadocs
public class KeyboardActions extends CommonObserverKeyboardActions {
    private static final @NotNull Class<? extends AbstractPage> CHECKABLE_PAGE_CLASS = PlayPage.class;

    //TODO: add javadoc
    public KeyboardActions(@NotNull ExtendedLayeredWindow window,
                           @NotNull Observer observer) {
        super(window, CHECKABLE_PAGE_CLASS, observer);
    }

    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    @Override
    public void keyCheck(@NotNull String key) {
        switch (key) {
            //add specific key actions here
            default -> super.keyCheck(key);
        }
    }
}