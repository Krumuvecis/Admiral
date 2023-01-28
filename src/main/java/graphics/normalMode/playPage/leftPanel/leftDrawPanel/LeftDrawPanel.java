package graphics.normalMode.playPage.leftPanel.leftDrawPanel;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;

import graphicsEngineExtension.windows.KeyboardListenableWindow;
import graphicsEngineExtension.ExtendedDynamicPanel;

//TODO: add javadocs
public class LeftDrawPanel extends ExtendedDynamicPanel {
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
    public LeftDrawPanel(@NotNull KeyboardListenableWindow window) {
        super(new SimpleColorScheme(BACKGROUND_COLOR, TEXT_COLOR));
        fieldInfoSection = new FieldInfoSection();
        pressedKeySection = new PressedKeySection(window);
    }

    //TODO: add javadoc
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTestLines(g, null);

        @NotNull Color textColor = getPanelColors().getSecondaryColor();
        fieldInfoSection.draw(g, textColor, 0);
        pressedKeySection.draw(g, textColor, fieldInfoSection.getSectionEnd());

        //paint other stuff here
    }
}