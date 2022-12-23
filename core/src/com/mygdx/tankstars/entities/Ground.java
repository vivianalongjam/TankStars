package com.mygdx.tankstars.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ground {
    Texture ground;
    private static Ground instance;
    private Ground(){
        ground = new Texture("ground.png");
    }
    public static Ground getInstance(){
        if (instance == null){
            instance = new Ground();
        }
        return instance;
    }
    public void render(SpriteBatch batch){
        batch.draw(ground, 0, 0);
    }
}
