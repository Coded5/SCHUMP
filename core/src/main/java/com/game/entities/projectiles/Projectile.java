package com.game.entities.projectiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.game.entities.Entity;
import com.game.entities.properties.Collidable;

public abstract class Projectile extends Entity implements Collidable {

    protected boolean fromEnemy;
    protected float speed;

    public Projectile(Vector2 position, Sprite sprite, float speed, boolean fromEnemy) {
        super(position, new Vector2(0, speed), sprite);

        this.speed = speed;
        this.fromEnemy = fromEnemy;
    }

    public Projectile(Vector2 position, Sprite sprite, float speed) {
        super(position, new Vector2(0, speed), sprite);

        this.speed = speed;
        this.fromEnemy = false;
    }

    public boolean isFromEnemy() {
        return fromEnemy;
    }

}
