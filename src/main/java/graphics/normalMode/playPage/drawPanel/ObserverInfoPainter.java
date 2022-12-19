package graphics.normalMode.playPage.drawPanel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import staticData.StaticData;

import graphics.normalMode.playPage.observer.Observer;

class ObserverInfoPainter {
    private final @NotNull Observer observer;

    ObserverInfoPainter(@NotNull Observer observer) {
        this.observer = observer;
    }

    void drawMouseInfo(@NotNull Graphics g,
                       @NotNull Color textColor) {
        g.setColor(textColor);
        int @NotNull []
                textOffset = new int[] {10, 10},
                mousePos = observer.mousePos,
                textPos = new int[] {
                        mousePos[0] + textOffset[0],
                        mousePos[1] + textOffset[1]};
        int dt = 15;
        g.drawString(
                "x: " + mousePos[0] + ", y: " + mousePos[1],
                textPos[0],
                textPos[1]);
        g.drawString(
                "zoom: " + observer.zoom,
                textPos[0],
                textPos[1] + dt);
    }

    void drawClickPoints(@NotNull Graphics g,
                         @NotNull Dimension drawCenter) {
        int
                unscaledRadius = 30,
                radius = unscaledRadius / observer.zoom;

        g.setColor(new Color(220, 170, 20));
        for (int[] point : StaticData.clickPoints) {
            g.fillOval(
                    drawCenter.width
                            + (point[0] - observer.observerPos[0]) / observer.zoom
                            - radius / 2,
                    drawCenter.height
                            + (point[1] - observer.observerPos[1]) / observer.zoom
                            - radius / 2,
                    radius,
                    radius);
        }
    }
}