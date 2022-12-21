package graphics.normalMode.playPage.observer;

import java.awt.event.KeyEvent;

import ThreadAbstraction.AbstractUpdater;

import graphics.normalMode.NormalWindow;
import graphics.normalMode.playPage.PlayPage;

//TODO: add javadocs
public class ObserverKeyboardChecker extends AbstractUpdater {
    private static final int CHECK_DELAY = 20; //in milliseconds
    private final NormalWindow window;
    private final Observer observer;

    //TODO: add javadoc
    ObserverKeyboardChecker(NormalWindow window, Observer observer) {
        super(CHECK_DELAY);
        this.window = window;
        this.observer = observer;
    }

    /**
     * Gets called when thread runs.
     */
    @Override
    public void update() {
        if (window != null && window.getActivePage() instanceof PlayPage) {
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
                observer.movement.moveObserver(ObserverMovement.MovementDirection.LEFT);
            }
            case "D", "Right" -> {
                observer.movement.moveObserver(ObserverMovement.MovementDirection.RIGHT);
            }
            case "W", "Up" -> {
                observer.movement.moveObserver(ObserverMovement.MovementDirection.UP);
            }
            case "S", "Down" -> {
                observer.movement.moveObserver(ObserverMovement.MovementDirection.DOWN);
            }
            default -> {}
        }
    }
}