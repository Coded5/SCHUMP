package com.game;

import com.badlogic.gdx.math.Vector2;
import com.game.entities.enemies.Enemy;
import com.game.entities.enemies.AlienCat;
import com.game.entities.enemies.AngryAlienCat;
import com.game.entities.enemies.GunnerShip;
import com.game.screens.GameScreen;

import java.util.Random;

public class EnemyFactory {

    private Random random = new Random();

    public Enemy createEnemy() {
        int type = random.nextInt(3);

        float x = random.nextFloat() * GameScreen.WORLD_WIDTH * 0.8f;
//        float x = ((float) random.nextGaussian() + 1) * 0.5f * 0.8f * GameScreen.WORLD_WIDTH;
        float y = GameScreen.WORLD_HEIGHT;

        switch (type) {
            case 0:
                return new AlienCat(new Vector2(x, y));
            case 1:
                return new AngryAlienCat(new Vector2(x, y));
            case 2:
                return new GunnerShip(new Vector2(x, y));
            default:
                return new AlienCat(new Vector2(x, y));
        }
    }

}
