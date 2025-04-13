package com.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.game.Main;
import com.game.gui.ButtonGUI;

public class MenuScreen implements Screen  {

    private final Main game;
    private GlyphLayout title;

    private ButtonGUI playButton;
    private ButtonGUI quitButton;

    public MenuScreen(final Main game) {
        this.game = game;

        BitmapFont font = game.getFont();

        font.getData().setScale(2f);
        title = new GlyphLayout(font, "SCHUMP");

        font.getData().setScale(0.75f);
        playButton = new ButtonGUI("Play", font, game.getViewport(), () -> {
            game.setScreen(new GameScreen(game));
        });

        quitButton = new ButtonGUI("Quit", font, game.getViewport(), () -> {
            System.exit(0);
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
        playButton.update();
        quitButton.update();
    }

    private void draw() {
        SpriteBatch batch = game.getBatch();
        BitmapFont font = game.getFont();

        batch.setProjectionMatrix(game.getViewport().getCamera().combined);

        float width = game.getViewport().getWorldWidth();
        float height = game.getViewport().getWorldHeight();

        font.getData().setScale(2f);
        font.setColor(Color.WHITE);
        font.draw(batch, title, (width - title.width) / 2, height / 1.5f);

        font.getData().setScale(0.75f);

        playButton.render(0, height / 3f, batch);
        quitButton.render(0, height / 4f, batch);
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
