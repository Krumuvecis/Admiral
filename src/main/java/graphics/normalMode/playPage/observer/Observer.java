package graphics.normalMode.playPage.observer;

import org.jetbrains.annotations.NotNull;

import cells.CellContainer;

import graphics.normalMode.NormalWindow;

//TODO: add javadocs
public class Observer {
    public static final int[] ZOOM_LIMITS = new int[] {1, 10};
    public static final int
            INITIAL_ZOOM = 4,
            ZOOM_INCREMENT = 1;
    public final int @NotNull []
            mousePos = new int[2],
            observerPos = getInitialObserverPos();
    public int zoom = INITIAL_ZOOM;
    public final @NotNull ObserverMovement movement;

    //TODO: add javadoc
    public Observer(NormalWindow window) {
        movement = new ObserverMovement(this);
        new ObserverKeyboardChecker(window, this).start();
    }

    private int @NotNull [] getInitialObserverPos() {
        int @NotNull [] fieldSize = CellContainer.fieldSize;
        return new int[] {
                fieldSize[0] / 2,
                fieldSize[1] / 2};
    }
}