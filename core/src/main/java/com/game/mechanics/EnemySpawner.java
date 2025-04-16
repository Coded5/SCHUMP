package com.game.mechanics;

import com.badlogic.gdx.Gdx;
import com.game.entities.enemies.Enemy;
import com.game.entities.EntityHandlerSingleton;

public class EnemySpawner {

    private float spawnPeriod = 1;
    private float accum = 0;

    private EnemyFactory enemyFactory;

    public EnemySpawner() {
        this.enemyFactory = new EnemyFactory();
    }

    public void update() {
        accum += Gdx.graphics.getDeltaTime();

        while (accum >= spawnPeriod) {
            Enemy enemy = enemyFactory.createEnemy();
            EntityHandlerSingleton.getInstance().addEntity(enemy);
            accum -= spawnPeriod;
        }
    }

}
