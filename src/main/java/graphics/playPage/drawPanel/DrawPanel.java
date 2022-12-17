package graphics.playPage.drawPanel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.DynamicPanel;

import graphics.playPage.observer.Observer;
import graphics.playPage.observer.MouseListeners;

//TODO: add javadocs
public class DrawPanel extends DynamicPanel {
    private static final int BACKGROUND_BRIGHTNESS = 30;
    private static final @Nullable Color
            BACKGROUND_COLOR = new Color(
                    BACKGROUND_BRIGHTNESS,
                    BACKGROUND_BRIGHTNESS,
                    BACKGROUND_BRIGHTNESS),
            TEXT_COLOR = null; // default - white
    private final @NotNull ObserverInfoPainter observerInfoPainter;
    private final @NotNull FieldPainter fieldPainter;
    public boolean panelActive = false;

    //TODO: add javadoc
    public DrawPanel(@NotNull Observer observer) {
        super(new SimpleColorScheme(BACKGROUND_COLOR, TEXT_COLOR));
        MouseListeners.addListeners(this, observer);

        observerInfoPainter = new ObserverInfoPainter(observer);
        fieldPainter = new FieldPainter(observer);
    }

    public void setPanelActive(boolean state) {
        panelActive = state;
    }

    public @NotNull Dimension getPanelCenter() {
        @NotNull Dimension panelSize = this.getSize();
        return new Dimension(
                panelSize.width / 2,
                panelSize.height / 2);
    }

    //TODO: add javadoc
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        @NotNull Dimension drawCenter = getPanelCenter();
        drawTestLines(g, this.getSize());

        fieldPainter.drawField(g, drawCenter);
        observerInfoPainter.drawClickPoints(g, drawCenter);
        drawCenterMarker(g, drawCenter);
        observerInfoPainter.drawMouseInfo(g, getPanelColors().getSecondaryColor());
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

    private void drawCenterMarker(@NotNull Graphics g,
                                  @NotNull Dimension drawCenter) {
        g.setColor(new Color(0, 80, 60));
        int markerSize = 20;
        int[] center = new int[] {drawCenter.width, drawCenter.height};
        g.drawLine( // vertical line
                center[0], center[1] - markerSize / 2,
                center[0], center[1] + markerSize / 2
        );
        g.drawLine( // horizontal line
                center[0] - markerSize / 2, center[1],
                center[0] + markerSize / 2, center[1]
        );
    }
}