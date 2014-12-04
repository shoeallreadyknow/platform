package com.landaverdej.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public class Player {
  // setting new vector2 and texture variables
   public Vector2 position;
    public Texture spriteSheet;

    public Player() {
        //setting a new vector position
        position = new Vector2(0,0);
        // setting a new texture sprite sheet
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));
    }
    public void draw(Batch spriteBatch){
        //connecting to the spritesheet
        spriteBatch.draw(spriteSheet, 0, 0, 70, 100);

    }
    public void update(float deltaTime){

    }

}
