package graphics2;

import org.jetbrains.annotations.NotNull;

import graphicsEngine.pages.AbstractPage;

import graphicsEngineExtension.windows.ExtendedLayeredWindow;
import graphicsEngineExtension.input.keyboard.ExtendedKeyboardChecker;

//TODO: add javadocs
public class CommonObserverKeyboardActions extends ExtendedKeyboardChecker {
    private final @NotNull Observer observer;

    //TODO: add javadoc
    public CommonObserverKeyboardActions(@NotNull ExtendedLayeredWindow window,
                                         @NotNull Class<? extends AbstractPage> checkablePageClass,
                                         @NotNull Observer observer) {
        super(window, checkablePageClass);
        this.observer = observer;
    }

    public final @NotNull Observer getObserver() {
        return observer;
    }

    @Override
    public void keyCheck(@NotNull String key) {
        switch (key) {
            case "A", "Left" ->moveObserver(OrthogonalDirection.WEST);
            case "D", "Right" -> moveObserver(OrthogonalDirection.EAST);
            case "W", "Up" -> moveObserver(OrthogonalDirection.NORTH);
            case "S", "Down" -> moveObserver(OrthogonalDirection.SOUTH);
            default -> {}
        }
    }

    private void moveObserver(@NotNull OrthogonalDirection direction) {
        getObserver().location.move(direction);
    }
}