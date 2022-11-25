package cells;

/**
 *
 */
public class Cell {
    public static final double //TODO: gotta get rid of these parameters
            PRESSURE_MAX = 20, //used in randomization and initial cells
            WIND_MAX = 50; //unused
    private static final double
            pressureDampeningFactor = 0.07; // changeable

    private double
            pressure, //actual pressure
            newPressure; //buffer for calculations

    public double
            windAmount, //magnitude
            windDirection; //angle in radians

    /**
     *
     */
    public Cell() {
        pressure = 0;
        newPressure = 0;
        windAmount = 0;
        windDirection = 0;
    }

    public double getPressure() {
        return pressure;
    }

    void setPressure(double pressure) {
        newPressure = pressure;
    }

    void increasePressure(double delta) {
        newPressure += delta;
    }

    void dampenPressure() {
        newPressure = newPressure * (1 - pressureDampeningFactor);
    }

    void updatePressure() {
        pressure = newPressure;
    }
}