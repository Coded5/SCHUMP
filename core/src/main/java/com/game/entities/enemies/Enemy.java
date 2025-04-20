package com.game.entities.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.game.Constants;
import com.game.entities.Entity;
import com.game.entities.EntityHandler;
import com.game.entities.Player;
import com.game.entities.projectiles.Projectile;
import com.game.entities.properties.Collidable;
import com.game.event.EventId;
import com.game.event.EventManager;

import java.util.Iterator;

public abstract class Enemy extends Entity implements Collidable {

    protected float speed;

    public Enemy(Vector2 position, float speed, Sprite sprite) {
        super(
            position,
            new Vector2(0, -speed),
            sprite
        );

        this.speed = speed;
    }

    public void update() {
        for (Iterator<Entity> iterator = EntityHandler.getInstance().getEntitiesIter(); iterator.hasNext(); ) {
            Entity entity = iterator.next();

            if (entity instanceof Projectile) {
                Projectile projectile = (Projectile) entity;

                if (projectile.isCollide(this) && !projectile.isFromEnemy()) {
                    EventManager.getInstance().invoke(EventId.ON_PLAYER_KILL);

                    Constants.SFX_EXPLOSION.play();
                    EntityHandler.getInstance().destroy(projectile);
                    EntityHandler.getInstance().destroy(this);
                }
            }
            else if (entity instanceof Player) {
                Player player = (Player) entity;

                if (player.isCollide(this)) {
                    EventManager.getInstance().invoke(EventId.ON_PLAYER_HIT);

                    EntityHandler.getInstance().destroy(this);
                }
            }
        }

        enemyUpdate();

        position.mulAdd(velocity, Gdx.graphics.getDeltaTime());
    }

    public abstract void enemyUpdate();

}
