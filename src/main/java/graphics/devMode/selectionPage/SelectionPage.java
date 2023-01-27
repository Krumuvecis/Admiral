package graphics.devMode.selectionPage;

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
import graphics.common.centering.CenteringPanel;
import graphics.common.centering.CentralContainer;
import graphics.devMode.selectionPage.buttons.*;

//TODO: add javadocs
public class SelectionPage extends SimpleStartingPage {
    private SelectionPageButtonListener buttonListener;

    private SelectionPage() {
        this(null);
    }

    //TODO: add javadoc
    public SelectionPage(@Nullable CommonWindow window) {
        super(window, getNewListeners(window));
    }

    //TODO: add javadoc
    @Override
    public final @NotNull String getPageKey() {
        return "selectionPage";
    }

    //TODO: add javadoc
    public static @NotNull String getStaticPageKey() {
        return (new SelectionPage()).getPageKey();
    }

    private static @NotNull List<@NotNull ActionListener> getNewListeners(@Nullable CommonWindow window) {
        return new ArrayList<>() {{
            if (window != null) {
                add(new SelectionPageButtonListener(window));
            }
        }};
    }

    //TODO: add javadoc
    @Override
    public boolean addParticularListener(@Nullable ActionListener listener) {
        if (listener instanceof SelectionPageButtonListener) {
            buttonListener = (SelectionPageButtonListener) listener;
            return true;
        }
        return false;
    }

    /**
     * TODO: finish this javadoc
     */
    public final @NotNull DynamicPanel getCentralPanel(@Nullable BorderProperties borderProperties) {
        return new DynamicPanel(null, null, null) {{
            add(new CenteringPanel(
                    null,
                    buttonListener) {
                @Override
                public @NotNull CentralContainer getCenter(@Nullable ActionListener actionListener) {
                    return new CentralContainer(actionListener) {
                        /**
                         * @param actionListener
                         */
                        @Override
                        public void addComponents(@Nullable ActionListener actionListener) {
                            add(new SimpleLabel("Selection page", getPanelColors().getSecondaryColor()));
                            add(new Button_Page1(actionListener));
                            add(new Button_Page2(actionListener));
                            //Add more parts to body here
                        }
                    };
                }
            });
        }};
    }
}