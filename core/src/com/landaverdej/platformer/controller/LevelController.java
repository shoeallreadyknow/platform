package com.landaverdej.platformer.controller;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.landaverdej.platformer.model.Level;
import com.landaverdej.platformer.model.Player;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;


public class LevelController {
    public static final float UNIT_SCALE = 1/70f;

    public static TiledMap map;
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;

    public static World gameWorld;
    private static Array<Body> worldbodies;
    private static Box2DDebugRenderer debugRenderer;
    public static Level level;

    public static void initializeController() {
        level = new Level("map/level.01.tmx");
        //set the renderer
        renderer = new OrthogonalTiledMapRenderer(level.map, UNIT_SCALE);
        spriteBatch = renderer.getSpriteBatch();
        gameWorld = new World(new Vector2(0, -10), true);

        worldbodies= new Array<Body>();

        debugRenderer = new Box2DDebugRenderer();
    }

    public static void draw() {
        //starting a new spritebatch
        spriteBatch.begin();
        PlayerController.player.draw(spriteBatch);
        //ending spritebatch
        spriteBatch.end();
        debugRenderer.render(gameWorld, CameraController.camera.combined);
    }

    public static void update() {
        //renderer set camera view
        renderer.setView(CameraController.camera);
        //renderer to render to show map
        renderer.render();
        gameWorld.step(1/60f,1, 1);
    }
    private static void updateworldbodies(){
        worldbodies.clear();
    }
}