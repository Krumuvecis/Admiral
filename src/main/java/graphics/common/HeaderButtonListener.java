package graphics.common;

import staticData.StaticData;

import graphics.Window;
import graphics.playPage.PlayPage;
import graphics.startingPage.StartingPage;

import graphicsEngine.presets.SimpleJButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static consoleUtils.ConsoleUtils.printLine;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadocs
public class HeaderButtonListener implements ActionListener {
    private final Window window;

    //TODO: add javadoc
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

    //TODO: add javadocs
    public static class Button_Menu extends SimpleJButton {
        public static final String ACTION_COMMAND = "overlay_menu";

        protected Button_Menu(@Nullable ActionListener actionListener) {
            super("Menu", ACTION_COMMAND, actionListener);
            setFocusable(false);
        }
    }

    //TODO: add javadocs
    public static class Button_StartingPage extends SimpleJButton {
        public static final String ACTION_COMMAND = "page_starting";

        protected Button_StartingPage(@Nullable ActionListener actionListener) {
            super("Starting page", ACTION_COMMAND, actionListener);
            setFocusable(false);
        }
    }

    //TODO: add javadocs
    public static class Button_PlayPage extends SimpleJButton {
        public static final String ACTION_COMMAND = "page_play";

        protected Button_PlayPage(@Nullable ActionListener actionListener) {
            super("Play page", ACTION_COMMAND, actionListener);
            setFocusable(false);
        }
    }

    //TODO: add javadocs
    public static class Button_Pause extends SimpleJButton {
        public static final String ACTION_COMMAND = "pause";

        protected Button_Pause(@Nullable ActionListener actionListener) {
            super("Toggle pause", ACTION_COMMAND, actionListener);
            setFocusable(false);
        }
    }
}