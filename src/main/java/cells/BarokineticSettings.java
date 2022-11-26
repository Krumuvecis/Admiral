package cells;

public class BarokineticSettings {
    double
            inertiaFactor, // inertia of medium (must be greater than 1; otherwise self-induces)
            pressureToWindCoefficient, // relative wind coefficient
            windToPressureCoefficient;

    BarokineticSettings() {
        inertiaFactor = 100;
        pressureToWindCoefficient = 0.01;
        windToPressureCoefficient = 1 / pressureToWindCoefficient / inertiaFactor; // don't change this!
    }
}