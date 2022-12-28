package graphics2.observablePanels;

import java.awt.Dimension;

import org.jetbrains.annotations.NotNull;

//
public interface ObservablePanel {
    @NotNull Dimension getPanelCenter();
    void setPanelActive(boolean active);
    boolean getPanelActive();
}