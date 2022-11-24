package graphics.playPage.drawPanel;

import staticData.StaticData;

import graphics.common.KeyboardListener;
import graphics.playPage.observer.Observer;

import java.awt.*;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ObserverInfoPainter {
    private final @NotNull Observer observer;

    ObserverInfoPainter(@NotNull Observer observer) {
        this.observer = observer;
    }

    void drawKeyInfo(@NotNull Graphics g,
                     @Nullable KeyboardListener keyboardListener,
                     @NotNull Color textColor) {
        int[] textPosition = new int[] {10, 25};
        int dt = 15;
        g.setColor(textColor);
        g.drawString("Pressed keys:", textPosition[0], textPosition[1]);

        if (keyboardListener == null) {
            g.drawString(
                    "Keyboard listener not initialized.",
                    textPosition[0],
                    textPosition[1] + dt);
        } else {
            for (int i = 0; i < keyboardListener.pressedKeys.size(); i++) {
                int key = keyboardListener.pressedKeys.get(i);
                g.drawString(
                        (i + 1) + " - " + key,
                        textPosition[0],
                        textPosition[1] + dt * (i + 1));
            }
        }
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