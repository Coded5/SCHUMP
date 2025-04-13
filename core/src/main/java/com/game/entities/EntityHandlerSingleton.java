package com.game.entities;

public class EntityHandlerSingleton {

    private static EntityHandler handler;

    public static EntityHandler getInstance() {
        if (handler == null)
            handler = new EntityHandler();

        return handler;
    }

}
