package com.landaverdej.platformer;

import com.badlogic.gdx.Game;
import com.landaverdej.platformer.view.GameScreen;


public class Platformer extends Game {
    @Override
    public void create() {
    setScreen(new GameScreen());
    }
}
