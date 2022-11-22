package staticData;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import ThreadAbstraction.AbstractUpdater;
import org.jetbrains.annotations.NotNull;

public class StaticData {
    public static @NotNull List<int @NotNull []> clickPoints = new ArrayList<>();
    public static int cellSize = 100;
    public static int @NotNull []
            cellCount = new int[] {10, 10},
            fieldSize = new int[] {cellSize * cellCount[0], cellSize * cellCount[1]};

    public static @NotNull List<@NotNull List<@NotNull Cell>> cells = new ArrayList<>() {{
        for (int i = 0; i < cellCount[0]; i++) {
            add(new ArrayList<>() {{
                for (int j = 0; j < cellCount[1]; j++) {
                    add(new Cell());
                }
            }});
        }
    }};

    static {
        new CellUpdater(20).start();
    }

    private static class CellUpdater extends AbstractUpdater {
        static double changeChance = 0.01;
        static Random random = new Random();

        CellUpdater(int delay) {
            super(delay);
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
            if (random.nextDouble() < changeChance) {
                cell.state = !cell.state;
            }
        }
    }
}