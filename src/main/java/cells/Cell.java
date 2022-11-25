package cells;

/**
 * TODO: finish this javadoc
 */
public class Cell {
    public static final double //TODO: get rid of these parameters
            PRESSURE_MAX = 20, //used in randomization and initial cells
            WIND_MAX = 50; //unused
    private static final double
            pressureDampeningFactor = 0.07; // changeable

    private double
            pressure, //actual pressure
            newPressure; //buffer for calculations

    /**
     * Wind parameters.
     * TODO:
     *  make private
     *  make getters and setters
     */
    public double
            windAmount, //magnitude
            windDirection; //angle in radians

    /**
     * Creates a new cell.
     */
    public Cell() {
        pressure = 0;
        newPressure = 0;
        windAmount = 0;
        windDirection = 0;
    }

    /**
     * Gets the actual pressure of this cell.
     *
     * @return Actual pressure.
     */
    public double getPressure() {
        return pressure;
    }

    /**
     * Sets the temporary pressure of this cell.
     *
     * @param pressure The new pressure.
     */
    void setPressure(double pressure) {
        newPressure = pressure;
    }

    /**
     * Increases the temporary pressure of this cell by delta.
     *
     * @param delta Delta.
     */
    void increasePressure(double delta) {
        newPressure += delta;
    }

    /**
     * Dampens the temporary pressure of this cell.
     */
    void dampenPressure() {
        newPressure = newPressure * (1 - pressureDampeningFactor);
    }

    /**
     * Sets the actual pressure the same as the temporary pressure for this cell.
     */
    void updatePressure() {
        pressure = newPressure;
    }
}