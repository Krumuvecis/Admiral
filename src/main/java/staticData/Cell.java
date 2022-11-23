package staticData;

import ThreadAbstraction.AbstractUpdater;

import java.util.Random;

import org.jetbrains.annotations.NotNull;

public class Cell {
    public static final double VALUE_MAX = 20;
    public double
            pressure,
            newPressure,
            windAmount,
            windDirection;

    Cell() {
        pressure = 0;
        newPressure = 0;
        windAmount = 0;
        windDirection = 0;
    }

    static class CellUpdater extends AbstractUpdater {
        private static final int DELAY = 100;
        static double
                normalizationRate = 0.005,
                distributionRate = 0.1,
                suddenChangeChance = 0.0002;
        static Random random = new Random();

        private final int @NotNull [] cellCount;

        CellUpdater(int @NotNull [] cellCount) {
            super(DELAY);
            this.cellCount = cellCount;
        }

        /**
         *
         */
        @Override
        public void update() {
            updatePressures();
            updateWinds();
            distributePressures();
        }

        private void updatePressures() {
            for (int i = 0; i < cellCount[0]; i++) {
                for (int j = 0; j < cellCount[1]; j++) {
                    updatePressure_SingleCell(i, j);
                }
            }
        }

        private void updatePressure_SingleCell(int x, int y) {
            Cell cell = StaticData.getCell(x, y);
            cell.pressure = Math.max(0, Math.min(VALUE_MAX, cell.newPressure));
            if (random.nextDouble() < suddenChangeChance) {
                cell.pressure = Cell.VALUE_MAX;
            } else {
                double newValue = cell.pressure - normalizationRate;
                cell.pressure = Math.max(0, newValue);
            }
            cell.newPressure = cell.pressure;
        }

        private void updateWinds() {
            for (int i = 0; i < cellCount[0]; i++) {
                for (int j = 0; j < cellCount[1]; j++) {
                    updateWind_SingleCell(i, j);
                }
            }
        }

        private void updateWind_SingleCell(int x, int y) {
            double presX = 0, presY = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    Cell neighbour = StaticData.getCell(x + i, y + j);
                    presX += neighbour.pressure * Math.signum(i) / Math.hypot(i, j);
                    presY += neighbour.pressure * Math.signum(j) / Math.hypot(i, j);
                }
            }
            Cell cell = StaticData.getCell(x, y);
            cell.windAmount = Math.hypot(presX, presY);
            cell.windDirection = mathUtils.Trigonometry.getAngle(-presX, -presY);
        }

        private void distributePressures() {
            for (int i = 0; i < cellCount[0]; i++) {
                for (int j = 0; j < cellCount[1]; j++) {
                    distributePressure_singleCell(i, j);
                }
            }
        }

        private void distributePressure_singleCell(int x, int y) {
            Cell cell = StaticData.getCell(x, y);
            double
                    sourceAngle = mathUtils.Trigonometry.normalizeAngle(cell.windDirection + Math.PI),
                    projX = Math.cos(sourceAngle),
                    projY = Math.sin(sourceAngle);
            int
                    signProjX = (int) Math.signum(projX),
                    signProjY = (int) Math.signum(projY),
                    lowX = Math.min(0, signProjX),
                    highX = Math.max(0, signProjX),
                    lowY = Math.min(0, signProjY),
                    highY = Math.max(0, signProjY);

            double sqrt2 = Math.sqrt(2);

            for (int i = lowX; i <= highX; i++) {
                for (int j = lowY; j <= highY; j++) {
                    Cell source = StaticData.getCell(x + i, y + j);
                    double dp = source.pressure * distributionRate
                            * Math.sqrt(i * projX + j * projY) / (Math.abs(i * j) + sqrt2);
                    cell.newPressure += dp;
                    source.newPressure -= dp;
                }
            }
        }
    }
}