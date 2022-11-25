package cells;

import java.util.Random;

import org.jetbrains.annotations.NotNull;

/**
 * TODO: add javadocs
 */
class WindCalculator extends AbstractCellCycler {
    private static final @NotNull Random RANDOM = new Random();
    private static final double ORTHOGONAL_NEIGHBOUR_SUM = 4 * (1 + 1 / Math.sqrt(2));

    private final double pressureToWindCoefficient;

    //
    WindCalculator(@NotNull CellContainer cells,
                   double pressureToWindCoefficient) {
        super(cells);
        this.pressureToWindCoefficient = pressureToWindCoefficient;
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
        //windBrake(cell);
        double
                totalAdjacentPressureDifferenceX = 0,
                totalAdjacentPressureDifferenceY = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                @NotNull Cell neighbour = cells.getCell(x + i, y + j);
                double
                        dpParticular = neighbour.getPressure() - cell.getPressure(),
                        distance = Math.hypot(i, j);
                // "- signum / distance" ensures correct angles in orthogonal cells
                // enables to not use trigonometry
                totalAdjacentPressureDifferenceX -=
                        dpParticular * Math.signum(i) / Math.pow(distance, 2);
                totalAdjacentPressureDifferenceY -=
                        dpParticular * Math.signum(j) / Math.pow(distance, 2);
            }
        }
        double
                averageAdjacentPressureDifferenceX = totalAdjacentPressureDifferenceX / ORTHOGONAL_NEIGHBOUR_SUM,
                averageAdjacentPressureDifferenceY = totalAdjacentPressureDifferenceY / ORTHOGONAL_NEIGHBOUR_SUM,
                oldWindProjX = cell.windAmount * Math.cos(cell.windDirection),
                oldWindProjY = cell.windAmount * Math.sin(cell.windDirection),
                newWindProjX = oldWindProjX + averageAdjacentPressureDifferenceX * pressureToWindCoefficient,
                newWindProjY = oldWindProjY + averageAdjacentPressureDifferenceY * pressureToWindCoefficient;

        setNewWind(cell, newWindProjX, newWindProjY);
    }

    private void setNewWind(Cell cell, double windProjX, double windProjY) {
        double maxWind = 5000;
        cell.windAmount = Math.min(maxWind, Math.hypot(windProjX, windProjY));
        cell.windDirection = mathUtils.Trigonometry.getAngle(windProjX, windProjY);
    }

    private void setRandomWind(Cell cell) {
        double randomWind = 3;
        if (RANDOM.nextBoolean()) {
            cell.windAmount += randomWind;
        } else {
            cell.windAmount -= randomWind;
        }
        cell.windDirection = RANDOM.nextDouble() * Math.PI * 2;
    }

    private void windBrake(Cell cell) {
        double brakeCoefficient = 0.01;
        if (cell.windAmount > 0) {
            cell.windAmount -= brakeCoefficient * Math.pow(cell.windAmount, 3);
        }
        if (cell.windAmount < 0) {
            cell.windAmount = 0;
        }
    }
}