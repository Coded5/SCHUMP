package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Constants {

    public static final TextureRegion TEXTURE_SHIP_FULL = new TextureRegion(new Texture("textures/ship_full.png"), 10, 14, 30, 26);
    public static final TextureRegion TEXTURE_DAMAGE_0  = new TextureRegion(new Texture("textures/ship_damage_0.png"), 10, 14, 30, 26);
    public static final Texture TEXTURE_DAMAGE_1  = new Texture("textures/ship_damage_1.png");
    public static final Texture TEXTURE_DAMAGE_2  = new Texture("textures/ship_damage_2.png");

    public static final Texture SPRITESHEET_PROJECTILE_MISSLE = new Texture("textures/projectile_missile.png");
    public static final TextureRegion PROJECTILE_MISSLLE_ANIM_0 = new TextureRegion(SPRITESHEET_PROJECTILE_MISSLE, 0, 0, 32, 32);
    public static final TextureRegion PROJECTILE_MISSLLE_ANIM_1 = new TextureRegion(SPRITESHEET_PROJECTILE_MISSLE, 32, 0, 32, 32);
    public static final TextureRegion PROJECTILE_MISSLLE_ANIM_2 = new TextureRegion(SPRITESHEET_PROJECTILE_MISSLE, 64, 0, 32, 32);

    public static final Texture SPRITESHEET_ENEMY_CAT_UFO = new Texture("textures/AlienCatIdle.png");
    public static final TextureRegion TEXTURE_ALIEN_CAT_0 = new TextureRegion(SPRITESHEET_ENEMY_CAT_UFO, 0, 0, 26, 18);
    public static final TextureRegion TEXTURE_ALIEN_CAT_1 = new TextureRegion(SPRITESHEET_ENEMY_CAT_UFO, 26, 0, 26, 18);
    public static final TextureRegion TEXTURE_ALIEN_CAT_2 = new TextureRegion(SPRITESHEET_ENEMY_CAT_UFO, 52, 0, 26, 18);
    public static final TextureRegion TEXTURE_ALIEN_CAT_3 = new TextureRegion(SPRITESHEET_ENEMY_CAT_UFO, 78, 0, 26, 18);

    public static final Texture SPRITESHEET_ENEMY_RED_CAT_UFO = new Texture("textures/AlienCatJump.png");
    public static final TextureRegion TEXTURE_ANGRY_ALIEN_CAT_0 = new TextureRegion(SPRITESHEET_ENEMY_RED_CAT_UFO, 0, 0, 26, 20);
    public static final TextureRegion TEXTURE_ANGRY_ALIEN_CAT_1 = new TextureRegion(SPRITESHEET_ENEMY_RED_CAT_UFO, 26, 0, 26, 20);
    public static final TextureRegion TEXTURE_ANGRY_ALIEN_CAT_2 = new TextureRegion(SPRITESHEET_ENEMY_RED_CAT_UFO, 52, 0, 26, 20);
    public static final TextureRegion TEXTURE_ANGRY_ALIEN_CAT_3 = new TextureRegion(SPRITESHEET_ENEMY_RED_CAT_UFO, 78, 0, 26, 20);

    public static final Texture TEXTURE_GUNNER_SHIP = new Texture("textures/gunner_ship.png");
    public static final Texture TEXTURE_GUNNER_BULLET = new Texture("textures/gunner_bullet.png");

    public static final Texture TEXTURE_HEART_FULL = new Texture("textures/heart_full.png");
    public static final Texture TEXTURE_HEART_EMPTY = new Texture("textures/heart_empty.png");

    public static final Texture TEXTURE_BACKGROUND_1 = new Texture("textures/background_1.png");
    public static final Texture TEXTURE_BACKGROUND_2 = new Texture("textures/background_2.png");
    public static final Texture TEXTURE_BACKGROUND_3 = new Texture("textures/background_3.png");
    public static final Texture TEXTURE_BACKGROUND_4 = new Texture("textures/background_4.png");

    public static final Sound SFX_EXPLOSION = Gdx.audio.newSound(Gdx.files.internal("audio/sfx_explosion.mp3"));
    public static final Sound SFX_DEATH = Gdx.audio.newSound(Gdx.files.internal("audio/sfx_death.mp3"));
    public static final Sound SFX_HIT = Gdx.audio.newSound(Gdx.files.internal("audio/sfx_hit.mp3"));

}
