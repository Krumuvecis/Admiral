package graphics.common.header;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;

import static consoleUtils.ConsoleUtils.printLine;

import staticData.StaticData;

import graphics.Window;
import graphics.playPage.PlayPage;
import graphics.startingPage.StartingPage;

/**
 * TODO: add javadocs
 */
public class HeaderButtonListener implements ActionListener {
    private final Window window;

    /**
     * TODO: finish this javadoc
     */
    public HeaderButtonListener(@NotNull Window window) {
        this.window = window;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (window.pageListenersEnabled) {
            if (actionCheck(e)) return;
            printLine("A header button has been pressed but no action set up");
        }
    }

    private boolean actionCheck(@NotNull ActionEvent e) {
        switch (e.getActionCommand()) {
            case Button_Menu.ACTION_COMMAND ->
                    window.toggleOverlay();
            case Button_StartingPage.ACTION_COMMAND ->
                    window.setActivePage(StartingPage.getStaticPageKey());
            case Button_PlayPage.ACTION_COMMAND ->
                    window.setActivePage(PlayPage.getStaticPageKey());
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