package com.game.gui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.Constants;
import com.game.entities.Player;

public class InGameGUI {

    private final Sprite fullHeart;
    private final Sprite emptyHeart;

    public InGameGUI() {
        fullHeart = new Sprite(Constants.TEXTURE_HEART_FULL);
        emptyHeart = new Sprite(Constants.TEXTURE_HEART_EMPTY);

        fullHeart.setSize(32, 32);
        emptyHeart.setSize(32, 32);
    }

    public void renderGUI(Viewport viewport, BitmapFont font,  SpriteBatch batch, Player player) {
        int c = player.getCurrentHealth();

        for (int i = 0; i < player.getMaxHealth(); i++) {
            if (c <= 0) {
                emptyHeart.setCenter(48 + 48 * i, 48);
                emptyHeart.draw(batch);
            }
            else {
                fullHeart.setCenter(48 + 48 * i, 48);
                fullHeart.draw(batch);
            }
            c--;
        }

        float width = viewport.getWorldWidth();

        font.getData().setScale(0.75f);
        GlyphLayout layout = new GlyphLayout(font, player.getKills() + " KILLS");
        font.draw(batch, layout, width - 48 - layout.width, 48);
    }

}
