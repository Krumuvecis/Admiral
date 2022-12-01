package graphics.playPage.leftPanel.leftDrawPanel;

import java.util.Objects;
import java.awt.Graphics;
import java.awt.Color;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadocs
abstract class AbstractTextSection extends AbstractSection {
    private int currentLine;

    //TODO: add javadoc
    AbstractTextSection() {
        super();
    }

    //TODO: add javadoc
    @Override
    void draw(@NotNull Graphics g, @NotNull Color textColor,
              int verticalOffset) {
        super.draw(g, textColor, verticalOffset);
        currentLine = 0;
    }

    //TODO: add javadoc
    final void drawLineOfText(@NotNull Graphics g, @NotNull Color textColor,
                              int @NotNull [] sectionLocation,
                              @Nullable String text) {
        currentLine++;
        g.setColor(textColor);
        g.drawString(Objects.requireNonNullElse(text, ""),
                sectionLocation[0],
                sectionLocation[1] + currentLine * textSpacing);
    }

    //TODO: add javadoc
    @Override
    final int getSectionHeight() {
        return getLastLineIndex() * textSpacing;
    }

    //TODO: add javadoc
    int getLastLineIndex() {
        return currentLine;
    }
}