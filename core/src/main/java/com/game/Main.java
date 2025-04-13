package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.game.animation.Background;
import com.game.event.EventId;
import com.game.event.EventManager;
import com.game.screens.GameOverScreen;
import com.game.screens.GameScreen;
import com.game.screens.MenuScreen;

public class Main extends Game {

    private BitmapFont font;
    private SpriteBatch batch;
    private FitViewport viewport;

    private Background background;

    private Music music;

    @Override
    public void create() {
        batch = new SpriteBatch();
        viewport = new FitViewport(576, 768);

        background = new Background(viewport);

        font = new BitmapFont(Gdx.files.internal("font/pressstart.fnt"));
        font.setColor(Color.WHITE);
        font.getData().setScale(0.5f);

        this.music = Gdx.audio.newMusic(Gdx.files.internal("audio/music.mp3"));

        this.setScreen(new MenuScreen(this));

        music.setLooping(true);
        music.setVolume(0.25f);
        music.play();

        EventManager.getInstance().subscribe(EventId.ON_GAME_OVER, Constants.SFX_DEATH::play);
    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.BLACK);
        batch.begin();

        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        background.render(batch);

        super.render();

        batch.end();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public BitmapFont getFont() {
        return font;
    }

    public FitViewport getViewport() {
        return viewport;
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
