package graphics.common;

import graphicsEngine.colors.SimpleColorScheme;
import graphicsEngine.panels.BorderProperties;
import graphicsEngine.presets.panels.AbstractHeader;

import javax.swing.BoxLayout;

import org.jetbrains.annotations.Nullable;

//TODO: add javadoc
public class CommonHeader extends AbstractHeader {
    private static final int HEIGHT = 40;

    //TODO: add javadoc
    public CommonHeader(@Nullable SimpleColorScheme colors,
                        @Nullable BorderProperties borderProperties,
                        @Nullable HeaderButtonListener buttonListener) {
        super(colors, HEIGHT, borderProperties);
        addButtons(buttonListener);
    }

    //TODO: add javadoc
    @Override
    public void addParts() {}

    //TODO: make this header abstract and make separate ones for each page, for header button separation
    private void addButtons(@Nullable HeaderButtonListener buttonListener) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(new HeaderButtonListener.Button_Menu(buttonListener));
        add(new HeaderButtonListener.Button_StartingPage(buttonListener));
        add(new HeaderButtonListener.Button_PlayPage(buttonListener));
        add(new HeaderButtonListener.Button_Pause(buttonListener));
    }
}