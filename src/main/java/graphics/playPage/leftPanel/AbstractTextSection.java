package graphics.playPage.leftPanel;

import java.awt.Graphics;
import java.awt.Color;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//
abstract class AbstractTextSection extends AbstractSection {
    private int currentLine;

    //
    AbstractTextSection() {
        super();
    }

    //
    @Override
    void draw(@NotNull Graphics g, @NotNull Color textColor,
              int verticalOffset) {
        super.draw(g, textColor, verticalOffset);
        currentLine = 0;
    }

    //
    final void drawLineOfText(@NotNull Graphics g, @NotNull Color textColor,
                              int @NotNull [] sectionLocation,
                              @Nullable String text) {
        currentLine++;
        g.setColor(textColor);
        g.drawString(Objects.requireNonNullElse(text, ""),
                sectionLocation[0],
                sectionLocation[1] + currentLine * textSpacing);
    }

    //
    @Override
    final int getSectionHeight() {
        return getLastLineIndex() * textSpacing;
    }

    //
    int getLastLineIndex() {
        return currentLine;
    }
}