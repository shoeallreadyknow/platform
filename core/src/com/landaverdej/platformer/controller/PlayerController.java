package com.landaverdej.platformer.controller;


import com.landaverdej.platformer.model.Player;

public class PlayerController {
    public static Player player;

    public static void initializeController(){
        //create a new player
        player= new Player(70,100);
    }

    public static void update(float deltaTime) {
        //updating player position
        player.update(deltaTime);
    }
}

