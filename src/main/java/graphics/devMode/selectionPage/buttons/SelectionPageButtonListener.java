package graphics.devMode.selectionPage.buttons;

import java.awt.event.ActionEvent;

import org.jetbrains.annotations.NotNull;

import graphicsEngineExtension.SimpleButtonListener;

import graphics.common.CommonWindow;
import graphics.devMode.page1.Page1;

/**
 * TODO: add javadocs
 */
public class SelectionPageButtonListener extends SimpleButtonListener {

    /**
     * TODO: finish this javadoc
     */
    public SelectionPageButtonListener(@NotNull CommonWindow window) {
        super(window);
    }

    @Override
    public final @NotNull String listenableName() {
        return "Dev selection page";
    }

    /**
     * TODO: finish this javadoc
     */
    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    @Override
    public boolean actionCheck(@NotNull ActionEvent e) {
        switch (e.getActionCommand()) {
            case Button_Page1.ACTION_COMMAND ->
                    getCommonWindow().setActivePage(Page1.getStaticPageKey());
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