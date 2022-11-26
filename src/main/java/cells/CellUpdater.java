package cells;

import staticData.StaticData;

import ThreadAbstraction.AbstractUpdater;

import org.jetbrains.annotations.NotNull;

/**
 * TODO: add javadocs
 */
class CellUpdater extends AbstractUpdater {
    private static final int DELAY = 50;
    private final @NotNull BarokineticSettings barokineticSettings;
    private final @NotNull AbstractCellCycler
            windCalculator,
            pressureCalculator,
            pressureRefresher;

    //
    public CellUpdater(@NotNull CellContainer cellContainer) {
        super(DELAY);
        barokineticSettings = new BarokineticSettings();
        windCalculator = new WindCalculator(cellContainer, barokineticSettings);
        pressureCalculator = new PressureCalculator(cellContainer, barokineticSettings);
        pressureRefresher = new PressureRefresher(cellContainer);
    }

    /**
     * TODO: add javadoc
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