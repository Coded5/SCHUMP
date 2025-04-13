package com.game.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.Constants;

public class Background {

    private Viewport viewport;

    private float y0 = 0;

    private Texture[] textures = {
//        Constants.TEXTURE_BACKGROUND_4,
//        Constants.TEXTURE_BACKGROUND_3,
        Constants.TEXTURE_BACKGROUND_2,
        Constants.TEXTURE_BACKGROUND_1,
    };
    private float[] speeds = {100, 50, 25, 12.5f};
    private float[] yOffsets = {0f, 0f, 0f, 0f};

    public Background(final Viewport viewport) {
        this.viewport = viewport;

        Constants.TEXTURE_BACKGROUND_1.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        for (Texture texture : textures) {
            texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        }
    }

    public void render(SpriteBatch batch) {
        float width = viewport.getWorldWidth();
        float height = viewport.getWorldHeight();

        Color oldColor = batch.getColor();


        for (int i = 0; i < textures.length; i++) {
            batch.setColor(1f, 1f, 1f, 0.75f / (i + 1));
            yOffsets[i] -= speeds[i] * Gdx.graphics.getDeltaTime();

            if (yOffsets[i] <= -height)
                yOffsets[i] += height;

            batch.draw(textures[i], 0, yOffsets[i], width, height);
            batch.draw(textures[i], 0, yOffsets[i] + height, width, height);
        }

        batch.setColor(oldColor);
    }

}
