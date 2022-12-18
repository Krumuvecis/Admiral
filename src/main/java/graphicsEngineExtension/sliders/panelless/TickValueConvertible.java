package graphicsEngineExtension.sliders.panelless;

/**
 * An interface containing methods needed for tick-value conversion.
 */
interface TickValueConvertible {
    /**
     * Prepares variables for tick-value conversion.
     *
     * @param majorTickCount Number of major ticks. (excludes start; has to be greater than 1)
     * @param minorTickCount Number of minor ticks between major ticks. (has to be greater than 1)
     */
    void setConversionConstants(int majorTickCount, int minorTickCount);

    /**
     * Gets the closest tick to a particular value.
     *
     * @param value Reference value.
     *
     * @return Closest tick number.
     */
    int getTickFromValue(double value);

    /**
     * Gets a value corresponding to a tick.
     *
     * @param tick Reference tick number.
     *
     * @return Corresponding value.
     */
    double getValueFromTick(int tick);

    /**
     * Performed upon changing the value.
     *
     * @param value The new value.
     */
    void valueChanged(double value);
}