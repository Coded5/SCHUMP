package com.game.entities.enemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.game.Constants;
import com.game.animation.Animation;
import com.game.animation.Keyframe;
import com.game.entities.properties.Collidable;

public class AngryAlienCat extends Enemy {

    private Animation animation;

    public AngryAlienCat(Vector2 position) {
        super(position, 2, new Sprite(Constants.TEXTURE_ALIEN_CAT_0));

        animation = new Animation();
        animation.addKeyframe(new Keyframe(Constants.TEXTURE_ANGRY_ALIEN_CAT_0, 0.1f));
        animation.addKeyframe(new Keyframe(Constants.TEXTURE_ANGRY_ALIEN_CAT_1, 0.1f));
        animation.addKeyframe(new Keyframe(Constants.TEXTURE_ANGRY_ALIEN_CAT_2, 0.1f));
        animation.addKeyframe(new Keyframe(Constants.TEXTURE_ANGRY_ALIEN_CAT_3, 0.1f));

        sprite.setSize(0.75f, 0.52f);
    }

    public void enemyUpdate() {
        animation.run();
    }

    public void render(SpriteBatch batch) {
        sprite.setRegion(animation.getCurrent());
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
