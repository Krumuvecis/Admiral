package cells;

import cells.settings.BarokineticSettings;

import java.util.List;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

/**
 * TODO: add javadocs
 */
public class CellContainer {
    private static final int @NotNull [] cellCount = new int[] {30, 20};
    public static final int cellSize = 100;
    public static final int @NotNull [] fieldSize = new int[] {
            cellSize * cellCount[0],
            cellSize * cellCount[1]};

    public final @NotNull BarokineticSettings barokineticSettings;

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final @NotNull List<@NotNull List<@NotNull Cell>> cells;

    //TODO: add javadoc
    public CellContainer() {
        barokineticSettings = new BarokineticSettings();
        cells = new ArrayList<>() {{
            for (int i = 0; i < cellCount[0]; i++) {
                add(new ArrayList<>() {{
                    for (int j = 0; j < cellCount[1]; j++) {
                        add(new Cell(barokineticSettings));
                    }
                }});
            }
        }};
        setInitialCells(false); //set this to true, for some pre-defined initial cells
        new CellUpdater(this).start();
    }

    @SuppressWarnings({"SameParameterValue", "CommentedOutCode", "RedundantSuppression"})
    private void setInitialCells(boolean setInitial) {
        if (setInitial) {
            double magnitude = barokineticSettings.pressureMaxMagnitudeChange;
            getCell(
                    cellCount[0] / 2 - 1,
                    cellCount[1] / 2 - 1
            ).setPressure(magnitude);
            /*getCell(
                    cellCount[0] / 2,
                    cellCount[1] / 2 - 1
            ).setPressure(-magnitude)*/
        }
    }

    //TODO: add javadoc
    public int @NotNull [] getCellCount() {
        return cellCount;
    }

    //TODO: add javadoc
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

    //TODO: add javadoc
    public double getTotalPressure() {
        double totalPressure = 0;
        int @NotNull [] cellCount = getCellCount();
        for (int i = 0; i < cellCount[0]; i++) {
            for (int j = 0; j < cellCount[1]; j++) {
                @NotNull Cell cell = getCell(i, j);
                totalPressure += cell.getPressure();
            }
        }
        return totalPressure;
    }
}