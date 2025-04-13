package com.game;

import com.badlogic.gdx.utils.viewport.FitViewport;

public class ViewportSingleton {

    public static final int WORLD_WIDTH = 6;
    public static final int WORLD_HEIGHT = 8;

    private static FitViewport viewport;

    public static FitViewport getInstance() {
        if (viewport == null) {
            viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        }

        return viewport;
    }

}
