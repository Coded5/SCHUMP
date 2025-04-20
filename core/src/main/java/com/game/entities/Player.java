package com.game.entities;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.game.Constants;
import com.game.entities.projectiles.Projectile;
import com.game.entities.projectiles.player.Missile;
import com.game.entities.properties.Collidable;
import com.game.event.EventId;
import com.game.event.EventManager;
import com.game.screens.GameScreen;

import java.util.Iterator;

public class Player extends Entity implements Collidable {

    private final float speed = 4f;
    private int maxHealth = 6;
    private int currentHealth = 6;
    private int kills = 0;

    public Player() {
        super(
            new Vector2(1, 1),
            Vector2.Zero.cpy(),
            new Sprite(Constants.TEXTURE_SHIP_FULL)
        );

        sprite.setSize(0.75f, 0.75f);

        currentHealth = maxHealth;
        kills = 0;

        EventManager.getInstance().subscribe(EventId.ON_PLAYER_KILL, () -> {
            kills++;
        });

        EventManager.getInstance().subscribe(EventId.ON_PLAYER_HIT, () -> {
            Constants.SFX_HIT.play(0.3f);
            currentHealth--;
        });
    }

    public void update() {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            velocity.x = -speed;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            velocity.x = speed;
        }
        else {
            velocity.x = 0;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            velocity.y = speed;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            velocity.y = -speed;
        }
        else {
            velocity.y = 0;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            EntityHandler.getInstance().addEntity(new Missile(position.cpy()));
        }

        Iterator<Entity> iterator = EntityHandler.getInstance().getEntitiesIter();

        while (iterator.hasNext()) {
            Entity entity = iterator.next();

            if (entity instanceof Projectile) {
                Projectile projectile = (Projectile) entity;

                if (projectile.isCollide(this) && projectile.isFromEnemy())  {
                    EventManager.getInstance().invoke(EventId.ON_PLAYER_HIT);

                    EntityHandler.getInstance().destroy(entity);
                }
            }

        }

        position.mulAdd(velocity, Gdx.graphics.getDeltaTime());


        position.x = MathUtils.clamp(position.x, sprite.getWidth() / 2, GameScreen.WORLD_WIDTH - (sprite.getWidth() / 2));
        position.y = MathUtils.clamp(position.y, sprite.getHeight() / 2, GameScreen.WORLD_HEIGHT - (sprite.getHeight() / 2));
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

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getKills() {
        return kills;
    }

}
