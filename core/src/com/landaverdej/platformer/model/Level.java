package com.landaverdej.platformer.model;


import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {
    public TiledMap map;
    public Level(String mapPath){
        //loaded the map from assets
        map = new TmxMapLoader().load(mapPath);
    }

}
