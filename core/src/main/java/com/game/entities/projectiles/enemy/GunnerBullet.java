package com.game.entities.projectiles.enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.game.Constants;
import com.game.ViewportSingleton;
import com.game.entities.EntityHandlerSingleton;
import com.game.entities.projectiles.Projectile;
import com.game.entities.properties.Collidable;

public class GunnerBullet extends Projectile {

    public GunnerBullet(Vector2 position) {
        super(position, new Sprite(Constants.TEXTURE_GUNNER_BULLET), -5f, true);
        sprite.setSize(0.1f, 0.1f);
    }

    public void update() {
        position.mulAdd(velocity, Gdx.graphics.getDeltaTime());

        if (position.y <= -sprite.getHeight()) {
            EntityHandlerSingleton.getInstance().destroy(this);
        }
    }

    public void render(SpriteBatch batch) {
        sprite.setCenter(position.x, position.y);
        sprite.draw(batch);
    }

    public Rectangle getCollider() {
        return new Rectangle(position.x, position.y, sprite.getWidth(), sprite.getHeight());
    }

    public boolean isCollide(Collidable collidable) {
        return getCollider().overlaps(collidable.getCollider());
    }

}
