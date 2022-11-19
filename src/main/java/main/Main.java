package main;

import graphicsEngine.GraphicsAdapter;
import graphicsEngine.windows.WindowUpdater;

import graphics.Window;

//TODO: add javadoc
public class Main {
    //TODO: add javadoc
    public static void main(String[] args) {
        //init some static data here
        startGraphics();
    }

    private static void startGraphics() {
        new GraphicsAdapter() {{
            newWindow(new WindowUpdater(new Window(this)));
        }};
    }
}