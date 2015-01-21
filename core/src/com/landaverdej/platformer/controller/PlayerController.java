package com.landaverdej.platformer.controller;


import com.badlogic.gdx.math.Vector2;
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
}

