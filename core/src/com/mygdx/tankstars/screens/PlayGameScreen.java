package com.mygdx.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.tankstars.TankStars;
import com.mygdx.tankstars.entities.Ground;
import com.mygdx.tankstars.entities.Player;
import com.mygdx.tankstars.entities.Weapon;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertEquals;

public class PlayGameScreen implements Screen, Serializable {
    private static final int BACKGROUND_WIDTH = 1280;
    private static final int BACKGROUND_HEIGHT = 720;
    private static final int TANK_WIDTH = 150;
    private static final int TANK_HEIGHT = 150;
    private static final int TANK_Y = 102;
    private static final int TANK_X_1 = 93;
    private static final int TANK_X_2 = 810;
    private int HEALTH_WIDTH_1 = 332;
    private int HEALTH_WIDTH_2 = 332;
    private static final int HEALTH_HEIGHT = 44;
    private static final int HEALTH_X_1 = 243;
    private static final int HEALTH_Y = 640;
    private static final int HEALTH_X_2 = 705;
    private static final int FUEL_HEIGHT = 27;
    public int FUEL_WIDTH = 215;
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

    private static final int POWER_HEIGHT = 27;
    private int POWER_WIDTH = 215;
    private static final int POWER_Y = 533;
    private static final int POWER_X = 25;

    private static final int FULL_POWER_HEIGHT = 31;
    private int FULL_POWER_WIDTH = 219;
    private static final int FULL_POWER_Y = 531;
    private static final int FULL_POWER_X = 23;

    private static final int POWER_TEXT_HEIGHT = 17;
    private int POWER_TEXT_WIDTH = 75;
    private static final int POWER_TEXT_Y = 538;
    private static final int POWER_TEXT_X = 95;

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
    Weapon weapon;
    boolean isFired = false;
    boolean isOver = false;
    float aim_degree = 0;
    float aim_power = 860;
    //    ArrayList<Weapon> weapons;
    int turn;
    Ground ground;
    Texture health1;
    Texture health2;
    Texture fuel;
    Texture full_fuel;
    Texture fuel_text;
    Texture power;
    Texture full_power;
    Texture power_text;
    Texture pauseButtonActive;
    Texture pauseButtonInactive;
    TankStars game;
    int option1;
    int option2;

    public PlayGameScreen(TankStars game, int option1, int option2){
        this.game = game;
        this.option1 = option1;
        this.option2 = option2;
        tank1 = new Player(23, "left", option1);
        tank2 = new Player(1108, "right", option2);
        ground = Ground.getInstance();
        turn = 1;
//        weapons = new ArrayList<Weapon>();
    }

    public PlayGameScreen(TankStars game) {
        this.game = game;
        testDecFuel();
    }

    public void decFuel(){
        FUEL_WIDTH -= 1 * Gdx.graphics.getDeltaTime();
    }
    @Test
    public void testDecFuel() {
        // Create a test object and set the initial fuel width
        PlayGameScreen playGameScreen = new PlayGameScreen(null);
        playGameScreen.FUEL_WIDTH = 100;

        // Call the method to be tested
        playGameScreen.decFuel();

        // Check that the fuel width has decreased by 1
        assertEquals(99, playGameScreen.FUEL_WIDTH);
        System.out.println("junit testDecFuel passed");
    }
    public void decPower(){
        if(POWER_WIDTH > 0) {
//            POWER_WIDTH -= 1 * Gdx.graphics.getDeltaTime();
            POWER_WIDTH -= 1;
        }
    }
    public void incPower(){
        if(POWER_WIDTH < 215) {
//            POWER_WIDTH += 1 * Gdx.graphics.getDeltaTime();
            POWER_WIDTH += 1;
        }
    }

