package com.mygdx.game;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;



public class Utls {
    SpriteBatch batch;
    BitmapFont font;
    Paddle player;
    Ball ball;
    int score = 0;

    public void create () {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(2f);

    }
    public void collide (){
        if (ball.getBoundingRectangle().overlaps(Paddle.player.getBoundingRectangle())) {
            score += 10;

        }
    }

}
