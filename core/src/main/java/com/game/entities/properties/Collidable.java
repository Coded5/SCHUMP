package com.game.entities.properties;

import com.badlogic.gdx.math.Rectangle;

public interface Collidable {

    public Rectangle getCollider();
    public boolean isCollide(Collidable collidable);

}
