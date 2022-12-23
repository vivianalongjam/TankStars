package com.mygdx.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.tankstars.TankStars;

public class Player2VictoryScreen implements Screen {
    private static final int BUTTON_WIDTH = 343;
    private static final int BUTTON_HEIGHT = 91;
    private static final int RESTART_BUTTON_Y = 258;
    private static final int EXIT_BUTTON_Y = 144;
    private static final int BANNER_WIDTH = 413;
    private static final int BANNER_HEIGHT = 59;
    private static final int BANNER_X = 433;
    private static final int BANNER_Y = 612;
    private static final int TANK_WIDTH = 400;
    private static final int TANK_HEIGHT = 400;
    private static final int TANK_Y = 281;
    private static final int TANK_X = 440;
    TankStars game;
    Texture background;
    TextureRegion tank;
    Texture victoryBanner;
    Texture exitButtonActive;
    Texture exitButtonInactive;
    Texture restartButtonActive;
    Texture restartButtonInactive;

    public Player2VictoryScreen(TankStars game){
        this.game = game;
        background = new Texture("pause_bg.png");
    }

    @Override
    public void show() {
        restartButtonInactive = new Texture("restart_game_button_inactive.png");
        restartButtonActive = new Texture("restart_game_button_active.png");
        exitButtonInactive = new Texture("exit_button_inactive.png");
        exitButtonActive = new Texture("exit_button_active.png");
        tank = new TextureRegion( new Texture("abrams_tank.png"));
        victoryBanner = new Texture("player_2_victory_banner.png");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        game.getBatch().draw(background, 0, 0);
        game.getBatch().draw(tank, TANK_X, TANK_Y, TANK_WIDTH, TANK_HEIGHT);
        game.getBatch().draw(victoryBanner, BANNER_X, BANNER_Y, BANNER_WIDTH, BANNER_HEIGHT);
        int x = TankStars.getWIDTH() / 2 - BUTTON_WIDTH / 2;
        if(Gdx.input.getX() < x + BUTTON_WIDTH && Gdx.input.getX() > x && TankStars.getHEIGHT() - Gdx.input.getY() < RESTART_BUTTON_Y + BUTTON_HEIGHT && TankStars.getHEIGHT() - Gdx.input.getY() > RESTART_BUTTON_Y) {
            game.getBatch().draw(restartButtonActive, TankStars.getWIDTH() / 2 - BUTTON_WIDTH / 2, RESTART_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new ChooseTankScreen(game));
            }
        } else {
            game.getBatch().draw(restartButtonInactive, TankStars.getWIDTH() / 2 - BUTTON_WIDTH / 2, RESTART_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        }
        if(Gdx.input.getX() < x + BUTTON_WIDTH && Gdx.input.getX() > x && TankStars.getHEIGHT() - Gdx.input.getY() < EXIT_BUTTON_Y + BUTTON_HEIGHT && TankStars.getHEIGHT() - Gdx.input.getY() > EXIT_BUTTON_Y) {
            game.getBatch().draw(exitButtonActive, TankStars.getWIDTH() / 2 - BUTTON_WIDTH / 2, EXIT_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
            if(Gdx.input.justTouched()){
                this.dispose();
                game.setScreen(new MainMenuScreen(game));
            }
        } else {
            game.getBatch().draw(exitButtonInactive, TankStars.getWIDTH() / 2 - BUTTON_WIDTH / 2, EXIT_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
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
