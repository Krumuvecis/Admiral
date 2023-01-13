package graphics.common.overlays.pages.settings_layout;

import java.util.Objects;
import java.awt.event.ActionEvent;

import org.jetbrains.annotations.NotNull;

import graphics.common.CommonWindow;
import graphics.common.pages.SimplePaneledPage;
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
            case Button_LeftPanel.ACTION_COMMAND -> {
                try {
                    //getPaneledPage().toggleLeftPanelVisibility();
                } catch (NullPointerException ignored) {}
            }
            //TODO: add other button actions here
            case Button_Back.ACTION_COMMAND -> switchPage(OverlayPageType.SETTINGS);
            default -> {
                return false;
            }
        }
        return true;
    }

    private @NotNull SimplePaneledPage getPaneledPage() throws NullPointerException {
        return (SimplePaneledPage) Objects.requireNonNull(getCommonWindow().getActivePage());
    }
}