package graphics.common.overlays.pages.settings_dev;

import java.awt.event.ActionEvent;

import org.jetbrains.annotations.NotNull;

import graphics.common.CommonWindow;
import graphics.common.overlays.OverlayPageType;
import graphics.common.overlays.OverlayButtonListener;
import graphics.common.overlays.pages.common.Button_Back;

/**
 * TODO: add javadocs
 */
class ButtonListener extends OverlayButtonListener {
    //TODO: add javadoc
    protected ButtonListener(@NotNull CommonWindow window) {
        super(window);
    }

    //TODO: add javadoc
    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    @Override
    public boolean actionCheck(@NotNull ActionEvent e) {
        switch (e.getActionCommand()) {
            //TODO: add other button actions here
            case Button_Back.ACTION_COMMAND -> switchPage(OverlayPageType.SETTINGS);
            default -> {
                return false;
            }
        }
        return true;
    }
}