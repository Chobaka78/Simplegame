package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite sprite;
	Texture texture, img;
	int x = 291;

	@Override
	public void create () {

		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("Arkanoid1.png"));
		img = new Texture(Gdx.files.internal("player.png"));
		sprite = new Sprite(img);
		Gdx.graphics.setWindowedMode(600, texture.getHeight()*3);
	}
	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//keyboard control
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && sprite.getX() < 555){
			x+=5;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && sprite.getX() > 25){
			x-=5;
		}
		sprite.setPosition(x,0);
		batch.begin();
		batch.draw(texture, 0, 0, 638, 480);
		//System.out.println(sprite.getX());
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		texture.dispose();
	}
}
