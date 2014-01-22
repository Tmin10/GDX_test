package ru.tmin10.model;





import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Player extends Actor {

	public enum State {
		NONE, WALKING, DEAD
	}


	public static final float SIZE = 1f; 
	
	World world;
	Vector2 	position = new Vector2();
	int color;
	//Rectangle 	bounds = new Rectangle();
	State		state = State.NONE;
	boolean		facingLeft = true;

	public Player(Vector2 position, World world, int color) {
		
		this.world = world;
		this.position = position;
		this.color=color;
		//this.bounds.height = SIZE*world.ppuY;
		//this.bounds.width = SIZE*world.ppuX;
		setHeight(SIZE*world.ppuY);
		setWidth(SIZE*world.ppuX);
		setX(position.x*world.ppuX);
		setY(position.y*world.ppuY);
		addListener(new InputListener() {
	        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
	        	//Log.e("td","1");
	        	/*ChangeNavigation(x, y);
	    		processInput();*/
	                return true;
	        }
	        
	        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	        	/*ChangeNavigation(x, y);
	    		processInput();*/
	        }
		});
	}
	/*
	public Rectangle getBounds() {
		return bounds;
	}*/
	
	public Vector2 getPosition() {
		
		return position;
	}
	
	public void update(float delta) {
		setX(position.x*world.ppuX);
		setY(position.y*world.ppuY);
	}
	
	@Override
	public void draw(Batch batch, float parentAlfa) {
		
		if (this.equals(world.selectedActor)) {
			batch.setColor(0.5f, 0.5f, 0.5f, 0.5f);
		}
		
		batch.draw(world.textureRegions.get("brick"+this.color), getX(), getY(),getWidth(), getHeight());
		batch.setColor(1, 1, 1, 1);
	}

	
	public Actor hit(float x, float y, boolean touchable) {
		//Процедура проверки. Если точка в прямоугольнике актёра, возвращаем актёра.
		 
		//	Log.e("hh", Float.toString(world.selectedActor.getX()));
		//Log.e("Player [", x+":"+y+"] --- ["+this.getX()+":"+this.getY()+"]");
		return x > 0 && x < getWidth() && y> 0 && y < getHeight()?this:null;
	}
	
	
	
	

	

	
	
	
	
}
