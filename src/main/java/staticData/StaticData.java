package staticData;

import java.util.List;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

public class StaticData {
    public static int cellSize = 100;
    public static int @NotNull []
            cellCount = new int[] {10, 10},
            fieldSize = new int[] {cellSize * cellCount[0], cellSize * cellCount[1]};
    public static @NotNull List<int @NotNull []> clickPoints = new ArrayList<>();
}