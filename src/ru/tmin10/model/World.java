package ru.tmin10.model;

import java.util.Map;

import ru.tmin10.screens.GameScreen;

import android.util.Log;

import com.badlogic.gdx.scenes.scene2d.Actor;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class World extends Stage {

	public float ppuX;	
	public float ppuY;
	//выбранный актёр
	Actor selectedActor = null;
	//регионы
	Map<String, TextureRegion> textureRegions;
	private int x, y;
	public static float CAMERA_WIDTH = 10f;
	public static  float CAMERA_HEIGHT = 16f;
	
	//обновление положения объектов
	public void update(float delta){
		for(Actor actor: this.getActors())
			if(actor instanceof Player)
				((Player)actor).update(delta);
	}

	public World(int x, int y, boolean b, SpriteBatch spriteBatch, Map<String, TextureRegion> textureRegions){
		super(x,y, b, spriteBatch);
		this.textureRegions = textureRegions;
		ppuX = getWidth() / CAMERA_WIDTH;
		ppuY = getHeight() / CAMERA_HEIGHT;
		
		int Min=1;
		int Max=3;
		//добавим персонажей
		//for (int i=1; i<9; i++)
			//for (int j=4; j<12; j++)
				//addActor(new Player(new Vector2(i,j), this, Min + (int)(Math.random() * ((Max - Min) + 1))));
		
		
		
	}
	
	public void setPP(float x, float y){
		ppuX = x;
		ppuY = y;
	}
	
	
	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		this.x=x;
		this.y=y;
		Log.i("touchDown", Integer.toString(this.x)+", "+Integer.toString(this.y));
		super.touchDown(x, y, pointer, button);
		return true;
	}
	
	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		Log.i("touchDragged", Integer.toString(arg0)+", "+Integer.toString(arg1)+", "+Integer.toString(arg2));
		/*ShapeRenderer renderer = new ShapeRenderer();
		Camera c = this.getCamera(); 
		renderer.setProjectionMatrix(c.combined);
		renderer.begin(ShapeType.Line);
		renderer.setColor(1, 1, 0, 1);
		renderer.line(10, 10, 100, 100);
		renderer.end();
		c.update();
		this.draw();*/
		return true;
	};

	
	@Override
	public boolean touchUp (int x, int y, int pointer, int button) {
		Log.i("touchUp", Integer.toString(x)+", "+Integer.toString(y));
		super.touchUp(x, y, pointer, button);
    	return true;
    }
	
	public Actor hit(float x, float y, boolean touchable) {
		Log.i("hit", Float.toString(x)+", "+Float.toString(y));
		Actor  actor  = super.hit(x,y,touchable);
		//если выбрали актёра
		if(actor != null)
			//запоминаем
			selectedActor = actor;
		return actor;

	}
	
}
