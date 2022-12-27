package graphics.devMode.page1;

import java.util.List;
import java.awt.*;
import java.awt.event.ActionListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.ColorUtilities;
import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.panels.StaticPanel;
import graphicsEngine.presets.panels.AbstractHeader;
import graphicsEngine.parts.labels.SimpleLabel;

import graphics.common.CommonWindow;
import graphics.devMode.common.DevPage;
import graphics.devMode.page1.header.CommonHeader;
import graphics.devMode.page1.header.HeaderButtonListener;

//TODO: add javadocs
public class Page1 extends DevPage {
    private HeaderButtonListener headerButtonListener;

    private Page1() {
        this(null, null, null);
    }

    //TODO: add javadoc
    public Page1(@Nullable CommonWindow window,
                 @Nullable List<ActionListener> actionListenerList,
                 @Nullable SimpleColorScheme colors) {
        super(window, actionListenerList, colors);
    }

    //TODO: add javadoc
    @Override
    public final @NotNull String getPageKey() {
        return "page1";
    }

    //TODO: add javadoc
    public static @NotNull String getStaticPageKey() {
        return (new Page1()).getPageKey();
    }

    //TODO: add javadoc
    @Override
    public boolean addParticularListener(@Nullable ActionListener listener) {
        if (listener instanceof HeaderButtonListener) {
            headerButtonListener = (HeaderButtonListener) listener;
            return true;
        }
        return false;
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public @Nullable AbstractHeader getHeader(@Nullable SimpleColorScheme headerColors,
                                              @Nullable BorderProperties borderProperties) {
        return new CommonHeader(headerColors, borderProperties, headerButtonListener);
    }

    //TODO: add javadoc
    @Override
    public void setBodyParameters() {
        //TODO: set body parameters here
    }

    //TODO: add javadoc
    @Override
    public @Nullable Component getPageBody() {
        return new StaticPanel(
                null,
                new SimpleColorScheme(ColorUtilities.DEFAULT_COLOR_TRANSPARENT, Color.white),
                null) {
            {
                setLayout(new BorderLayout(0, 0));
                add(new SimpleLabel("Page 1", getPanelColors().getSecondaryColor()), BorderLayout.NORTH);
                //Add parts to body here
            }
        };
    }
}