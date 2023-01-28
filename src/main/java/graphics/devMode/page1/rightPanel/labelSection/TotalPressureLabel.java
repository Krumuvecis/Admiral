package graphics.devMode.page1.rightPanel.labelSection;

import java.awt.Color;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import consoleUtils.NumberFormatter;
import graphicsEngine.parts.labels.DynamicLabel;

import staticData.StaticData;

class TotalPressureLabel extends DynamicLabel {
    private static final @NotNull String STATIC_LABEL_TEXT = "Total pressure: ";
    private static final int DECIMAL_PLACES = 3;

    protected TotalPressureLabel(@Nullable Color textColor,
                                 @Nullable Color background) {
        super(textColor, background);
    }

    //TODO: add javadoc
    @Override
    public final @NotNull String getLabelText() {
        return STATIC_LABEL_TEXT + getFormattedTotalPressure();
    }

    private @NotNull String getFormattedTotalPressure() {
        return NumberFormatter.doubleToString(getTotalPressure(), DECIMAL_PLACES);
    }

    private double getTotalPressure() {
        return StaticData.cells.getTotalPressure();
    }
}