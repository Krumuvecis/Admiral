package graphics.normalMode.startingPage;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.panels.BorderProperties;
import graphicsEngine.panels.DynamicPanel;
import graphicsEngine.parts.labels.SimpleLabel;

import graphics.common.CommonWindow;
import graphics.common.pages.SimpleStartingPage;
import graphics.normalMode.startingPage.buttons.*;

//TODO: add javadocs
public class StartingPage extends SimpleStartingPage {
    private @Nullable StartingPageButtonListener buttonListener;

    private StartingPage() {
        this(null);
    }

    //TODO: add javadoc
    public StartingPage(@Nullable CommonWindow window) {
        super(window, getNewListeners(window));
    }

    //TODO: add javadoc
    @Override
    public final @NotNull String getPageKey() {
        return "startingPage";
    }

    //TODO: add javadoc
    public static @NotNull String getStaticPageKey() {
        return (new StartingPage()).getPageKey();
    }

    private static @NotNull List<@NotNull ActionListener> getNewListeners(@Nullable CommonWindow window) {
        return new ArrayList<>() {{
            if (window != null) {
                add(new StartingPageButtonListener(window));
                //Add more listeners here
            }
        }};
    }

    //TODO: add javadoc
    @Override
    public final boolean addParticularListener(@Nullable ActionListener listener) {
        if (listener instanceof StartingPageButtonListener) {
            buttonListener = (StartingPageButtonListener) listener;
            return true;
        }
        //Check for other listener types here
        return false;
    }

    /**
     * TODO: finish this javadoc
     */
    public final @NotNull DynamicPanel getCentralPanel(@Nullable BorderProperties borderProperties) {
        return new DynamicPanel(
                null,
                null,
                borderProperties) {
            {
                setLayout(new BorderLayout(0, 0));
                add(new SimpleLabel("Starting page", getPanelColors().getSecondaryColor()), BorderLayout.NORTH);
                add(new Button_Play(buttonListener));
                //Add more parts to body here
            }
        };
    }
}