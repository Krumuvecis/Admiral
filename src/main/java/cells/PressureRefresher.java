package cells;

import org.jetbrains.annotations.NotNull;

//
class PressureRefresher extends AbstractCellCycler {
    //

    PressureRefresher(@NotNull CellContainer cells) {
        super(cells);
    }

    /**
     * An action to be performed upon each cell during a cycle.
     *
     * @param cells Cell container to use.
     * @param x     Cell's x coordinate.
     * @param y     Cell's y coordinate.
     */
    @Override
    void singleCellAction(@NotNull CellContainer cells, int x, int y) {
        cells.getCell(x, y).updatePressure();
    }
}