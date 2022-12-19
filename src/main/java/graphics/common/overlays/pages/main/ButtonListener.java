package graphics.common.overlays.pages.main;

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
    @SuppressWarnings({"DuplicateBranchesInSwitch"})
    @Override
    public boolean actionCheck(@NotNull ActionEvent e) {
        switch (e.getActionCommand()) {
            case Button_Back.ACTION_COMMAND -> getWindow().toggleOverlay();
            case Button_Pause.ACTION_COMMAND -> {} //TODO: add pause toggle
            case Button_Settings.ACTION_COMMAND -> switchPage(OverlayPageType.SETTINGS);
            case Button_Exit.ACTION_COMMAND -> getWindow().toggleOverlay(); //TODO: return to starting page
            default -> {
                return false;
            }
        }
        return true;
    }
}