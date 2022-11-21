package com.mygdx.tankstars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.tankstars.screens.MainMenuScreen;

public class TankStars extends Game {
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	private SpriteBatch batch;
	Texture img;

	public static int getHEIGHT() {
		return HEIGHT;
	}

	public static int getWIDTH() {
		return WIDTH;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
//	@Override
//	public void dispose () {
//		batch.dispose();
//		img.dispose();
//	}
}
