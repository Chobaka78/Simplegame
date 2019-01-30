package com.mygdx.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Paddle;

public class powerups {
    private Texture img;
    static Sprite ball;
    private SpriteBatch batch;
    Paddle player;
    int count;
    BitmapFont font;
    public void mag(){
        if(Gdx.input.isKeyPressed(Input.Keys.N)){
            count+=10;
            ball.setPosition(100,100);

        }

    }

}
