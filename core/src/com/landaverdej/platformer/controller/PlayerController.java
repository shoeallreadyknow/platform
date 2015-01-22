package com.landaverdej.platformer.controller;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.GdxNativesLoader;
import com.landaverdej.platformer.model.Player;

public class PlayerController {
    public static Player player;

    public static void initializeController(){
        //create a new players
        player= new Player(new Vector2(3,5),70,100);
    }

    public static void update(float deltaTime) {
        //updating player position
        player.update(deltaTime);
    }

    public static void draw(Batch spriteBatch){
        player.draw(spriteBatch);
    }

    public static void handleinput(){
        //setting the velocity
        Vector2 velocity = player.physicsbody.getLinearVelocity();
        //setting the position
        Vector2 position = player.physicsbody.getPosition();

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.physicsbody.applyLinearImpulse(velocity, 0,);
        }
    }

}

