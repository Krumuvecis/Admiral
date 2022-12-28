package graphics.normalMode.startingPage.buttons;

import java.awt.event.ActionEvent;

import org.jetbrains.annotations.NotNull;

import graphicsEngineExtension.input.SimpleButtonListener;

import graphics.common.CommonWindow;
import graphics.normalMode.playPage.PlayPage;

/**
 * TODO: add javadocs
 */
public class StartingPageButtonListener extends SimpleButtonListener {

    /**
     * TODO: finish this javadoc
     */
    public StartingPageButtonListener(@NotNull CommonWindow window) {
        super(window);
    }

    @Override
    public final @NotNull String listenableName() {
        return "Starting page";
    }

    /**
     * TODO: finish this javadoc
     */
    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    @Override
    public boolean actionCheck(@NotNull ActionEvent e) {
        switch (e.getActionCommand()) {
            case Button_Play.ACTION_COMMAND ->
                    getCommonWindow().setActivePage(PlayPage.getStaticPageKey());
            //add new button actions here
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