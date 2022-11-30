package graphics.playPage.leftPanel;

import graphicsEngine.parts.SimpleLabel;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.Nullable;

//
public abstract class DynamicLabel extends SimpleLabel {

    //
    public DynamicLabel(@Nullable Color textColor,
                        @Nullable Color background) {
        super(null, textColor, background);
    }

    @Override
    protected void paintComponent(Graphics g) {
        setText(getLabelText());
        super.paintComponent(g);
    }

    public abstract @Nullable String getLabelText();
}