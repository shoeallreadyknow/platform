package com.landaverdej.platformer.controller;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;

    public static void initializeController(){
        // setting a new width and height variable to fix the size of the game screen
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        // set yhe camera to 14f 14f
        camera = new OrthographicCamera(14f, 14f * (height/width));
        // setting the cameras position so it displays on the center of the game
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);

    }

    public static void update(){
        // update the cameras position
        camera.update();
    }

    public static void resize(int width, int height) {
        //sets new hieght and width on game screen
        camera.viewportWidth =14f;
        camera.viewportHeight = 14f * height / width;
        //update the new camera position
        camera.update();
    }


}
