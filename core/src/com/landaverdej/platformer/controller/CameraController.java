package com.landaverdej.platformer.controller;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;
    public static OrthographicCamera inputCamera;

    public static float widthScale;
    public static float heightScale;

    public static void initializeController(){
        // setting a new width and height variable to fix the size of the game screen
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();


        // set yhe camera to 14f 14f
        camera = new OrthographicCamera(14f, 14f * (height/width));
        inputCamera = new OrthographicCamera(14f, 14f * (height/width));
        inputCamera.position.set(inputCamera.viewportWidth / 2f, inputCamera.viewportHeight / 2f, 0);
        inputCamera.update();
    }

    public static void update(){
        camera.position.set(PlayerController.player.position.x, PlayerController.player.position.y, 0);
        // update the cameras position
        camera.update();
    }

    public static void resize(int width, int height) {
        //sets new hieght and width on game screen
        camera.viewportWidth =14f;
        camera.viewportHeight = 14f * height / width;
        //update the new camera position
        camera.update();

        inputCamera.viewportWidth= 14f;
        inputCamera.viewportHeight= 14f * height/width;
        inputCamera.position.set(inputCamera.viewportWidth / 2f, inputCamera.viewportHeight / 2f, 0);
        inputCamera.update();

        widthScale= width / inputCamera.viewportWidth * LevelController.UNIT_SCALE;
        heightScale = height / inputCamera.viewportHeight * LevelController.UNIT_SCALE;

    }


}
