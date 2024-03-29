package graphics.devMode.common.header;

import java.awt.event.ActionEvent;

import org.jetbrains.annotations.NotNull;

import staticData.StaticData;

import graphics.common.CommonWindow;
import graphics.common.panels.header.SimpleHeaderButtonListener;
import graphics.common.panels.header.Button_Menu;

/**
 * TODO: add javadocs
 */
public class HeaderButtonListener extends SimpleHeaderButtonListener {

    /**
     * TODO: finish this javadoc
     */
    public HeaderButtonListener(@NotNull CommonWindow window) {
        super(window);
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public boolean actionCheck(@NotNull ActionEvent e) {
        switch (e.getActionCommand()) {
            case Button_Menu.ACTION_COMMAND ->
                    getCommonWindow().toggleOverlay();
            case Button_Pause.ACTION_COMMAND ->
                    StaticData.pause = !StaticData.pause;
            //add new header button actions here
            default -> {
                return false;
            }
        }
        return true;
    }

    private @NotNull CommonWindow getCommonWindow() {
        return (CommonWindow) getWindow();
    }
}