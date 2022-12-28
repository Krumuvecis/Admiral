package graphics.devMode.common.header;

import javax.swing.BoxLayout;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;

import graphics.common.panels.header.SimpleHeader;
import graphics.common.panels.header.SimpleHeaderButtonListener;
import graphics.common.panels.header.Button_Menu;

/**
 * TODO: finish this and add javadocs
 */
public class Header extends SimpleHeader {

    /**
     * TODO: finish this javadoc
     */
    public Header(@Nullable SimpleColorScheme colors,
                  @Nullable BorderProperties borderProperties,
                  @Nullable HeaderButtonListener buttonListener) {
        super(colors, borderProperties, buttonListener);
    }

    /**
     * TODO:
     *  make this header abstract
     *  make separate headers for each page
     *  finish this javadoc
     */
    @Override
    public void addButtons(@Nullable SimpleHeaderButtonListener simpleButtonListener) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        @Nullable HeaderButtonListener buttonListener = (HeaderButtonListener) simpleButtonListener;
        add(new Button_Menu(buttonListener));
        add(new Button_Pause(buttonListener));
    }
}