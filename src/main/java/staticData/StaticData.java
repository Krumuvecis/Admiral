package staticData;

import cells.CellContainer;

import java.util.List;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

/**
 * TODO: add javadocs
 */
public class StaticData {
    public static @NotNull List<int @NotNull []> clickPoints = new ArrayList<>();

    public static @NotNull CellContainer cells = new CellContainer();

    public static boolean pause = false;
}