package com.landaverdej.platformer.model;


import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {
    public TiledMap map;
    public Level(String mapPath){
        //loaded the map from assets
        map = new TmxMapLoader().load(mapPath);
    }

    public MapLayer getMapLayer(String layername){
        return map.getLayers().get(layername);
    }

    public MapObjects getLayerObjects(MapLayer maplayer){
        return maplayer.getObjects();
    }

}
