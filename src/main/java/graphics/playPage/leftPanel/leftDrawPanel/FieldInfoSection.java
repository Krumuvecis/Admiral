package graphics.playPage.leftPanel.leftDrawPanel;

import java.awt.Graphics;
import java.awt.Color;

import org.jetbrains.annotations.NotNull;

import consoleUtils.NumberFormatter;

import staticData.StaticData;

//TODO: add javadocs
class FieldInfoSection extends AbstractTextSection {

    //TODO: add javadoc
    FieldInfoSection() {
        super();
    }

    //TODO: add javadoc
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
    }
}