package staticData;

import java.util.List;
import java.util.ArrayList;

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
        new Cell.CellUpdater(cells, cellCount).start();
    }
}