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
import com.landaverdej.platformer.model.Player;

public class GameScreen implements Screen {
   public TiledMap map;
   public OrthogonalTiledMapRenderer renderer;
   public OrthographicCamera camera;
public Batch spriteBatch;
    public Player player;
    public static World gameWorld;
    private Box2DDebugRenderer debugRenderer;

    public GameScreen() {
        //loaded the map from assets
    map = new TmxMapLoader().load("map/level.01.tmx");
        //set the renderer
    renderer = new OrthogonalTiledMapRenderer(map,1/70f );

        gameWorld = new World(new Vector2(0,-10), true);
        debugRenderer = new Box2DDebugRenderer();

      // setting a new width and height variable to fix the size of the game screen
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        // set yhe camera to 14f 14f
        camera = new OrthographicCamera(14f, 14f * (height/width));
        // setting the cameras position so it displays on the center of the game
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);
        //create a new spritebatch
        spriteBatch = renderer.getSpriteBatch();
       //create a new player
        player= new Player();


    }

    @Override
    public void render(float delta) {
        //seting the color of the clear
       Gdx.gl.glClearColor(0.03f, 0.02f, 0.05f, 1f);
        //clear color buffer using our own color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // update the cameras position
        camera.update();
        //renderer set camera view
        renderer.setView(camera);
        //renderer to render to show map
        renderer.render();
        //starting a new spritebatch
        spriteBatch.begin();
        //drawing the player using spritebatch
       player.draw(spriteBatch);
        //ending spritebatch
        spriteBatch.end();
        debugRenderer.render(gameWorld, camera.combined);
        //updating player position
        player.update(delta);



    }

    @Override
    public void resize(int width, int height) {
       //sets new hieght and width on game screen
        camera.viewportWidth =14f;
        camera.viewportHeight = 14f * height / width;
        //update the new camera position
        camera.update();
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