    public void reSet(Player tank){
        tank.refillFuel();
        FUEL_WIDTH = 215;
        POWER_WIDTH = 215;
        this.aim_degree = 0;
        this.aim_power = 860;
    }
    @Override
    public void show() {
        background = new Texture("play.png");
//        ground = new Texture("ground.png");
        fuel = new Texture("fuel.png");
        full_fuel = new Texture("fuel_full.png");
        fuel_text = new Texture("fuel_text.png");
        power = new Texture("power.png");
        full_power = new Texture("power_full.png");
        power_text = new Texture("power_text.png");
        pauseButtonActive = new Texture("pause_button_active.png");
        pauseButtonInactive = new Texture("pause_button_inactive.png");
        health1 = new Texture("health.png");
        health2 = new Texture("health.png");
//        tank2.flip(true,false);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        game.getBatch().draw(background, 0, 0);
//        game.getBatch().draw(ground, 0, 0);
        game.getBatch().draw(full_fuel, FULL_FUEL_X, FULL_FUEL_Y, FULL_FUEL_WIDTH, FULL_FUEL_HEIGHT);
        game.getBatch().draw(fuel, FUEL_X, FUEL_Y, FUEL_WIDTH, FUEL_HEIGHT);
        game.getBatch().draw(fuel_text, FUEL_TEXT_X, FUEL_TEXT_Y, FUEL_TEXT_WIDTH, FUEL_TEXT_HEIGHT);
        game.getBatch().draw(full_power, FULL_POWER_X, FULL_POWER_Y, FULL_POWER_WIDTH, FULL_POWER_HEIGHT);
        game.getBatch().draw(power, POWER_X, POWER_Y, POWER_WIDTH, POWER_HEIGHT);
        game.getBatch().draw(power_text, POWER_TEXT_X, POWER_TEXT_Y, POWER_TEXT_WIDTH, POWER_TEXT_HEIGHT);
        game.getBatch().draw(health1, HEALTH_X_1, HEALTH_Y, HEALTH_WIDTH_1, HEALTH_HEIGHT);
        game.getBatch().draw(health2, HEALTH_X_2, HEALTH_Y, HEALTH_WIDTH_2, HEALTH_HEIGHT);
        tank1.render(game.getBatch());
        tank2.render(game.getBatch());
        ground.render(game.getBatch());

        if(Gdx.input.getX() < PAUSE_X + PAUSE_WIDTH && Gdx.input.getX() > PAUSE_X && TankStars.getHEIGHT() - Gdx.input.getY() < PAUSE_Y + PAUSE_HEIGHT && TankStars.getHEIGHT() - Gdx.input.getY() > PAUSE_Y){
            game.getBatch().draw(pauseButtonActive, PAUSE_X, PAUSE_Y);
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new PauseGameScreen(game, option1, option2,this));
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
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !isFired){
                weapon = new Weapon(tank1.getX() + TANK_WIDTH - 10, tank1.getY() + (TANK_HEIGHT/2), this.aim_degree, this.aim_power * 1.5f);
//                weapon.setPower(this.aim_power * 1.5f);
//                weapon.setAngle(this.aim_degree);
                isFired = true;
            }
            if(isFired){
                weapon.render(game.getBatch());
                weapon.fire(Gdx.graphics.getDeltaTime());
                if(weapon.initialPoint.y < 129){
                    if(weapon.initialPoint.x + 15 >= tank2.getX() + 50 && weapon.initialPoint.x + 15 <= tank2.getX() + 100){
                        isOver = tank2.decHealth(400);
                        tank2.impact(50);
                        if(isOver || HEALTH_WIDTH_2 - 133 <= 0){
                            this.dispose();
                            game.setScreen(new Player1VictoryScreen(game));
                        }
                        else{
                            HEALTH_WIDTH_2 -= 133;
                        }
                    } else if (weapon.initialPoint.x + 30 >= tank2.getX() && weapon.initialPoint.x < 35 || weapon.initialPoint.x + 15 > tank2.getX() + 100 && weapon.initialPoint.x + 30 < tank2.getX() + 150) {
                        tank2.decHealth(200);
                        tank2.impact(25);
                        if(isOver || HEALTH_WIDTH_2 - 66 <= 0){
                            this.dispose();
                            game.setScreen(new Player1VictoryScreen(game));
                        }
                        else{
                            HEALTH_WIDTH_2 -= 66;
                        }
                    }
                    weapon = null;
                    isFired = false;
                    this.reSet(tank2);
                    turn = 2;
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)){
                this.incPower();
                this.aim_power += 4;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A)){
                this.decPower();
                this.aim_power -= 4;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.UP)){
                this.aim_degree += 1;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
                this.aim_degree -= 1;
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
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !isFired){
                weapon = new Weapon(tank2.getX() + 10, tank2.getY() + (TANK_HEIGHT/2), -this.aim_degree, -this.aim_power * 1.5f);
//                weapon.setPower(this.aim_power * 1.5f);
//                weapon.setAngle(this.aim_degree);
                isFired = true;
            }
            if(isFired){
                weapon.render(game.getBatch());
                weapon.fire(Gdx.graphics.getDeltaTime());
                if(weapon.initialPoint.y < 129){
                    if(weapon.initialPoint.x + 15 >= tank1.getX() + 50 && weapon.initialPoint.x + 15 <= tank1.getX() + 100){
                        isOver = tank1.decHealth(400);
                        tank1.impact(-50);
                        if(isOver || HEALTH_WIDTH_1 - 133 <= 0){
                            this.dispose();
                            game.setScreen(new Player2VictoryScreen(game));
                        }
                        else{
                            HEALTH_WIDTH_1 -= 133;
                        }
                    } else if (weapon.initialPoint.x + 30 >= tank1.getX() && weapon.initialPoint.x < 35 || weapon.initialPoint.x + 15 > tank1.getX() + 100 && weapon.initialPoint.x + 30 < tank1.getX() + 150) {
                        isOver = tank1.decHealth(200);
                        tank1.impact(-25);
                        if(isOver || HEALTH_WIDTH_1 - 66 <= 0){
                            this.dispose();
                            game.setScreen(new Player2VictoryScreen(game));
                        }
                        else{
                            HEALTH_WIDTH_1 -= 66;
                        }
                    }
                    weapon = null;
                    isFired = false;
                    this.reSet(tank1);
                    turn = 1;
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)){
                this.incPower();
                this.aim_power += 4;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A)){
                this.decPower();
                this.aim_power -= 4;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.UP)){
                this.aim_degree += 1;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
                this.aim_degree -= 1;
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
