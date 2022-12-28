package graphics.normalMode.playPage;

import org.jetbrains.annotations.NotNull;

import graphicsEngineExtension.windows.ExtendedLayeredWindow;
import graphicsEngineExtension.input.keyboard.ExtendedKeyboardChecker;

import graphics2.OrthogonalDirection;
import graphics2.Observer;

//TODO: add javadocs
public class KeyboardActions extends ExtendedKeyboardChecker {
    private final @NotNull Observer observer;

    //TODO: add javadoc
    public KeyboardActions(@NotNull ExtendedLayeredWindow window,
                           @NotNull Observer observer) {
        super(window, PlayPage.class);
        this.observer = observer;
    }

    @SuppressWarnings("RedundantLabeledSwitchRuleCodeBlock")
    @Override
    public void keyCheck(@NotNull String key) {
        switch (key) {
            case "A", "Left" -> {
                observer.location.move(OrthogonalDirection.WEST);
            }
            case "D", "Right" -> {
                observer.location.move(OrthogonalDirection.EAST);
            }
            case "W", "Up" -> {
                observer.location.move(OrthogonalDirection.NORTH);
            }
            case "S", "Down" -> {
                observer.location.move(OrthogonalDirection.SOUTH);
            }
            default -> {}
        }
    }
}