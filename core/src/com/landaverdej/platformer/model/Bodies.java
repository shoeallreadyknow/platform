package com.landaverdej.platformer.model;


import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.landaverdej.platformer.controller.LevelController;

public class Bodies {
       public static void createBody(MapObject mapObject){
           String bodyType= mapObject.getProperties().get("type").toString();

           if(bodyType.equalsIgnoreCase("solid")){
               RectangleMapObject rectangleMapObject =(RectangleMapObject)mapObject;
               BodyDef bodyDefinition = new BodyDef();
               bodyDefinition.type= BodyDef.BodyType.StaticBody;
               bodyDefinition.position.set(rectangleMapObject.getRectangle().x * LevelController.UNIT_SCALE, rectangleMapObject.getRectangle().y * LevelController.UNIT_SCALE);

               Body physicsbody = LevelController.gameWorld.createBody(bodyDefinition);
               PolygonShape rectangleshape = new PolygonShape();
               rectangleshape.setAsBox(rectangleMapObject.getRectangle().width * LevelController.UNIT_SCALE/2f , rectangleMapObject.getRectangle().height * LevelController.UNIT_SCALE/2f, new Vector2(rectangleMapObject.getRectangle().width * LevelController.UNIT_SCALE/2f , rectangleMapObject.getRectangle().height * LevelController.UNIT_SCALE/2f),0f );
               FixtureDef fixtureDefinition = new FixtureDef();
               fixtureDefinition.shape = rectangleshape;
               fixtureDefinition.friction = 4.0f;
               physicsbody.createFixture(fixtureDefinition);
               rectangleshape.dispose();
           }
           else if( bodyType.equalsIgnoreCase("slope")){
               PolygonMapObject polygonobject = (PolygonMapObject)mapObject;
                BodyDef bodyDefinition = new BodyDef();
               bodyDefinition.type = BodyDef.BodyType.StaticBody;
               bodyDefinition.position.set(polygonobject.getPolygon().getX()* LevelController.UNIT_SCALE, polygonobject.getPolygon().getY()* LevelController.UNIT_SCALE);

               Body physicsbody = LevelController.gameWorld.createBody(bodyDefinition);
               PolygonShape slopeshape = new PolygonShape();

               float[] transformedVerticies = new float[6];

               for(int index = 0; index < transformedVerticies.length; index++){
                   transformedVerticies[index] = polygonobject.getPolygon().getVertices()[index] * LevelController.UNIT_SCALE;
               }

               slopeshape.set(transformedVerticies);
               FixtureDef fixtureDefinition = new FixtureDef();
               fixtureDefinition.shape = slopeshape;

               physicsbody.createFixture(fixtureDefinition);
               slopeshape.dispose();
           }
     }
}
