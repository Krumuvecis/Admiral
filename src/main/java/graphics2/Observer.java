package graphics2;

import java.util.Arrays;

import org.jetbrains.annotations.NotNull;

import cells.CellContainer;

//TODO: finish this and add javadocs
public class Observer {
    public final @NotNull ObserverZoom zoom;
    public final @NotNull ObserverLocation location;
    public final int @NotNull [] mousePos = new int[2];

    //
    public Observer() {
        zoom = new ObserverZoom();
        location = new ObserverLocation(zoom);
    }

    //
    public enum MovementDirection {
        RIGHT,
        LEFT,
        DOWN,
        UP
    }

    //
    public static class ObserverLocation {
        private final int @NotNull [] location = new int[2];
        private static final int VELOCITY_UNSCALED = 2;
        private final @NotNull ObserverZoom zoomInfo;

        private ObserverLocation(@NotNull ObserverZoom zoomInfo) {
            setLocation(getInitialLocation());
            this.zoomInfo = zoomInfo;
        }

        private void setLocation(int @NotNull [] location) {
            this.location[0] = location[0];
            this.location[1] = location[1];
        }

        private int @NotNull [] getInitialLocation() {
            int @NotNull [] fieldSize = CellContainer.fieldSize;
            return new int[] {
                    fieldSize[0] / 2,
                    fieldSize[1] / 2};
        }

        //
        public int @NotNull [] getLocation() {
            return Arrays.copyOf(location, 2);
        }

        //
        @SuppressWarnings("RedundantLabeledSwitchRuleCodeBlock")
        public void move(@NotNull MovementDirection direction) {
            switch (direction) {
                case RIGHT -> {
                    location[0] += getMovementAmount();
                }
                case LEFT -> {
                    location[0] -= getMovementAmount();
                }
                case DOWN -> {
                    location[1] += getMovementAmount();
                }
                case UP -> {
                    location[1] -= getMovementAmount();
                }
                default -> {}
            }
        }

        private int getMovementAmount() {
            return VELOCITY_UNSCALED * zoomInfo.getZoom();
        }
    }

    public static class ObserverZoom {
        public static final int @NotNull [] ZOOM_LIMITS = new int[] {1, 10};
        private static final int
                INITIAL_ZOOM = 4,
                ZOOM_INCREMENT = 1;
        private int zoom;

        private ObserverZoom() {
            setZoom(INITIAL_ZOOM);
        }

        private void setZoom(int zoom) {
            this.zoom = Math.max(ZOOM_LIMITS[0], Math.min(ZOOM_LIMITS[1], zoom));
        }

        //
        public void adjustZoom(int relativeAmount) {
            setZoom(getZoom() + ZOOM_INCREMENT * relativeAmount);
        }

        //
        public int getZoom() {
            return zoom;
        }
    }
}