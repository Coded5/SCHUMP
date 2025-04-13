package com.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

    protected Vector2 position;
    protected Vector2 velocity;
    protected Sprite sprite;

    public Entity(Vector2 position, Vector2 velocity, Sprite sprite) {
        this.position = position;
        this.velocity = velocity;
        this.sprite = sprite;
    }

    public abstract void update();
    public abstract void render(SpriteBatch batch);

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Sprite getSprite() {
        return sprite;
    }
}
