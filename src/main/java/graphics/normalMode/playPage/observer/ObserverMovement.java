package graphics.normalMode.playPage.observer;

import org.jetbrains.annotations.NotNull;

//TODO: finish this and add javadocs
public class ObserverMovement {
    private final @NotNull Observer observer;

    ObserverMovement(@NotNull Observer observer) {
        this.observer = observer;
    }

    void moveObserver(MovementDirection direction) {
        switch (direction) {
            case RIGHT -> {
                observer.observerPos[0] += getMovementAmount();
            }
            case LEFT -> {
                observer.observerPos[0] -= getMovementAmount();
            }
            case DOWN -> {
                observer.observerPos[1] += getMovementAmount();
            }
            case UP -> {
                observer.observerPos[1] -= getMovementAmount();
            }
            default -> {}
        }
    }

    int getMovementAmount() {
        int velocity = 2;
        return velocity * observer.zoom;
    }

    enum MovementDirection {
        RIGHT,
        LEFT,
        DOWN,
        UP
    }
}