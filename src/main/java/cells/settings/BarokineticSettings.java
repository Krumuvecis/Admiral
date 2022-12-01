package cells.settings;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public class BarokineticSettings {
    private final @NotNull SlidableValue
            inertiaFactor, // inertia of medium (must be greater than 1; otherwise self-induces)
            pressureToWindCoefficient; // relative wind coefficient
    private double windToPressureCoefficient;

    //dampening parameters
    public double
            pressureDampeningFactor = 0.07, // changeable
            windDampeningFactor = 0.01; // changeable

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

    //TODO: add javadoc
    public BarokineticSettings() {
        inertiaFactor = new SlidableValue(1, 100, 100);
        pressureToWindCoefficient = new SlidableValue(0.01, 10, 0.01);
        setWindToPressureCoefficient();
    }

    //TODO: add javadoc
    public double getInertiaFactor() {
        return inertiaFactor.getValue();
    }

    //TODO: add javadoc
    public double @NotNull [] getInertiaFactorRange() {
        return inertiaFactor.getRange();
    }

    //TODO: add javadoc
    public void setInertiaFactor(double inertiaFactor) {
        this.inertiaFactor.setValue(inertiaFactor);
        setWindToPressureCoefficient();
    }

    //TODO: add javadoc
    public double getPressureToWindCoefficient() {
        return pressureToWindCoefficient.getValue();
    }

    //TODO: add javadoc
    public double @NotNull [] getPressureToWindCoefficientRange() {
        return pressureToWindCoefficient.getRange();
    }

    //TODO: add javadoc
    public void setPressureToWindCoefficient(double coefficient) {
        pressureToWindCoefficient.setValue(coefficient);
        setWindToPressureCoefficient();
    }

    //TODO: add javadoc
    public double getWindToPressureCoefficient() {
        return windToPressureCoefficient;
    }

    // don't change this manually!
    private void setWindToPressureCoefficient() {
        double divisor = getPressureToWindCoefficient() * getInertiaFactor();
        windToPressureCoefficient = 1 / divisor;
    }
}