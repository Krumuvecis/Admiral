package cells;

import staticData.StaticData;

import ThreadAbstraction.AbstractUpdater;

import org.jetbrains.annotations.NotNull;

/**
 * TODO: add javadocs
 */
class CellUpdater extends AbstractUpdater {
    private static final int DELAY = 50;
    private final @NotNull AbstractCellCycler
            windCalculator,
            pressureCalculator,
            pressureRefresher;

    //
    public CellUpdater(@NotNull CellContainer cellContainer) {
        super(DELAY);
        windCalculator = new WindCalculator(cellContainer);
        pressureCalculator = new PressureCalculator(cellContainer);
        pressureRefresher = new PressureRefresher(cellContainer);
    }

    /**
     * TODO: add javadoc
     */
    @Override
    public void update() {
        if(!StaticData.pause) {
            barokinesis();
        }
    }

    private void barokinesis() {
        windCalculator.cycleCells();
        pressureCalculator.cycleCells();
        pressureRefresher.cycleCells();
    }
}