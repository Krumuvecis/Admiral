package graphics.playPage.leftPanel;

import graphics.Window;
import graphics.playPage.observer.Observer;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.DynamicPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//
class LeftDrawPanel extends DynamicPanel {
    private static final int BACKGROUND_BRIGHTNESS = 50;
    private static final @Nullable Color
            BACKGROUND_COLOR = new Color(
            BACKGROUND_BRIGHTNESS,
            BACKGROUND_BRIGHTNESS,
            BACKGROUND_BRIGHTNESS),
            TEXT_COLOR = null; // default - white

    private final @NotNull AbstractSection
            fieldInfoSection,
            observerInfoSection;

    //
    LeftDrawPanel(@NotNull Window window,
                  @NotNull Observer observer) {
        super(new SimpleColorScheme(BACKGROUND_COLOR, TEXT_COLOR));
        fieldInfoSection = new FieldInfoSection();
        observerInfoSection = new ObserverInfoSection(window, observer);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension drawSize = this.getSize();

        drawTestLines(g, drawSize);

        @NotNull Color textColor = getPanelColors().getSecondaryColor();
        fieldInfoSection.draw(g, textColor, 0);
        observerInfoSection.draw(g, textColor, fieldInfoSection.getSectionEnd());

        //paint other stuff here
    }

    private void drawTestLines(@NotNull Graphics g,
                               @NotNull Dimension drawSize) {
        g.setColor(Color.red);
        g.drawLine(
                0, 0,
                drawSize.width, drawSize.height);
        g.drawLine(
                drawSize.width, 0,
                0, drawSize.height);
    }
}