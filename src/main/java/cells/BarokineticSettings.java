package cells;

//TODO: add javadocs
public class BarokineticSettings {
    double
            inertiaFactor, // inertia of medium (must be greater than 1; otherwise self-induces)
            pressureToWindCoefficient, // relative wind coefficient
            windToPressureCoefficient;

    //Wind randomization settings
    double
            windSuddenChangeChance = 0.00002,
            windMaxMagnitudeChange = 5;
    boolean randomizeWinds = true;

    //Pressure randomization settings
    double
            pressureSuddenChangeChance = 0.00002,
            pressureMaxMagnitudeChange = 20;
    boolean randomizePressures = false;

    public BarokineticSettings() {
        inertiaFactor = 100;
        pressureToWindCoefficient = 0.01;
        windToPressureCoefficient = 1 / pressureToWindCoefficient / inertiaFactor; // don't change this!
    }
}