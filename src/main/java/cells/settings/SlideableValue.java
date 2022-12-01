package cells.settings;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
class SlideableValue {
    private final @NotNull SlideabilitySettings slideability;
    private double value;

    SlideableValue(double min, double max, double initial) {
        slideability = new SlideabilitySettings(min, max);
        setValue(initial);
    }

    void setValue(double value) {
        double @NotNull [] range = slideability.getRange();
        //defaults to lower bound, if out of range
        this.value = Math.min(range[1], Math.max(range[0], value));
    }

    double getValue() {
        return value;
    }

    @NotNull SlideabilitySettings getSlideability() {
        return slideability;
    }
}