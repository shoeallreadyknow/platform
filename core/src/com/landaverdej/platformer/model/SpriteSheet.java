package com.landaverdej.platformer.model;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteSheet {
    public Texture spriteSheet;
    public TextureRegion[] spriteFrames;


    public SpriteSheet(String pathtofile, int width, int hieght) {
        // setting a new texture sprite sheet
        spriteSheet = new Texture(Gdx.files.internal(pathtofile));
        //spliting the spriteSheet into frames
        TextureRegion[][] spriteSheetFrame = TextureRegion.split(spriteSheet, width, hieght);
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
    public Animation createAnimatiom(int startFrame, int lastframe, float animationSpeed){
       //finding out the amount of frames needed to be used
        int counter= (lastframe +1 ) - startFrame;
        //saving 2 spaces in tecture region
        TextureRegion[] animationFrames = new TextureRegion[counter];

        for(int index= lastframe; index>=startFrame;index--){

            animationFrames[--counter]= spriteFrames[index];


        }

        //setting how fast the animation is
    return new Animation(animationSpeed, animationFrames);

    }
}
