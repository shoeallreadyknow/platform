package com.landaverdej.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public class Player {
  // setting new vector2 and texture variables
   public Vector2 position;
    public Texture spriteSheet;
    public TextureRegion[] spriteFrames;

    public Player() {
        //setting a new vector position
        position = new Vector2(0,0);
        // setting a new texture sprite sheet
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));
        //spliting the spriteSheet into frames
        TextureRegion[][] spriteSheetFrame = TextureRegion.split(spriteSheet, 70, 100);
       //setting it to start at zero
        int counter =0;
       //counting the number of players in the spriteSheet
        for(int row = 0; row < spriteSheetFrame.length; row++) {
            for(int column = 0; column < spriteSheetFrame[row].length; column++){
                   counter++;
            }

        }
        //creating a new texture region to make space for the player
        spriteFrames = new TextureRegion[counter];

        counter = 0;
        //taking every individual spriteSheetframe and store it in row
        for(TextureRegion[] row: spriteSheetFrame){
            for(TextureRegion sprite: row){
            //accessing the players now
                spriteFrames[counter++] = sprite;
            }

        }


    }
    public void draw(Batch spriteBatch){
        //connecting to the spritesheet
        spriteBatch.draw(spriteFrames[11], 0, 0, 70, 100);



    }
    public void update(float deltaTime){

    }

}
