package cells;

import java.util.Random;

import org.jetbrains.annotations.NotNull;

/**
 * TODO: add javadocs
 */
class PressureCalculator extends AbstractCellCycler {
    private static final @NotNull Random RANDOM = new Random();
    private static final double suddenChangeChance = 0.00002; // changeable

    private final @NotNull BarokineticSettings barokineticSettings;

    @SuppressWarnings("FieldCanBeLocal")
    private final boolean randomizePressures = true;

    //
    PressureCalculator(@NotNull CellContainer cells,
                       @NotNull BarokineticSettings barokineticSettings) {
        super(cells);
        this.barokineticSettings = barokineticSettings;
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
        @NotNull Cell cell = cells.getCell(x, y);
        double
                windAngle = cell.windDirection,
                magnitude = cell.windAmount;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                @NotNull Cell neighbour = cells.getCell(x + i, y + j);
                double
                        neighbourAngle = mathUtils.Trigonometry.getAngle(i, j),
                        windProjectionOnNeighbour = magnitude * Math.cos(neighbourAngle - windAngle),
                        distanceCorrectedProjection = windProjectionOnNeighbour / Math.hypot(i, j),
                        particularPressureChange = distanceCorrectedProjection * barokineticSettings.windToPressureCoefficient;

                cell.increasePressure(-particularPressureChange);
                neighbour.increasePressure(particularPressureChange);
            }
        }
        cell.dampenPressure();
        //randomizePressure(cell);
    }

    private void randomizePressure(Cell cell) {
        if (randomizePressures
                && RANDOM.nextDouble() < suddenChangeChance) {
            if (RANDOM.nextBoolean()) {
                cell.setPressure(Cell.PRESSURE_MAX);
            } else {
                cell.setPressure(-Cell.PRESSURE_MAX);
            }
        }
    }
}