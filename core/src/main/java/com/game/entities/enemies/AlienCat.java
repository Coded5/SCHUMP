package com.game.entities.enemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.game.Constants;
import com.game.animation.Animation;
import com.game.animation.Keyframe;
import com.game.entities.properties.Collidable;

public class AlienCat extends Enemy {

    private Animation animation;

    public AlienCat(Vector2 position) {
        super(position, 1, new Sprite(Constants.TEXTURE_ALIEN_CAT_0));

        animation = new Animation();
        animation.addKeyframe(new Keyframe(Constants.TEXTURE_ALIEN_CAT_0, 0.1f));
        animation.addKeyframe(new Keyframe(Constants.TEXTURE_ALIEN_CAT_1, 0.1f));
        animation.addKeyframe(new Keyframe(Constants.TEXTURE_ALIEN_CAT_2, 0.1f));
        animation.addKeyframe(new Keyframe(Constants.TEXTURE_ALIEN_CAT_3, 0.1f));

        sprite.setSize(0.75f, 0.52f);
    }

    public void enemyUpdate() {
        animation.run();
        sprite.setRegion(animation.getCurrent());
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
