package com.mygdx.tankstars.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.tankstars.TankStars;

public class Player {
    private static final int TANK_WIDTH = 150;
    private static final int TANK_HEIGHT = 150;
    public static final int SPEED = 100;
    public static final int FUEL_DEC = 400;
    public static final int FUEL_MAX = 1420;
    public static final int DEFAULT_Y = 105;
    private TextureRegion tank;
    private String player_region;
    private float x, y;
    private float fuel;

    public Player(float x, String n){
        this.x = x;
        this.y = DEFAULT_Y;
        this.player_region = n;

        this.tank = new TextureRegion( new Texture("abrams_tank.png"));
        if(n.equals("right")){
            this.tank.flip(true, false);
        }
        this.fuel = FUEL_MAX;
    }

    public float getFuel() {
        return fuel;
    }

    public void incX (float deltaTime){
        if(this.fuel > 0) {
            this.x += SPEED * deltaTime;
            this.fuel -= FUEL_DEC * deltaTime;
        }
        if(this.x + 150 > TankStars.getWIDTH()) this.x = TankStars.getWIDTH() - 150;
    }

    public void decX (float deltaTime){
        if(this.fuel > 0) {
            this.x -= SPEED * deltaTime;
            this.fuel -= FUEL_DEC * deltaTime;
        }
        if(this.x < 0) this.x = 0;
    }

    public void render (SpriteBatch batch){
        batch.draw(this.tank, this.x, this.y, TANK_WIDTH, TANK_HEIGHT);
    }
}
