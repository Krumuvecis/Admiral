package graphics.common;

import javax.swing.BoxLayout;

import org.jetbrains.annotations.Nullable;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.presets.panels.AbstractHeader;

/**
 * TODO: finish this and add javadocs
 */
public class CommonHeader extends AbstractHeader {
    private static final int HEIGHT = 40;

    /**
     * TODO: finish this javadoc
     */
    public CommonHeader(@Nullable SimpleColorScheme colors,
                        @Nullable BorderProperties borderProperties,
                        @Nullable HeaderButtonListener buttonListener) {
        super(colors, HEIGHT, borderProperties);
        addButtons(buttonListener);
    }

    /**
     * TODO: finish this javadoc
     */
    @Override
    public void addParts() {}

    /**
     * TODO:
     *  make this header abstract
     *  make separate headers for each page
     *  separate header buttons
     *  finish this javadoc?
     */
    private void addButtons(@Nullable HeaderButtonListener buttonListener) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(new HeaderButtonListener.Button_Menu(buttonListener));
        add(new HeaderButtonListener.Button_StartingPage(buttonListener));
        add(new HeaderButtonListener.Button_PlayPage(buttonListener));
        add(new HeaderButtonListener.Button_Pause(buttonListener));
    }
}