package cells;

import org.jetbrains.annotations.NotNull;

/**
 * TODO: add javadocs
 */
abstract class AbstractCellCycler {
    private final @NotNull CellContainer cells;

    //
    AbstractCellCycler(@NotNull CellContainer cells) {
        this.cells = cells;
    }

    /**
     * Cycles through all the cells.
     */
    final void cycleCells() {
        int @NotNull [] cellCount = cells.getCellCount();
        for (int i = 0; i < cellCount[0]; i++) {
            for (int j = 0; j < cellCount[1]; j++) {
                singleCellAction(cells, i, j);
            }
        }
    }

    /**
     * An action to be performed upon each cell during a cycle.
     *
     * @param cells Cell container to use.
     * @param x     Cell's x coordinate.
     * @param y     Cell's y coordinate.
     */
    abstract void singleCellAction(@NotNull CellContainer cells,
                                   int x, int y);
}