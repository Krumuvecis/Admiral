package graphics.playPage.leftPanel;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.parts.SimpleLabel;

//TODO: add javadocs
public abstract class DynamicLabel extends SimpleLabel {

    //TODO: add javadoc
    public DynamicLabel(@Nullable Color textColor,
                        @Nullable Color background) {
        super(null, textColor, background);
    }

    //TODO: add javadoc
    @Override
    protected void paintComponent(Graphics g) {
        setText(getLabelText());
        super.paintComponent(g);
    }

    //TODO: add javadoc
    public abstract @Nullable String getLabelText();
}