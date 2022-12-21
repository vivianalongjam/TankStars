package com.mygdx.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.tankstars.TankStars;
import com.mygdx.tankstars.entities.Player;

import javax.swing.*;

public class PlayGameScreen implements Screen {
    private static final int BACKGROUND_WIDTH = 1280;
    private static final int BACKGROUND_HEIGHT = 720;
    private static final int TANK_WIDTH = 150;
    private static final int TANK_HEIGHT = 150;
    private static final int TANK_Y = 102;
    private static final int TANK_X_1 = 93;
    private static final int TANK_X_2 = 810;
    private static final int FUEL_HEIGHT = 27;
    private int FUEL_WIDTH = 215;
    private static final int FUEL_Y = 574;
    private static final int FUEL_X = 25;

    private static final int FULL_FUEL_HEIGHT = 31;
    private int FULL_FUEL_WIDTH = 219;
    private static final int FULL_FUEL_Y = 572;
    private static final int FULL_FUEL_X = 23;

    private static final int FUEL_TEXT_HEIGHT = 17;
    private int FUEL_TEXT_WIDTH = 50;
    private static final int FUEL_TEXT_Y = 578;
    private static final int FUEL_TEXT_X = 108;

    private static final int JOYSTICK_HEIGHT = 250;
    private static final int JOYSTICK_WIDTH = 250;
    private static final int JOYSTICK_Y = 20;
    private static final int JOYSTICK_X = 983;
    private static final int MOVE_STICK_HEIGHT = 60;
    private static final int MOVE_STICK_WIDTH = 60;
    private static final int MOVE_STICK_Y = 42;
    private static final int MOVE_STICK_X = 58;
    private static final int PAUSE_WIDTH = 70;
    private static final int PAUSE_HEIGHT = 70;
    private static final int PAUSE_X = 23;
    private static final int PAUSE_Y = 627;
    Texture background;
    Player tank1;
    Player tank2;
    int turn;
    Texture ground;
    Texture fuel;
    Texture full_fuel;
    Texture fuel_text;
    Texture joystick;
    Texture moveStick;
    Texture pauseButtonActive;
    Texture pauseButtonInactive;
    TankStars game;

    public PlayGameScreen(TankStars game){
        this.game = game;
        tank1 = new Player(23, "left");
        tank2 = new Player(1108, "right");
        turn = 1;
    }

    public void decFuel(){
        FUEL_WIDTH -= 1 * Gdx.graphics.getDeltaTime();
    }
    @Override
    public void show() {
        background = new Texture("play.png");
        ground = new Texture("ground.png");
        fuel = new Texture("fuel.png");
        full_fuel = new Texture("fuel_full.png");
        fuel_text = new Texture("fuel_text.png");
        joystick = new Texture("joystick.png");
        moveStick = new Texture("move_stick.png");
        pauseButtonActive = new Texture("pause_button_active.png");
        pauseButtonInactive = new Texture("pause_button_inactive.png");
//        tank1 = new TextureRegion( new Texture("abrams_tank.png"));
//        tank2 = new TextureRegion( new Texture("frost_tank.png"));
//        tank2.flip(true,false);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        game.getBatch().draw(background, 0, 0);
        game.getBatch().draw(ground, 0, 0);
        game.getBatch().draw(full_fuel, FULL_FUEL_X, FULL_FUEL_Y, FULL_FUEL_WIDTH, FULL_FUEL_HEIGHT);
        game.getBatch().draw(fuel, FUEL_X, FUEL_Y, FUEL_WIDTH, FUEL_HEIGHT);
        game.getBatch().draw(fuel_text, FUEL_TEXT_X, FUEL_TEXT_Y, FUEL_TEXT_WIDTH, FUEL_TEXT_HEIGHT);
        game.getBatch().draw(joystick, JOYSTICK_X, JOYSTICK_Y);
        game.getBatch().draw(moveStick, MOVE_STICK_X, MOVE_STICK_Y);
//        game.getBatch().draw(tank1, TANK_X_1, TANK_Y, TANK_WIDTH, TANK_HEIGHT);
//        game.getBatch().draw(tank2, TANK_X_2, TANK_Y, TANK_WIDTH, TANK_HEIGHT);
        tank1.render(game.getBatch());
        tank2.render(game.getBatch());

        if(Gdx.input.getX() < PAUSE_X + PAUSE_WIDTH && Gdx.input.getX() > PAUSE_X && TankStars.getHEIGHT() - Gdx.input.getY() < PAUSE_Y + PAUSE_HEIGHT && TankStars.getHEIGHT() - Gdx.input.getY() > PAUSE_Y){
            game.getBatch().draw(pauseButtonActive, PAUSE_X, PAUSE_Y);
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new PauseGameScreen(game));
            }
        }
        else{
            game.getBatch().draw(pauseButtonInactive, PAUSE_X, PAUSE_Y);
        }

        if(turn == 1) {
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                tank1.decX(Gdx.graphics.getDeltaTime());
                this.decFuel();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                tank1.incX(Gdx.graphics.getDeltaTime());
                this.decFuel();
            }
        }
        else{
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                tank2.decX(Gdx.graphics.getDeltaTime());
                this.decFuel();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                tank2.incX(Gdx.graphics.getDeltaTime());
                this.decFuel();
            }
        }
        game.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
