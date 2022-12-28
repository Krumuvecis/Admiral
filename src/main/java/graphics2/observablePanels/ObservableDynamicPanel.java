package graphics2.observablePanels;

import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.DynamicPanel;

import graphicsEngineExtension.input.mouse.SimpleMouseListener;
import graphicsEngineExtension.input.mouse.SimpleMouseMotionListener;
import graphicsEngineExtension.input.mouse.SimpleMouseWheelListener;

import graphics2.Observer;
import graphics2.ObserverMouseActions;

//TODO: add javadocs
public abstract class ObservableDynamicPanel extends DynamicPanel implements ObservablePanel {
    public final @NotNull Observer observer;
    private boolean panelActive;

    //
    public ObservableDynamicPanel(@Nullable SimpleColorScheme colors,
                                  @NotNull Observer observer) {
        super(colors);
        setPanelActive(false);
        this.observer = observer;
        @NotNull ObserverMouseActions mouseActions = new ObserverMouseActions(this, observer);
        addMouseListeners(
                new SimpleMouseListener(mouseActions),
                new SimpleMouseMotionListener(mouseActions),
                new SimpleMouseWheelListener(mouseActions));
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

    private void addMouseListeners(@Nullable MouseListener mouseListener,
                                   @Nullable MouseMotionListener mouseMotionListener,
                                   @Nullable MouseWheelListener mouseWheelListener) {
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseMotionListener);
        addMouseWheelListener(mouseWheelListener);
    }
}