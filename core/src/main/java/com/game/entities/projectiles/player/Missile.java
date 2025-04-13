package com.game.entities.projectiles.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.game.Constants;
import com.game.ViewportSingleton;
import com.game.animation.Animation;
import com.game.animation.Keyframe;
import com.game.entities.EntityHandlerSingleton;
import com.game.entities.projectiles.Projectile;
import com.game.entities.properties.Collidable;

public class Missile extends Projectile {

    private Animation animation;

    public Missile(Vector2 position) {
        super(
            position,
            new Sprite(Constants.PROJECTILE_MISSLLE_ANIM_0),
            8f
        );

        animation = new Animation();
        animation.addKeyframe(new Keyframe(Constants.PROJECTILE_MISSLLE_ANIM_0, 0.01f));
        animation.addKeyframe(new Keyframe(Constants.PROJECTILE_MISSLLE_ANIM_1, 0.01f));
        animation.addKeyframe(new Keyframe(Constants.PROJECTILE_MISSLLE_ANIM_2, 0.01f));

        velocity.y = speed;
        sprite.setSize(1, 1);
    }

    public void update() {
        animation.run();
        position.mulAdd(velocity, Gdx.graphics.getDeltaTime());

        if (position.y >= ViewportSingleton.getInstance().getWorldHeight()) {
            EntityHandlerSingleton.getInstance().destroy(this);
        }
    }

    public void render(SpriteBatch batch) {
        sprite.setRegion(animation.getCurrent());
        sprite.setCenter(position.x, position.y);
        sprite.draw(batch);
    }

    public Rectangle getCollider() {
        return new Rectangle(position.x, position.y, sprite.getWidth() / 4, sprite.getHeight() / 2);
    }

    public boolean isCollide(Collidable collidable) {
        return getCollider().overlaps(collidable.getCollider());
    }
}
