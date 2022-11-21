package graphics.playPage;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.DynamicPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

//TODO: add javadocs
public class DrawPanel extends DynamicPanel {
    private static Color backgroundColor = new Color(50, 100, 150);
    private int[] mousePos = new int[2];

    //TODO: add javadoc
    DrawPanel() {
        super(new SimpleColorScheme(backgroundColor, null));
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mousePos[0] = e.getX();
                mousePos[1] = e.getY();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mousePos[0] = e.getX();
                mousePos[1] = e.getY();
            }
        });
        //setBackground(backgroundColor);
    }

    //TODO: add javadoc
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension panelSize = this.getSize();
        g.setColor(Color.red);
        g.drawLine(0, 0, panelSize.width, panelSize.height);
        g.setColor(getPanelColors().getSecondaryColor());
        g.drawString("x: " + mousePos[0] + ", y: " + mousePos[1], mousePos[0], mousePos[1]);
    }
}