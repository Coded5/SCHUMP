package com.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.game.Main;
import com.game.gui.ButtonGUI;

public class GameOverScreen implements Screen {

    private final Main game;
    private GlyphLayout gameOver;

    private ButtonGUI tryAgain;
    private ButtonGUI mainMenu;

    public GameOverScreen(final Main game) {
        this.game = game;

        BitmapFont font = game.getFont();

        font.getData().setScale(1.75f);
        gameOver = new GlyphLayout(font, "Game Over");

        font.getData().setScale(0.75f);
        tryAgain = new ButtonGUI("Play", font, game.getViewport(), () -> {
            game.setScreen(new GameScreen(game));
        });

        mainMenu = new ButtonGUI("Quit", font, game.getViewport(), () -> {
            game.setScreen(new MenuScreen(game));
        });
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        draw();
        update();
    }

    private void update() {
        tryAgain.update();
        mainMenu.update();
    }

    private void draw() {
        SpriteBatch batch = game.getBatch();
        BitmapFont font = game.getFont();

        batch.setProjectionMatrix(game.getViewport().getCamera().combined);

        float width = game.getViewport().getWorldWidth();
        float height = game.getViewport().getWorldHeight();

        font.getData().setScale(1.5f);
        font.setColor(Color.WHITE);
        font.draw(batch, gameOver, (width - gameOver.width) / 2, height / 1.5f);

        font.getData().setScale(0.75f);

        tryAgain.render(0, height / 3f, batch);
        mainMenu.render(0, height / 4f, batch);
    }

    @Override
    public void resize(int width, int height) {
        game.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
