package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite sprite;
	Sprite ball;
	Texture texture, img, ballimg;
	int x = 291;
	public int ballx;
	public int bally;
	private int balldx = -1;
	private int balldy = -2;
	public boolean play = false;


	@Override
	public void create () {

		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("Arkanoid1.png"));
		img = new Texture(Gdx.files.internal("player.png"));
		ballimg = new Texture(Gdx.files.internal("ball.png"));
		sprite = new Sprite(img);
		ball = new Sprite(ballimg);
		//ball.setPosition(291,0);
	}
	@Override
	public void render () {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//keyboard control
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && sprite.getX() < 582){
			x+=5;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && sprite.getX() > 25){
			x-=5;
		}

		if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
			play = true;
		}
		if(play == false){ // ball is on the paddle and game hasn't started yet
			ball.setPosition(x + 27,10);
			ballx = x + 27;
			bally = 10;
		}else{
			ballmovement();
		}

		sprite.setPosition(x, 0);
		batch.begin();
		batch.draw(texture,0,0,672,768);
		//System.out.println(sprite.getX());
		sprite.draw(batch);
		ball.draw(batch);
		batch.end();
	}

	public void ballmovement(){

		Rectangle playerRect = sprite.getBoundingRectangle();
		Rectangle ballrect = ball.getBoundingRectangle();

		if(play == true && ballrect.overlaps(playerRect)){
			//balldx = balldx;
			balldy = -balldy;
		}
		if(ballx < 25){
			balldx = -balldx;
		}
		if(ballx > 642){
			balldx = -balldx;
		}
		if(bally < 0){
			if(play == true){
				play = false;
			}
		}

		if(bally > 735){
			balldy = -balldy;
		}

		ballx += (balldx*3); //ball direction for x axis (left and right)
		bally += (balldy*3); // ball direction for y axis (up and down)

		ball.setPosition(ballx,bally); //moving the ball

	}

	@Override
	public void dispose () {
		batch.dispose();
		texture.dispose();
	}
}
