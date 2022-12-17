package graphicsEngineExtension.sliders.panelless;

/**
 * TODO: finish javadocs
 */
interface TickValueConvertible {
    /**
     * prepares variables for tick-value conversion
     * TODO: finish this javadoc; maybe rename method
     *
     * @param majorTickCount
     * @param minorTickCount
     */
    void setConversionConstants(int majorTickCount, int minorTickCount);

    /**
     * TODO: finish this javadoc
     */
    int getTickFromValue(double value);

    /**
     * TODO: finish this javadoc
     */
    double getValueFromTick(int tick);

    /**
     * Performed upon changing the value.
     *
     * @param value The new value.
     */
    void valueChanged(double value);
}