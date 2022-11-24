package graphics.playPage;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.DynamicPanel;
import graphicsEngine.parts.SimpleLabel;
import graphicsEngine.presets.panels.VerticalPanel;

import java.awt.*;

import org.jetbrains.annotations.Nullable;

public class LeftPanel extends VerticalPanel {
    private static final int PANEL_WIDTH = 150;
    private static final int BACKGROUND_BRIGHTNESS = 80;
    private static final @Nullable Color
            BACKGROUND_COLOR = new Color(
                    BACKGROUND_BRIGHTNESS,
                    BACKGROUND_BRIGHTNESS,
                    BACKGROUND_BRIGHTNESS),
            TEXT_COLOR = null; // default - white

    public LeftPanel() {
        super(
                new SimpleColorScheme(BACKGROUND_COLOR, TEXT_COLOR),
                PANEL_WIDTH,
                null);
        setLayout(new BorderLayout(0, 0));
        add(new SimpleLabel(
                        "Play page",
                        getPanelColors().getSecondaryColor()),
                BorderLayout.NORTH);
        add(new LeftDrawPanel());
    }

    static class LeftDrawPanel extends DynamicPanel {
        private static final int BACKGROUND_BRIGHTNESS = 180;
        private static final @Nullable Color
                BACKGROUND_COLOR = new Color(
                        BACKGROUND_BRIGHTNESS,
                        BACKGROUND_BRIGHTNESS,
                        BACKGROUND_BRIGHTNESS),
                TEXT_COLOR = null; // default - white

        public LeftDrawPanel() {
            super(new SimpleColorScheme(BACKGROUND_COLOR, TEXT_COLOR));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.red);
            Dimension drawSize = this.getSize();
            g.drawLine(
                    0, 0,
                    drawSize.width, drawSize.height);
            g.drawLine(
                    drawSize.width, 0,
                    0, drawSize.height);
        }
    }
}