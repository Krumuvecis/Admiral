package graphics.devMode.page1.header;

import java.awt.event.ActionEvent;

import org.jetbrains.annotations.NotNull;

import staticData.StaticData;

import graphics.common.CommonWindow;
import graphics.common.header.SimpleHeaderButtonListener;
import graphics.common.header.Button_Menu;
import graphics.devMode.selectionPage.SelectionPage;
import graphics.devMode.page1.Page1;

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
            case Button_SelectionPage.ACTION_COMMAND ->
                    getCommonWindow().setActivePage(SelectionPage.getStaticPageKey());
            case Button_Page1.ACTION_COMMAND ->
                    getCommonWindow().setActivePage(Page1.getStaticPageKey());
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