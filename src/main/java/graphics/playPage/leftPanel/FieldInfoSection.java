package graphics.playPage.leftPanel;

import staticData.StaticData;

import java.awt.Graphics;
import java.awt.Color;

import consoleUtils.NumberFormatter;

import org.jetbrains.annotations.NotNull;

//
class FieldInfoSection extends AbstractTextSection {
    //
    FieldInfoSection() {
        super();
    }

    //
    @Override
    final void draw(@NotNull Graphics g,
              @NotNull Color textColor,
              int verticalOffset) {
        super.draw(g, textColor, verticalOffset);

        //draw pause status
        drawLineOfText(g, textColor, sectionLocation,
                "pause: " + StaticData.pause);

        //show total pressure
        double totalPressure = StaticData.cells.getTotalPressure();
        drawLineOfText(g, textColor, sectionLocation,
                "Total pressure: " + NumberFormatter.doubleToString(totalPressure, 3));
        drawLineOfText(g, textColor, sectionLocation, "slider value: " + StaticData.sliderTestValue);
    }
}