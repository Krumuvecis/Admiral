package graphicsEngineExtension.sliders.panelless;

import java.util.Hashtable;
import java.awt.Color;
import javax.swing.JLabel;

import org.jetbrains.annotations.NotNull;

import consoleUtils.NumberFormatter;

/**
 * A simple slider with equidistant ticks and corresponding labels.
 */
abstract class TickedSlider extends SimpleSlider implements TickValueConvertible {
    /**
     * Creates a new TickedSlider.
     *
     * @param backgroundColor        Background color. (prevents flickering)
     * @param range                  Value range. {min, max}
     * @param majorTickCount         Number of major ticks. (excludes start; has to be greater than 1)
     * @param minorTickCount         Number of minor ticks between major ticks. (has to be greater than 1)
     * @param tickLabelDecimalPlaces Number of decimal places for tick labels.
     */
    protected TickedSlider(@NotNull Color backgroundColor,
                           double @NotNull [] range,
                           int majorTickCount, int minorTickCount,
                           int tickLabelDecimalPlaces) {
        super(backgroundColor, range);

        setConversionConstants(majorTickCount, minorTickCount);

        setTicks(majorTickCount, minorTickCount);
        setLabels(majorTickCount, minorTickCount, tickLabelDecimalPlaces);
    }

    private void setTicks(int majorTickCount, int minorTickCount) {
        setMinorTickSpacing(1);
        setMajorTickSpacing(minorTickCount);
        int totalTicks = majorTickCount * minorTickCount;
        setMaximum(totalTicks);
        setPaintTicks(true);
    }

    private void setLabels(int majorTickCount, int minorTickCount,
                           int labelDecimalPlaces) {
        setLabelTable(prepareLabelTable(majorTickCount, minorTickCount, labelDecimalPlaces));
        setPaintLabels(true);
    }

    private @NotNull Hashtable<@NotNull Integer, @NotNull JLabel> prepareLabelTable(
            int majorTickCount, int minorTickCount,
            int labelDecimalPlaces) {
        @NotNull Hashtable<@NotNull Integer, @NotNull JLabel> labelTable = new Hashtable<>();
        for (int i = 0; i <= majorTickCount; i++) {
            int tickPosition = i * minorTickCount;
            labelTable.put(
                    tickPosition,
                    newTickLabel(tickPosition, labelDecimalPlaces));
        }
        return labelTable;
    }

    private @NotNull JLabel newTickLabel(int tickPosition, int labelDecimalPlaces) {
        return new JLabel(NumberFormatter.doubleToString(
                getValueFromTick(tickPosition), labelDecimalPlaces));
    }
}