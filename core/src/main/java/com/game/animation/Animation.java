package com.game.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class Animation {

    private float accumTime = 0f;
    private int currentIndex = 0;
    private ArrayList<Keyframe> keyframes;

    public Animation() {
        this.keyframes = new ArrayList<>();
    }

    public void run() {
        if (keyframes.isEmpty()) {
            return;
        }

        accumTime += Gdx.graphics.getDeltaTime();

        while (accumTime >= keyframes.get(currentIndex).getDuration()) {
            currentIndex++;

            if (currentIndex >= keyframes.size())
                currentIndex = 0;
            accumTime = 0;
        }
    }

    public void addKeyframe(Keyframe keyframe) {
        this.keyframes.add(keyframe);
    }

    public TextureRegion getCurrent() {
        return keyframes.get(currentIndex).getTexture();
    }

}
