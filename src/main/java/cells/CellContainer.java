package cells;

import java.util.List;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

public class CellContainer {
    public static int cellSize = 100;
    public static int @NotNull []
            cellCount = new int[] {30, 20},
            fieldSize = new int[] {cellSize * cellCount[0], cellSize * cellCount[1]};

    private final @NotNull List<@NotNull List<@NotNull Cell>> cells = new ArrayList<>() {{
        for (int i = 0; i < cellCount[0]; i++) {
            add(new ArrayList<>() {{
                for (int j = 0; j < cellCount[1]; j++) {
                    add(new Cell());
                }
            }});
        }
    }};

    public CellContainer() {
        setInitialCells(false); //set this to true, for some pre-defined initial cells
        new CellUpdater(this, cellCount).start();
    }

    @SuppressWarnings("SameParameterValue")
    private void setInitialCells(boolean setInitial) {
        if (setInitial) {
            getCell(
                    cellCount[0] / 2 - 1,
                    cellCount[1] / 2 - 1
            ).newPressure = Cell.PRESSURE_MAX;
            /*getCell(
                    cellCount[0] / 2,
                    cellCount[1] / 2 - 1
            ).newPressure = -Cell.PRESSURE_MAX;*/
        }
    }

    public @NotNull Cell getCell(int x, int y) {
        if (x < 0) {
            x += cellCount[0];
        }
        if (y < 0) {
            y += cellCount[1];
        }
        if (x >= cellCount[0]) {
            x -= cellCount[0];
        }
        if (y >= cellCount[1]) {
            y -= cellCount[1];
        }
        return cells.get(x).get(y);
    }
}