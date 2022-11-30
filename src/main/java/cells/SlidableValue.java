package cells;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public class SlidableValue {
    private final double @NotNull [] range = new double[2];
    private double value;

    SlidableValue(double min, double max, double initial) {
        try {
            setRange(min, max);
            setValue(initial);
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

    public void setValue(double value) {
        //defaults to lower bound, if out of range
        this.value = Math.min(range[1], Math.max(range[0], value));
    }

    public double getValue() {
        return value;
    }

    public static class IncorrectRangeException extends Exception {
        private IncorrectRangeException() {
            super("Incorrect slidable variable range: minimum greater than maximum.");
        }
    }
}