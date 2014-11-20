package com.landaverdej.platformer.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameScreen implements Screen {
   public TiledMap map;
   public OrthogonalTiledMapRenderer renderer;
   public OrthographicCamera camera;

    public GameScreen() {
        //loaded the map from assets
    map = new TmxMapLoader().load("map/level.01.tmx");
        //set the renderer
    renderer = new OrthogonalTiledMapRenderer(map,1/70f );
        // set yhe camera to 14f 14f
        camera = new OrthographicCamera(14f, 14f);
        // setting the cameras position so it displays on the center of the game
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);
    }

    @Override
    public void render(float delta) {
        // update the cameras position
        camera.update();
        //renderer set camera view
        renderer.setView(camera);
        //renderer to render to show map
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {

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