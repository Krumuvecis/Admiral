package graphics.normalMode.playPage;

import java.awt.event.KeyEvent;

import org.jetbrains.annotations.NotNull;

import ThreadAbstraction.AbstractUpdater;

import graphics2.Observer;

import graphics.normalMode.NormalWindow;

//TODO: add javadocs
public class ObserverKeyboardChecker extends AbstractUpdater {
    private static final int CHECK_DELAY = 20; //in milliseconds
    private final @NotNull NormalWindow window;
    private final @NotNull Observer observer;

    //TODO: add javadoc
    public ObserverKeyboardChecker(@NotNull NormalWindow window,
                                   @NotNull Observer observer) {
        super(CHECK_DELAY);
        this.window = window;
        this.observer = observer;
    }

    /**
     * Gets called when thread runs.
     */
    @Override
    public void update() {
        if (window.getActivePage() instanceof PlayPage) {
            for (int keyCode : window.getPressedKeys()) {
                keyCheck(keyCode);
            }
        }
    }

    @SuppressWarnings("RedundantLabeledSwitchRuleCodeBlock")
    private void keyCheck(int keyCode) {
        String key = KeyEvent.getKeyText(keyCode);
        switch (key) {
            case "A", "Left" -> {
                observer.location.move(Observer.MovementDirection.LEFT);
            }
            case "D", "Right" -> {
                observer.location.move(Observer.MovementDirection.RIGHT);
            }
            case "W", "Up" -> {
                observer.location.move(Observer.MovementDirection.UP);
            }
            case "S", "Down" -> {
                observer.location.move(Observer.MovementDirection.DOWN);
            }
            default -> {}
        }
    }
}