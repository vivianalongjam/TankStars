package com.mygdx.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.tankstars.TankStars;

public class SavedGamesScreen implements Screen {
    private static final int BUTTON_WIDTH = 204;
    private static final int BUTTON_HEIGHT = 59;
    private static final int BUTTON_Y = 54;
    private static final int BACK_BUTTON_X = 41;
    private static final int GAME_WIDTH = 256;
    private static final int GAME_HEIGHT = 173;
    private static final int GAME_ROW1_Y = 499;
    private static final int x1 = 38;
    private static final int x2 = 354;
    private static final int x3 = 670;
    private static final int x4 = 986;

    Texture background;
    Texture backButtonInactive;
    Texture backButtonActive;
    Texture gameButtonActive1;
    Texture gameButtonInactive1;
    Texture gameButtonActive2;
    Texture gameButtonInactive2;
    Texture gameButtonActive3;
    Texture gameButtonInactive3;
    Texture gameButtonActive4;
    Texture gameButtonInactive4;
    TankStars game;

    public SavedGamesScreen(TankStars game){
        this.game = game;
        background = new Texture("main_menu_bg.png");
    }

    @Override
    public void show() {
        backButtonActive = new Texture("back_button_active.png");
        backButtonInactive = new Texture("back_button_inactive.png");
        gameButtonActive1 = new Texture("saved_game_button_1_active.png");
        gameButtonInactive1 = new Texture("saved_game_button_1_inactive.png");
        gameButtonActive2 = new Texture("saved_game_button_2_active.png");
        gameButtonInactive2 = new Texture("saved_game_button_2_inactive.png");
        gameButtonActive3 = new Texture("saved_game_button_3_active.png");
        gameButtonInactive3 = new Texture("saved_game_button_3_inactive.png");
        gameButtonActive4 = new Texture("saved_game_button_4_active.png");
        gameButtonInactive4 = new Texture("saved_game_button_4_inactive.png");

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        game.getBatch().draw(background, 0, 0);
        if(Gdx.input.getX() < BACK_BUTTON_X + BUTTON_WIDTH && Gdx.input.getX() > BACK_BUTTON_X && TankStars.getHEIGHT() - Gdx.input.getY() < BUTTON_Y + BUTTON_HEIGHT && TankStars.getHEIGHT() - Gdx.input.getY() > BUTTON_Y) {
            game.getBatch().draw(backButtonActive, BACK_BUTTON_X, BUTTON_Y);
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new MainMenuScreen(game));
            }
        } else {
            game.getBatch().draw(backButtonInactive, BACK_BUTTON_X, BUTTON_Y);
        }
        if(Gdx.input.getX() < x1 + GAME_WIDTH && Gdx.input.getX() > x1 && TankStars.getHEIGHT() - Gdx.input.getY() < GAME_ROW1_Y + GAME_HEIGHT && TankStars.getHEIGHT() - Gdx.input.getY() > GAME_ROW1_Y) {
            game.getBatch().draw(gameButtonActive1, x1, GAME_ROW1_Y);
//            if(Gdx.input.isTouched()){
//                this.dispose();
//                game.setScreen(new MainMenuScreen(game));
//            }
        } else {
            game.getBatch().draw(gameButtonInactive1, x1, GAME_ROW1_Y);
        }
        if(Gdx.input.getX() < x2 + GAME_WIDTH && Gdx.input.getX() > x2 && TankStars.getHEIGHT() - Gdx.input.getY() < GAME_ROW1_Y + GAME_HEIGHT && TankStars.getHEIGHT() - Gdx.input.getY() > GAME_ROW1_Y) {
            game.getBatch().draw(gameButtonActive2, x2, GAME_ROW1_Y);
//            if(Gdx.input.isTouched()){
//                this.dispose();
//                game.setScreen(new MainMenuScreen(game));
//            }
        } else {
            game.getBatch().draw(gameButtonInactive2, x2, GAME_ROW1_Y);
        }
        if(Gdx.input.getX() < x3 + GAME_WIDTH && Gdx.input.getX() > x3 && TankStars.getHEIGHT() - Gdx.input.getY() < GAME_ROW1_Y + GAME_HEIGHT && TankStars.getHEIGHT() - Gdx.input.getY() > GAME_ROW1_Y) {
            game.getBatch().draw(gameButtonActive3, x3, GAME_ROW1_Y);
//            if(Gdx.input.isTouched()){
//                this.dispose();
//                game.setScreen(new MainMenuScreen(game));
//            }
        } else {
            game.getBatch().draw(gameButtonInactive3, x3, GAME_ROW1_Y);
        }
        if(Gdx.input.getX() < x4 + GAME_WIDTH && Gdx.input.getX() > x4 && TankStars.getHEIGHT() - Gdx.input.getY() < GAME_ROW1_Y + GAME_HEIGHT && TankStars.getHEIGHT() - Gdx.input.getY() > GAME_ROW1_Y) {
            game.getBatch().draw(gameButtonActive4, x4, GAME_ROW1_Y);
//            if(Gdx.input.isTouched()){
//                this.dispose();
//                game.setScreen(new MainMenuScreen(game));
//            }
        } else {
            game.getBatch().draw(gameButtonInactive4, x4, GAME_ROW1_Y);
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
