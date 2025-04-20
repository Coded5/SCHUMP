package com.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import javax.swing.plaf.InsetsUIResource;
import java.util.ArrayList;
import java.util.Iterator;

public class EntityHandler {

    private static EntityHandler instance;

    private ArrayList<Entity> entities = new ArrayList<>();
    private ArrayList<Entity> toBeAdd = new ArrayList<>();
    private ArrayList<Entity> toBeRemove = new ArrayList<>();

    private boolean clearFlag = false;

    private EntityHandler() {

    }

    public void update() {
        for (Entity entity : entities) {
            entity.update();
        }

        entities.addAll(toBeAdd);
        toBeAdd.clear();

        entities.removeAll(toBeRemove);
        toBeRemove.clear();

        if (clearFlag) {
            this.entities.clear();
            this.toBeRemove.clear();
            this.toBeAdd.clear();

            clearFlag = false;
        }
    }

    public void render(SpriteBatch batch) {
        for (Entity entity : entities) {
            entity.render(batch);
        }
    }

    public void clear() {
        clearFlag = true;
    }

    public Iterator<Entity> getEntitiesIter() {
        return entities.iterator();
    }

    public void addEntity(Entity entity) {
        toBeAdd.add(entity);
    }

    public void destroy(Entity entity) {
        toBeRemove.add(entity);
    }

    public static void dispose() {
        instance = null;
    }

    public static EntityHandler getInstance() {
        if (instance == null) {
            instance = new EntityHandler();
        }

        return instance;
    }

}
