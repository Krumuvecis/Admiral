package cells;

import staticData.StaticData;

import ThreadAbstraction.AbstractUpdater;

import org.jetbrains.annotations.NotNull;

/**
 *
 */
class CellUpdater extends AbstractUpdater {
    private static final int DELAY = 50;
    private static final double
            inertiaFactor = 10, // inertia of medium (must be greater than 1; otherwise self-induces)
            pressureToWindCoefficient = 1, // relative wind coefficient
            windToPressureCoefficient = 1 / pressureToWindCoefficient / inertiaFactor; // don't change this!
    private final @NotNull AbstractCellCycler
            windCalculator,
            pressureCalculator,
            pressureRefresher;

    /**
     *
     * @param cellContainer
     */
    public CellUpdater(@NotNull CellContainer cellContainer) {
        super(DELAY);
        windCalculator = new WindCalculator(cellContainer, pressureToWindCoefficient);
        pressureCalculator = new PressureCalculator(cellContainer, windToPressureCoefficient);
        pressureRefresher = new PressureRefresher(cellContainer);
    }

    /**
     *
     */
    @Override
    public void update() {
        if(!StaticData.pause) {
            windCalculator.cycleCells();
            pressureCalculator.cycleCells();
            pressureRefresher.cycleCells();
        }
    }
}