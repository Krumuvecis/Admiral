package cells;

import java.util.Random;

import org.jetbrains.annotations.NotNull;

/**
 * TODO: add javadocs
 */
class PressureCalculator extends AbstractCellCycler {
    private static final @NotNull Random RANDOM = new Random();
    private final @NotNull BarokineticSettings barokineticSettings;

    //
    PressureCalculator(@NotNull CellContainer cells) {
        super(cells);
        this.barokineticSettings = cells.barokineticSettings;
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
                magnitude = cell.windAmount,
                windToPressureCoefficient = barokineticSettings.getWindToPressureCoefficient();

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
                        particularPressureChange = distanceCorrectedProjection * windToPressureCoefficient;

                cell.increasePressure(-particularPressureChange);
                neighbour.increasePressure(particularPressureChange);
            }
        }
        cell.dampenPressure();
        randomizePressure(cell);
    }

    private void randomizePressure(Cell cell) {
        if (barokineticSettings.randomizePressures
                && RANDOM.nextDouble() < barokineticSettings.pressureSuddenChangeChance) {
            double newPressure = barokineticSettings.pressureMaxMagnitudeChange;
            if (RANDOM.nextBoolean()) {
                cell.setPressure(newPressure);
            } else {
                cell.setPressure(-newPressure);
            }
        }
    }
}