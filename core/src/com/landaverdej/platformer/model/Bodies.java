package com.landaverdej.platformer.model;


import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.landaverdej.platformer.controller.LevelController;

import javafx.scene.shape.Polyline;

public class Bodies {
       public static void createBody(MapObject mapObject){
           String bodyType= mapObject.getProperties().get("type").toString();

           if(bodyType.equalsIgnoreCase("ground")){
               PolylineMapObject polylineObject =(PolylineMapObject)mapObject;
               BodyDef bodyDefinition = new BodyDef();
               bodyDefinition.type= BodyDef.BodyType.StaticBody;
               bodyDefinition.position.set(polylineObject.getPolyline().getX() * LevelController.UNIT_SCALE,polylineObject.getPolyline().getY() * LevelController.UNIT_SCALE);

               Body physicsbody = LevelController.gameWorld.createBody(bodyDefinition);

               ChainShape chainShape = new ChainShape();
               float[] transformedVerticies = new float[polylineObject.getPolyline().getVertices().length];
               for(int index = 0; index < transformedVerticies.length; index++){
                   transformedVerticies[index] = polylineObject.getPolyline().getVertices()[index] * LevelController.UNIT_SCALE;
               }
               chainShape.createChain(transformedVerticies);

               FixtureDef fixtureDefinition = new FixtureDef();
               fixtureDefinition.shape = chainShape;
               fixtureDefinition.friction = 4.0f;

               physicsbody.createFixture(fixtureDefinition);
               chainShape.dispose();
           }

     }
}
