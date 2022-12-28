package graphics.normalMode.playPage.leftPanel.leftDrawPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.DynamicPanel;

import graphics.normalMode.NormalWindow;

//TODO: add javadocs
public class LeftDrawPanel extends DynamicPanel {
    private static final int BACKGROUND_BRIGHTNESS = 50;
    private static final @Nullable Color
            BACKGROUND_COLOR = new Color(
            BACKGROUND_BRIGHTNESS,
            BACKGROUND_BRIGHTNESS,
            BACKGROUND_BRIGHTNESS),
            TEXT_COLOR = null; // default - white

    private final @NotNull AbstractSection
            fieldInfoSection,
            pressedKeySection;

    //TODO: add javadoc
    public LeftDrawPanel(@NotNull NormalWindow window) {
        super(new SimpleColorScheme(BACKGROUND_COLOR, TEXT_COLOR));
        fieldInfoSection = new FieldInfoSection();
        pressedKeySection = new PressedKeySection(window);
    }

    //TODO: add javadoc
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension drawSize = this.getSize();

        drawTestLines(g, drawSize);

        @NotNull Color textColor = getPanelColors().getSecondaryColor();
        fieldInfoSection.draw(g, textColor, 0);
        pressedKeySection.draw(g, textColor, fieldInfoSection.getSectionEnd());

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