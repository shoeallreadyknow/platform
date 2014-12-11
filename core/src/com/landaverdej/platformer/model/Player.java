package com.landaverdej.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public class Player {
  // setting new vector2 and texture variables
   public Vector2 position;
    public Animation animation;
    public SpriteSheet spritesheet;
    public int width;
    public int height;
    private float stateTime;

    public Player() {
        //setting a new vector position
        position = new Vector2(0,1);
        width= 70;
        height= 100;
       //setting the hard coded numbers in to variables
        spritesheet= new SpriteSheet("img/aliens.png",width,height);
        //storing the animation in animation
        animation = spritesheet.createAnimatiom();

        stateTime = 0f;

    }
    public void draw(Batch spriteBatch){
        //connecting to the spritesheet
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x , position.y, width *(1/70f), height * (1/70f));



    }
    public void update(float deltaTime){
        stateTime += deltaTime;
        position.x+=deltaTime;
        //position.y+=deltaTime;



    }

}
