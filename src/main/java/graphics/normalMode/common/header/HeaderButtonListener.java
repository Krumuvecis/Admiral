package graphics.normalMode.common.header;

import java.awt.event.ActionEvent;

import org.jetbrains.annotations.NotNull;

import staticData.StaticData;

import graphics.common.CommonWindow;
import graphics.common.header.SimpleHeaderButtonListener;
import graphics.normalMode.playPage.PlayPage;
import graphics.normalMode.startingPage.StartingPage;

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
                    getWindow().toggleOverlay();
            case Button_StartingPage.ACTION_COMMAND ->
                    getWindow().setActivePage(StartingPage.getStaticPageKey());
            case Button_PlayPage.ACTION_COMMAND ->
                    getWindow().setActivePage(PlayPage.getStaticPageKey());
            case Button_Pause.ACTION_COMMAND ->
                    StaticData.pause = !StaticData.pause;
            //add new header button actions here
            default -> {
                return false;
            }
        }
        return true;
    }
}