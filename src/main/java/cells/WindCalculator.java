package cells;

import java.util.Random;

import org.jetbrains.annotations.NotNull;

/**
 * TODO: add javadocs
 */
class WindCalculator extends AbstractCellCycler {
    private static final @NotNull Random RANDOM = new Random();
    private static final double ORTHOGONAL_NEIGHBOUR_SUM = 4 * (1 + 1 / Math.sqrt(2));

    private final @NotNull BarokineticSettings barokineticSettings;

    //
    WindCalculator(@NotNull CellContainer cells) {
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
    void singleCellAction(@NotNull CellContainer cells,
                          int x, int y) {
        @NotNull Cell cell = cells.getCell(x, y);
        cell.dampenWind();
        setRandomWind(cell);
        double @NotNull [] totalAdjacentPressureDifference = new double[2];
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                @NotNull Cell neighbour = cells.getCell(x + i, y + j);
                double
                        particularPressureDifference = neighbour.getPressure() - cell.getPressure(),
                        distance = Math.hypot(i, j);
                // "- signum / distance" ensures correct angles in orthogonal cells
                // enables to not use trigonometry
                totalAdjacentPressureDifference[0] -=
                        particularPressureDifference * Math.signum(i) / Math.pow(distance, 2);
                totalAdjacentPressureDifference[1] -=
                        particularPressureDifference * Math.signum(j) / Math.pow(distance, 2);
            }
        }

        double pressureToWindCoefficient = barokineticSettings.getPressureToWindCoefficient();
        cell.increaseWind(new double[] {
                totalAdjacentPressureDifference[0] / ORTHOGONAL_NEIGHBOUR_SUM * pressureToWindCoefficient,
                totalAdjacentPressureDifference[1] / ORTHOGONAL_NEIGHBOUR_SUM * pressureToWindCoefficient});
    }

    private void setRandomWind(@NotNull Cell cell) {
        if (barokineticSettings.randomizeWinds
                && RANDOM.nextDouble() < barokineticSettings.windSuddenChangeChance) {
            cell.increaseWind(getRandomWindProjections());
        }
    }

    private double @NotNull [] getRandomWindProjections() {
        double
                magnitude = barokineticSettings.windMaxMagnitudeChange,
                angle = RANDOM.nextDouble() * Math.PI * 2;
        return Cell.getWindProjections(magnitude, angle);
    }
}