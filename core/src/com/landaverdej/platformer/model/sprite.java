package com.landaverdej.platformer.model;


import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.landaverdej.platformer.controller.LevelController;

import java.util.HashMap;

public class sprite {
    //creates a variable for positions
    public Vector2 position;
    //creates a variable for spriteSheets
    public Spritesheet spriteSheet;
    public float width;
    public float height;
    private float stateTime;
    protected HashMap<String, Animation> animations;
    public String currentAnimation;

    public sprite( Vector2 position, int width, int height){
       this.position=position;
        //positions the character
        position = new Vector2(3,5);
        spriteSheet = new Spritesheet("img/aliens.png", width , height);
        animations = new HashMap<String, Animation>();
        this.width = width * LevelController.UNIT_SCALE;
        this.height = height * LevelController.UNIT_SCALE;
        stateTime = 0f;

    }

    public void draw(Batch spriteBatch){
        //draws the SpriteSheet onto the game
       spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width , height );

    }

    public void update(float deltaTime){
        //animates the character in a direction
        stateTime += deltaTime;
    }

}
