package com.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ButtonGUI {

    private Viewport viewport;
    private BitmapFont font;
    private ButtonPress onClick;
    private String text;

    private GlyphLayout layout;
    private Rectangle bound;
    private boolean hover = false;

    public ButtonGUI(String text, BitmapFont font, final Viewport viewport, ButtonPress onClick) {
        this.text = text;
        this.onClick = onClick;
        this.font = font;
        this.viewport = viewport;

        layout = new GlyphLayout(font, text);
    }

    public void update() {
        if (bound == null)
            return;

        Vector2 mousePos = new Vector2(Gdx.input.getX(), Gdx.input.getY());

        hover = bound.contains(viewport.unproject(mousePos));

        if (Gdx.input.isTouched() && hover)
            onClick.onClick();
    }

    public void render(float x, float y, SpriteBatch batch) {
        String buttonText = hover ? ("> " + text + " <") : text;
        layout = new GlyphLayout(font, buttonText);

        float width = viewport.getWorldWidth();

        float xx = (width - layout.width) / 2 + x;
        float yy = y;
        font.draw(batch, layout, xx, yy);

        bound = new Rectangle(xx, yy - layout.height, layout.width * 1.5f, layout.height * 1.5f);    }

}
