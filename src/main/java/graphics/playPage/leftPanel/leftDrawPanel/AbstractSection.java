package graphics.playPage.leftPanel.leftDrawPanel;

import java.awt.Graphics;
import java.awt.Color;

import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
abstract class AbstractSection {
    private static final int
            DEFAULT_TEXT_SPACING = 15,
            DEFAULT_SECTION_SPACING = DEFAULT_TEXT_SPACING * 2;
    private static final int @NotNull [] INITIAL_OFFSET = new int[] {10, 0};

    //TODO: add javadoc
    final int @NotNull [] sectionLocation;
    int textSpacing, sectionSpacing;

    //TODO: add javadoc
    AbstractSection() {
        sectionLocation = new int[] {
                INITIAL_OFFSET[0],
                INITIAL_OFFSET[1]};
        textSpacing = DEFAULT_TEXT_SPACING;
        sectionSpacing = DEFAULT_SECTION_SPACING;
    }

    //TODO: add javadoc
    @SuppressWarnings("unused")
    final void setTextSpacing(int textSpacing) {
        this.textSpacing = textSpacing;
    }

    //TODO: add javadoc
    @SuppressWarnings("unused")
    final void setSectionSpacing(int sectionSpacing) {
        this.sectionSpacing = sectionSpacing;
    }

    //TODO: add javadoc
    void draw(@NotNull Graphics g, @NotNull Color textColor,
              int verticalOffset) {
        sectionLocation[1] = INITIAL_OFFSET[1] + verticalOffset;
    }

    //TODO: add javadoc
    final int getSectionEnd() {
        return sectionLocation[1] - INITIAL_OFFSET[1] + getSectionHeight() + sectionSpacing;
    }

    //TODO: add javadoc
    abstract int getSectionHeight();
}
