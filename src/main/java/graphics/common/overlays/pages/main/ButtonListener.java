package graphics.common.overlays.pages.main;

import java.awt.event.ActionEvent;

import org.jetbrains.annotations.NotNull;

import staticData.StaticData;

import graphics.common.CommonWindow;
import graphics.common.overlays.OverlayPageType;
import graphics.common.overlays.OverlayButtonListener;
import graphics.common.overlays.pages.common.Button_Back;
import graphics.normalMode.NormalWindow;
import graphics.normalMode.startingPage.StartingPage;
import graphics.devMode.DevWindow;

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
            case Button_Back.ACTION_COMMAND -> getWindow().toggleOverlay();
            case Button_Pause.ACTION_COMMAND -> StaticData.pause = !StaticData.pause;
            case Button_Settings.ACTION_COMMAND -> switchPage(OverlayPageType.SETTINGS);
            case Button_Exit.ACTION_COMMAND -> switchWindowToStartingPage();
            default -> {
                return false;
            }
        }
        return true;
    }

    private void switchWindowToStartingPage() {
        @NotNull CommonWindow window = getWindow();
        window.toggleOverlay();
        if (window instanceof NormalWindow) {
            window.setActivePage(StartingPage.getStaticPageKey());
        }
        if (window instanceof DevWindow) {
            //TODO: return to starting page
        }
    }
}