package cells;

import org.jetbrains.annotations.NotNull;

import cells.settings.BarokineticSettings;

/**
 * TODO: finish this javadoc
 */
public class Cell {
    private final @NotNull BarokineticSettings barokineticSettings;
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
     *
     * @param barokineticSettings Barokinetic settings.
     */
    public Cell(@NotNull BarokineticSettings barokineticSettings) {
        this.barokineticSettings = barokineticSettings;
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
        newPressure = newPressure * (1 - barokineticSettings.pressureDampeningFactor);
    }

    /**
     * Sets the actual pressure the same as the temporary pressure for this cell.
     */
    void updatePressure() {
        pressure = newPressure;
    }

    static double @NotNull [] getWindProjections(double magnitude, double angle) {
        return new double[] {
                magnitude * Math.cos(angle),
                magnitude * Math.sin(angle)};
    }

    //
    void increaseWind(double @NotNull [] deltaProjections) {
        double @NotNull [] oldWind = getWindProjections(windAmount, windDirection);
        setWind(new double[] {
                oldWind[0] + deltaProjections[0],
                oldWind[1] + deltaProjections[1]});
    }

    private void setWind(double @NotNull [] projections) {
        windAmount = Math.hypot(projections[0], projections[1]);
        windDirection = mathUtils.Trigonometry.getAngle(projections[0], projections[1]);
    }

    //
    void dampenWind() {
        windAmount = windAmount * (1 - barokineticSettings.windDampeningFactor);
    }
}