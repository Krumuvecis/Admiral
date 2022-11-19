package graphics.common;

import graphicsEngine.presets.SimpleOverlay;

import java.awt.event.ActionListener;
import javax.swing.BoxLayout;

import org.jetbrains.annotations.Nullable;

//TODO: add javadoc
public class MenuOverlay extends SimpleOverlay {
    //TODO: add javadoc
    public MenuOverlay(@Nullable ActionListener actionListener) {
        super(null);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        //add(new ButtonListener.Button(actionListener));
    }
}