package staticData;

import java.util.List;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

import cells.CellContainer;

/**
 * A utility class for containing common static data.
 */
public class StaticData {
    public static final @NotNull CellContainer cells; //barokinetic cells
    public static boolean pause; //cell-update toggle

    public static final @NotNull List<int @NotNull []> clickPoints; //UI testing; TODO: remove this

    static {
        cells = new CellContainer();
        pause = false;
        clickPoints = new ArrayList<>();
        //initialize more static data here
    }
}