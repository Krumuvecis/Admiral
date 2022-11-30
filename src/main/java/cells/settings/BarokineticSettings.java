package cells.settings;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public class BarokineticSettings {
    private final @NotNull SlidableValue
            inertiaFactor, // inertia of medium (must be greater than 1; otherwise self-induces)
            pressureToWindCoefficient; // relative wind coefficient
    private double windToPressureCoefficient;

    //Wind randomization settings
    public double
            windSuddenChangeChance = 0.00002,
            windMaxMagnitudeChange = 5;
    public boolean randomizeWinds = true;

    //Pressure randomization settings
    public double
            pressureSuddenChangeChance = 0.00002,
            pressureMaxMagnitudeChange = 20;
    public boolean randomizePressures = false;

    //
    public BarokineticSettings() {
        inertiaFactor = new SlidableValue(10, 100, 100);
        pressureToWindCoefficient = new SlidableValue(0.01, 10, 0.01);
        setWindToPressureCoefficient();
    }

    //
    public double getInertiaFactor() {
        return inertiaFactor.getValue();
    }

    //
    public double @NotNull [] getInertiaFactorRange() {
        return inertiaFactor.getRange();
    }

    //
    public void setInertiaFactor(double inertiaFactor) {
        this.inertiaFactor.setValue(inertiaFactor);
        setWindToPressureCoefficient();
    }

    //
    public double getPressureToWindCoefficient() {
        return pressureToWindCoefficient.getValue();
    }

    //
    public double @NotNull [] getPressureToWindCoefficientRange() {
        return pressureToWindCoefficient.getRange();
    }

    //
    public void setPressureToWindCoefficient(double coefficient) {
        pressureToWindCoefficient.setValue(coefficient);
        setWindToPressureCoefficient();
    }

    //
    public double getWindToPressureCoefficient() {
        return windToPressureCoefficient;
    }

    // don't change this manually!
    private void setWindToPressureCoefficient() {
        double divisor = getPressureToWindCoefficient() * getInertiaFactor();
        windToPressureCoefficient = 1 / divisor;
    }
}