package cells.settings;

import org.jetbrains.annotations.NotNull;

public class SlideabilitySettings {
    private final double @NotNull [] range = new double[2];

    SlideabilitySettings(double min, double max) {
        try {
            setRange(min, max);
        } catch (IncorrectRangeException e) {
            e.printStackTrace();
        }
    }

    void setRange(double min, double max) throws IncorrectRangeException {
        if (min > max) {
            throw new IncorrectRangeException();
        } else {
            range[0] = min;
            range[1] = max;
        }
    }

    public double @NotNull [] getRange() {
        return range;
    }

    static class IncorrectRangeException extends Exception {
        private IncorrectRangeException() {
            super("Incorrect slideable variable range: minimum greater than maximum.");
        }
    }
}
