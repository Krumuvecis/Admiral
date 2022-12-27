package graphics.normalMode.startingPage;

import java.util.List;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.panels.StaticPanel;
import graphicsEngine.presets.panels.AbstractHeader;
import graphicsEngine.parts.labels.SimpleLabel;

import graphics.common.CommonWindow;
import graphics.normalMode.common.NormalPage;
import graphics.normalMode.startingPage.buttons.Button_Play;
import graphics.normalMode.startingPage.buttons.StartingPageButtonListener;

//TODO: add javadocs
public class StartingPage extends NormalPage {
    private StartingPageButtonListener buttonListener;

    private StartingPage() {
        this(null, null, null);
    }

    //TODO: add javadoc
    public StartingPage(@Nullable CommonWindow window,
                        @Nullable List<ActionListener> actionListenerList,
                        @Nullable SimpleColorScheme colors) {
        super(window, actionListenerList, colors);
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

    //TODO: add javadoc
    @Override
    public final boolean addParticularListener(@Nullable ActionListener listener) {
        if (listener instanceof StartingPageButtonListener) {
            buttonListener = (StartingPageButtonListener) listener;
            return true;
        }
        return false;
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public final @Nullable AbstractHeader getHeader(@Nullable SimpleColorScheme headerColors,
                                                    @Nullable BorderProperties borderProperties) {
        return null;
    }

    //TODO: add javadoc
    @Override
    public final void setBodyParameters() {
        //TODO: set body parameters here
    }

    //TODO: add javadoc
    @Override
    public final @NotNull Component getPageBody() {
        return new StaticPanel(
                null,
                null,
                null) {
            {
                setLayout(new BorderLayout(0, 0));
                add(new SimpleLabel("Starting page", getPanelColors().getSecondaryColor()), BorderLayout.NORTH);
                add(new Button_Play(buttonListener));
                //Add more parts to body here
            }
        };
    }
}