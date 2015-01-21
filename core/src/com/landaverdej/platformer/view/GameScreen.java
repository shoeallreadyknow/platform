package com.landaverdej.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.landaverdej.platformer.controller.CameraController;
import com.landaverdej.platformer.controller.LevelController;
import com.landaverdej.platformer.controller.PlayerController;
import com.landaverdej.platformer.model.Player;

public class GameScreen implements Screen {

   public OrthographicCamera camera;

    public Player player;



    public GameScreen() {

        CameraController.initializeController();
        LevelController.initializeController();
        PlayerController.initializeController();
    }

    @Override
    public void render(float delta) {
        //seting the color of the clear
       Gdx.gl.glClearColor(0.03f, 0.02f, 0.05f, 1f);
        //clear color buffer using our own color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // update the cameras position
        CameraController.update();

        //updating level controller
        LevelController.update(delta);
        PlayerController.update(delta);
        //draing level controller
        LevelController.draw();




    }

    @Override
    public void resize(int width, int height) {

        CameraController.resize(width, height);
    }

    @Override
    public void show() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
//