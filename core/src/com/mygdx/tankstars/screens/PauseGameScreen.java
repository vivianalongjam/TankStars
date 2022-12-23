package com.mygdx.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.tankstars.TankStars;

import java.io.Serializable;

public class PauseGameScreen implements Screen, Serializable {
    private PlayGameScreen pg;
    private static final int BUTTON_WIDTH = 343;
    private static final int BUTTON_HEIGHT = 91;
    private static final int SAVE_GAME_BUTTON_Y = 372;
    private static final int RESUME_BUTTON_Y = 486;
    private static final int RESTART_BUTTON_Y = 258;
    private static final int EXIT_BUTTON_Y = 144;
    TankStars game;
    Texture background;
    Texture resumeButtonActive;
    Texture resumeButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;
    Texture saveGameButtonActive;
    Texture saveGameButtonInactive;
    Texture restartButtonActive;
    Texture restartButtonInactive;
    int option1;
    int option2;

    public PauseGameScreen(TankStars game, int option1, int option2, PlayGameScreen pg){
        this.game = game;
        background = new Texture("pause_bg.png");
        this.option1 = option1;
        this.option2 = option2;
        this.pg = pg;
    }

    @Override
    public void show() {
        saveGameButtonInactive = new Texture("save_game_button_inactive.png");
        saveGameButtonActive = new Texture("save_game_button_active.png");
        restartButtonInactive = new Texture("restart_game_button_inactive.png");
        restartButtonActive = new Texture("restart_game_button_active.png");
        resumeButtonInactive = new Texture("resume_button_inactive.png");
        resumeButtonActive = new Texture("resume_button_active.png");
        exitButtonInactive = new Texture("exit_button_inactive.png");
        exitButtonActive = new Texture("exit_button_active.png");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        game.getBatch().draw(background, 0, 0);
        int x = TankStars.getWIDTH() / 2 - BUTTON_WIDTH / 2;
        if(Gdx.input.getX() < x + BUTTON_WIDTH && Gdx.input.getX() > x && TankStars.getHEIGHT() - Gdx.input.getY() < SAVE_GAME_BUTTON_Y + BUTTON_HEIGHT && TankStars.getHEIGHT() - Gdx.input.getY() > SAVE_GAME_BUTTON_Y) {
            game.getBatch().draw(saveGameButtonActive, TankStars.getWIDTH() / 2 - BUTTON_WIDTH / 2, SAVE_GAME_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new SavedGamesScreen(game,this.pg));
            }
        } else {
            game.getBatch().draw(saveGameButtonInactive, TankStars.getWIDTH() / 2 - BUTTON_WIDTH / 2, SAVE_GAME_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        }
        if(Gdx.input.getX() < x + BUTTON_WIDTH && Gdx.input.getX() > x && TankStars.getHEIGHT() - Gdx.input.getY() < RESTART_BUTTON_Y + BUTTON_HEIGHT && TankStars.getHEIGHT() - Gdx.input.getY() > RESTART_BUTTON_Y) {
            game.getBatch().draw(restartButtonActive, TankStars.getWIDTH() / 2 - BUTTON_WIDTH / 2, RESTART_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new ChooseTankScreen(game));
            }
        } else {
            game.getBatch().draw(restartButtonInactive, TankStars.getWIDTH() / 2 - BUTTON_WIDTH / 2, RESTART_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        }
        if(Gdx.input.getX() < x + BUTTON_WIDTH && Gdx.input.getX() > x && TankStars.getHEIGHT() - Gdx.input.getY() < RESUME_BUTTON_Y + BUTTON_HEIGHT && TankStars.getHEIGHT() - Gdx.input.getY() > RESUME_BUTTON_Y) {
            game.getBatch().draw(resumeButtonActive, TankStars.getWIDTH() / 2 - BUTTON_WIDTH / 2, RESUME_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new PlayGameScreen(this.pg, option1, option2));
            }
        } else {
            game.getBatch().draw(resumeButtonInactive, TankStars.getWIDTH() / 2 - BUTTON_WIDTH / 2, RESUME_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
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
