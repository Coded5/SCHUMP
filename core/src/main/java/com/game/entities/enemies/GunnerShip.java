package com.game.entities.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.game.Constants;
import com.game.entities.EntityHandler;
import com.game.entities.projectiles.enemy.GunnerBullet;
import com.game.entities.properties.Collidable;

public class GunnerShip extends Enemy {

    private float accumTime = 0;

    public GunnerShip(Vector2 position) {
        super(position, 1, new Sprite(Constants.TEXTURE_GUNNER_SHIP));
        sprite.setSize(0.75f, 0.75f);
    }

    public void enemyUpdate() {
        float shootPeriod = 1f;
        accumTime += Gdx.graphics.getDeltaTime();

        if (accumTime >= shootPeriod) {
            EntityHandler.getInstance().addEntity(new GunnerBullet(position.cpy()));
            accumTime = 0;
        }
    }

    public void render(SpriteBatch batch) {
        sprite.setCenter(position.x, position.y);
        sprite.draw(batch);
    }

    @Override
    public Rectangle getCollider() {
        return new Rectangle(position.x, position.y, sprite.getWidth(), sprite.getHeight());
    }

    @Override
    public boolean isCollide(Collidable collidable) {
        return getCollider().overlaps(collidable.getCollider());
    }
}
