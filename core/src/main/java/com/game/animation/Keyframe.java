package com.game.animation;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Keyframe {

    private TextureRegion texture;
    private float duration;

    public Keyframe(TextureRegion texture, float duration) {
        this.texture = texture;
        this.duration = duration;
    }

    public TextureRegion getTexture() {
        return texture;
    }

    public float getDuration() {
        return duration;
    }

}
