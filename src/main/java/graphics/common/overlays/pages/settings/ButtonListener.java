package graphics.common.overlays.pages.settings;

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
    @Override
    public boolean actionCheck(@NotNull ActionEvent e) {
        switch (e.getActionCommand()) {
            case Button_Color.ACTION_COMMAND -> switchPage(OverlayPageType.SETTINGS_COLORS);
            case Button_Layout.ACTION_COMMAND -> switchPage(OverlayPageType.SETTINGS_LAYOUT);
            case Button_Dev.ACTION_COMMAND -> switchPage(OverlayPageType.SETTINGS_DEV);
            case Button_Back.ACTION_COMMAND -> switchPage(OverlayPageType.MAIN);
            default -> {
                return false;
            }
        }
        return true;
    }
}