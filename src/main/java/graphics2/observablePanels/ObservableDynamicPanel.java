package graphics2.observablePanels;

import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.DynamicPanel;

//
public abstract class ObservableDynamicPanel extends DynamicPanel implements ObservablePanel {
    public boolean panelActive;

    //
    public ObservableDynamicPanel(@Nullable SimpleColorScheme colors) {
        super(colors);
        panelActive = false;
    }

    //
    @Override
    public final @NotNull Dimension getPanelCenter() {
        @NotNull Dimension panelSize = this.getSize();
        return new Dimension(
                panelSize.width / 2,
                panelSize.height / 2);
    }

    //
    @Override
    public final void setPanelActive(boolean state) {
        panelActive = state;
    }

    //
    @Override
    public final boolean getPanelActive() {
        return panelActive;
    }

    //
    public final void addMouseListeners(@Nullable MouseListener mouseListener,
                                        @Nullable MouseMotionListener mouseMotionListener,
                                        @Nullable MouseWheelListener mouseWheelListener) {
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseMotionListener);
        addMouseWheelListener(mouseWheelListener);
    }
}