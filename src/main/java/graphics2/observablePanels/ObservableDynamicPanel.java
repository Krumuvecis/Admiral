package graphics2.observablePanels;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;

import graphicsEngineExtension.ExtendedDynamicPanel;
import graphicsEngineExtension.input.mouse.SimpleMouseListener;
import graphicsEngineExtension.input.mouse.SimpleMouseMotionListener;
import graphicsEngineExtension.input.mouse.SimpleMouseWheelListener;

import graphics2.Observer;
import graphics2.ObserverMouseActions;

//TODO: add javadocs
public abstract class ObservableDynamicPanel extends ExtendedDynamicPanel implements ObservablePanel {
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