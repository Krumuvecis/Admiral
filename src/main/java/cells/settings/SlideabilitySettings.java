package cells.settings;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public class SlideabilitySettings {
    private final double @NotNull [] range = new double[2];

    //TODO: add javadoc
    SlideabilitySettings(double min, double max) {
        try {
            setRange(min, max);
        } catch (IncorrectRangeException e) {
            e.printStackTrace();
        }
    }

    private void setRange(double min, double max) throws IncorrectRangeException {
        if (min > max) {
            throw new IncorrectRangeException();
        } else {
            range[0] = min;
            range[1] = max;
        }
    }

    //TODO: add javadoc
    public double @NotNull [] getRange() {
        return range;
    }

    private static class IncorrectRangeException extends Exception {
        private IncorrectRangeException() {
            super("Incorrect slideable variable range: minimum greater than maximum.");
        }
    }
}