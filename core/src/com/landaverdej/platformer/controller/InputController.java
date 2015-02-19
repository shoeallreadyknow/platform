package com.landaverdej.platformer.controller;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.landaverdej.platformer.model.InputControl;
import com.landaverdej.platformer.model.Spritesheet;

public class InputController {
   private static Spritesheet spritesheet;
   private  static InputControl left;
    private  static InputControl right;

    public static void initializeController(){
        spritesheet = new Spritesheet("img/touch-controls.png", 80, 80);
        left = new InputControl(new Vector2(0,0), spritesheet.spriteFrames[0],"left");

        right = new InputControl(new Vector2(2,0), spritesheet.spriteFrames[1],"right");
        Gdx.input.setInputProcessor(createInputAdapter());
    }

    public static void draw(Batch spriteBatch){
        spriteBatch.begin();
        left.draw(spriteBatch);
        right.draw(spriteBatch);
        spriteBatch.end();
    }
    private static InputAdapter createInputAdapter(){
        return new InputAdapter(){
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                //makes go left
                if(left.getBoundingBox().contains(screenX, Gdx.graphics.getHeight() - screenY)){
                    PlayerController.movementAction = "left";
                }
                //makes character go right
               else if(right.getBoundingBox().contains(screenX, Gdx.graphics.getHeight() - screenY)){
                    PlayerController.movementAction = "right";
                }
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                if(left.getBoundingBox().contains(screenX, Gdx.graphics.getHeight() - screenY)){
                    PlayerController.movementAction = "";
                }
                else if(right.getBoundingBox().contains(screenX, Gdx.graphics.getHeight() - screenY)){
                    PlayerController.movementAction = "";
                }
                return true;
            }
        };
    }

}
