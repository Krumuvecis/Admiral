package graphics.common.overlays.page_main;

import java.awt.event.ActionEvent;

import org.jetbrains.annotations.NotNull;

import graphics.common.CommonWindow;
import graphics.common.overlays.OverlayButtonListener;

//
class ButtonListener extends OverlayButtonListener {
    //
    protected ButtonListener(@NotNull CommonWindow window) {
        super(window);
    }

    //
    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    @Override
    public boolean actionCheck(@NotNull ActionEvent e) {
        switch (e.getActionCommand()) {
            case Button_HideOverlay.ACTION_COMMAND ->
                    getWindow().toggleOverlay();
            //add new overlay button actions here
            default -> {
                return false;
            }
        }
        return true;
    }
}