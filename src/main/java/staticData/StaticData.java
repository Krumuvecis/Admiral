package staticData;

import cells.CellContainer;

import java.util.List;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

/**
 * A utility class for containing common static data.
 */
public class StaticData {
    //barokinetic cells
    public static @NotNull CellContainer cells = new CellContainer();
    public static boolean pause = false; //cell-update toggle

    //UI testing
    public static @NotNull List<int @NotNull []> clickPoints = new ArrayList<>();
}