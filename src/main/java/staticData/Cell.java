package staticData;

import ThreadAbstraction.AbstractUpdater;

import java.util.List;
import java.util.Random;

import org.jetbrains.annotations.NotNull;

public class Cell {
    public static final double VALUE_MAX = 20;
    public double value;

    Cell() {
        value = 0;
    }

    static class CellUpdater extends AbstractUpdater {
        private static final int DELAY = 20;
        static double
                normalizationRate = 0.1,
                suddenChangeChance = 0.005;
        static Random random = new Random();

        private final @NotNull List<@NotNull List<@NotNull Cell>> cells;
        private final int @NotNull [] cellCount;


        CellUpdater(@NotNull List<@NotNull List<@NotNull Cell>> cells,
                    int @NotNull [] cellCount) {
            super(DELAY);
            this.cells = cells;
            this.cellCount = cellCount;
        }

        /**
         *
         */
        @Override
        public void update() {
            for (int i = 0; i < cellCount[0]; i++) {
                for (int j = 0; j < cellCount[1]; j++) {
                    updateSingleCell(i, j);
                }
            }
        }

        private void updateSingleCell(int x, int y) {
            Cell cell = cells.get(x).get(y);
            if (random.nextDouble() < suddenChangeChance) {
                cell.value = Cell.VALUE_MAX;
            } else {
                double newValue = cell.value - normalizationRate;
                cell.value = Math.max(0, newValue);
            }
        }
    }
}