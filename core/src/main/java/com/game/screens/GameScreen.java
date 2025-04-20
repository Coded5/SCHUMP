package com.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.Constants;
import com.game.entities.EntityHandler;
import com.game.mechanics.EnemySpawner;
import com.game.Main;
import com.game.entities.Player;
import com.game.event.EventId;
import com.game.event.EventManager;
import com.game.gui.InGameGUI;

public class GameScreen implements Screen {

    private final Main game;

    private InGameGUI gui;
    private EnemySpawner spawner;
    private Viewport gameViewport;

    public static final int WORLD_WIDTH = 6;
    public static final int WORLD_HEIGHT = 8;

    private Player player;

    public GameScreen(final Main game) {
        this.game = game;

        EntityHandler.dispose();
        EventManager.dispose();

        this.gui = new InGameGUI();

        this.player = new Player();
        this.spawner = new EnemySpawner();
        this.gameViewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        EntityHandler.getInstance().addEntity(player);

        EventManager.getInstance().subscribe(EventId.ON_PLAYER_HIT, () -> {
            System.out.println(player.getCurrentHealth());
            if (player.getCurrentHealth() <= 0){
                Constants.SFX_DEATH.play();
                game.setScreen(new GameOverScreen(game));
                dispose();
            }
        });
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        update();
        draw();
    }

    private void update() {
        spawner.update();
        EntityHandler.getInstance().update();

    }

    private void draw() {
        gameViewport.apply();

        SpriteBatch batch = game.getBatch();

        batch.setProjectionMatrix(gameViewport.getCamera().combined);

        EntityHandler.getInstance().render(batch);

        game.getViewport().apply();
        batch.setProjectionMatrix(game.getViewport().getCamera().combined);
        gui.renderGUI(game.getViewport(), game.getFont(), batch, player);
    }

    @Override
    public void resize(int width, int height) {
        game.getViewport().update(width, height, true);
        gameViewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        EventManager.getInstance().dispose();
        EntityHandler.getInstance().clear();
    }

    @Override
    public void dispose() {
        EventManager.getInstance().dispose();
        EntityHandler.getInstance().clear();
    }
}
