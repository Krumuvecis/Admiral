package cells;

import ThreadAbstraction.AbstractUpdater;
import java.util.Random;

import org.jetbrains.annotations.NotNull;
import staticData.StaticData;

public class CellUpdater extends AbstractUpdater {
    private static final int DELAY = 50;
    private static final double
            orthogonalNeighbourSum = 4 * (1 + 1 / Math.sqrt(2)), // don't change this!
            inertiaFactor = 10, // inertia of medium (must be greater than 1; otherwise self-induces)
            pressureToWindCoefficient = 1, // relative wind coefficient
            windToPressureCoefficient = 1 / pressureToWindCoefficient / inertiaFactor, // don't change this!
            pressureDampeningFactor = 0.07, // changeable
            suddenChangeChance = 0.00005; // changeable
    static Random random = new Random();

    private final CellContainer cellContainer;
    private final int @NotNull [] cellCount;
    private final boolean randomizePressures = true;

    public CellUpdater(CellContainer cellContainer,
                       int @NotNull [] cellCount) {
        super(DELAY);
        this.cellContainer = cellContainer;
        this.cellCount = cellCount;
    }

    /**
     *
     */
    @Override
    public void update() {
        if(!StaticData.pause) {
            updatePressures();
            updateWinds();
            distributePressures();
        }
    }

    private void updatePressures() {
        for (int i = 0; i < cellCount[0]; i++) {
            for (int j = 0; j < cellCount[1]; j++) {
                updatePressure_SingleCell(i, j);
            }
        }
    }

    private void updatePressure_SingleCell(int x, int y) {
        Cell cell = cellContainer.getCell(x, y);
        cell.pressure = cell.newPressure * (1 - pressureDampeningFactor);

        if (randomizePressures
                && random.nextDouble() < suddenChangeChance) {
            setRandomPressure(cell);
        } /*else {
            cell.pressure -= Math.signum(cell.pressure) * (
                    Math.exp(
                            normalizationRate
                                    * Math.abs(cell.pressure))
                            - 1);
        }*/
        cell.newPressure = cell.pressure;
    }

    private void setRandomPressure(Cell cell) {
        if (random.nextBoolean()) {
            cell.pressure = Cell.PRESSURE_MAX;
        } else {
            cell.pressure = -Cell.PRESSURE_MAX;
        }
    }

    private void updateWinds() {
        for (int i = 0; i < cellCount[0]; i++) {
            for (int j = 0; j < cellCount[1]; j++) {
                updateWind_SingleCell(i, j);
            }
        }
    }

    private void updateWind_SingleCell(int x, int y) {
        Cell cell = cellContainer.getCell(x, y);
        //windBrake(cell);
        double
                totalAdjacentPressureDifferenceX = 0,
                totalAdjacentPressureDifferenceY = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                Cell neighbour = cellContainer.getCell(x + i, y + j);
                double
                        dpParticular = neighbour.pressure - cell.pressure,
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
                averageAdjacentPressureDifferenceX = totalAdjacentPressureDifferenceX / orthogonalNeighbourSum,
                averageAdjacentPressureDifferenceY = totalAdjacentPressureDifferenceY / orthogonalNeighbourSum,
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

    private void windBrake(Cell cell) {
        double brakeCoefficient = 0.01;
        if (cell.windAmount > 0) {
            cell.windAmount -= brakeCoefficient * Math.pow(cell.windAmount, 3);
        }
        if (cell.windAmount < 0) {
            cell.windAmount = 0;
        }
    }

    private void distributePressures() {
        for (int i = 0; i < cellCount[0]; i++) {
            for (int j = 0; j < cellCount[1]; j++) {
                distributePressure_singleCell(i, j);
            }
        }
    }

    private void distributePressure_singleCell(int x, int y) {
        Cell cell = cellContainer.getCell(x, y);
        double
                windAngle = cell.windDirection,
                magnitude = cell.windAmount;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                double neighbourAngle = mathUtils.Trigonometry.getAngle(i, j);
                Cell neighbour = cellContainer.getCell(x + i, y + j);

                double windProjectionOnNeighbour = magnitude * Math.cos(neighbourAngle - windAngle);
                double distanceCorrectedProjection = windProjectionOnNeighbour / Math.hypot(i, j);

                double particularPressureDifference = neighbour.pressure - cell.pressure;

                double particularPressureChange = distanceCorrectedProjection * windToPressureCoefficient;

                cell.newPressure -= particularPressureChange;
                neighbour.newPressure += particularPressureChange;
            }
        }
    }
}