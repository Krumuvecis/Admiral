package cells;

public class Cell {
    public static final double
            PRESSURE_MAX = 20,
            WIND_MAX = 50;

    public double
            pressure,
            newPressure,
            windAmount,
            windDirection;

    public Cell() {
        pressure = 0;
        newPressure = 0;
        windAmount = 0;
        windDirection = 0;
    }
}