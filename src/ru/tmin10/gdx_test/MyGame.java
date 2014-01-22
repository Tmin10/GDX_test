package ru.tmin10.gdx_test;
import ru.tmin10.screens.*;

import com.badlogic.gdx.Game;

public class MyGame extends Game {
	public GameScreen game;
	@Override
	public void create() {

		game = new GameScreen();
		setScreen(game);
		
	}
	
	@Override
	public void resize(int width, int height) {
		
	}
	
}
