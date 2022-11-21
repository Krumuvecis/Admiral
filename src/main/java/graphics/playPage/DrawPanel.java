package graphics.playPage;

import javax.swing.JPanel;
import java.awt.*;

public class DrawPanel extends JPanel {
    private Color backgroundColor = new Color(50, 100, 150);
    DrawPanel() {
        setBackground(backgroundColor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension panelSize = this.getSize();
        g.setColor(Color.red);
        g.drawLine(0, 0, panelSize.width, panelSize.height);
    }
}