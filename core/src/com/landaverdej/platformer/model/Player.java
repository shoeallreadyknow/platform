package com.landaverdej.platformer.model;

import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.graphics.Texture;
        import com.badlogic.gdx.graphics.g2d.Animation;
        import com.badlogic.gdx.graphics.g2d.Batch;
        import com.badlogic.gdx.graphics.g2d.TextureRegion;
        import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.landaverdej.platformer.controller.LevelController;
import com.landaverdej.platformer.view.GameScreen;

import java.util.HashMap;

public class Player extends sprite {


    public Player(Vector2 position, int width, int height, String sheetpath ) {
            super(position, width, height, sheetpath);

        //seting properties for our riddged body
        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);
        // creating our body
        physicsbody = LevelController.gameWorld.createBody(bodyDefinition);
        physicsbody.setUserData(this);
        //geting the shape
        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width /2, this.height /2, new Vector2(this.width/2f, this.height/ 2f), 0f );
        //setting the shsape to fix def
        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;
        //created the fixture
        physicsbody.createFixture(fixtureDefinition);
        rectangleShape.dispose();

        animations.put("walk", spriteSheet.createAnimation(20, 21, 0.1f));
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walk"), true, false));

        animations.put("swim",spriteSheet.createAnimation(18, 19, 0.1f));
        animations.put("swimleft", spriteSheet.flipAnimation(animations.get("swim"), true, false));

        animations.put("idle", spriteSheet.createAnimation(17, 17, 0.1f));
        animations.put("idleLeft", spriteSheet.flipAnimation(animations.get("idle"), true, false));

        animations.put("jump",spriteSheet.createAnimation(16, 16, 0.1f));
        animations.put("jumpLeft", spriteSheet.flipAnimation(animations.get("jump"), true, false));

        animations.put("duck",spriteSheet.createAnimation(14, 14, 0.1f));
        animations.put("duckLeft", spriteSheet.flipAnimation(animations.get("duck"), true, false));

        animations.put("hurt",spriteSheet.createAnimation(15, 15, 0.1f));
        animations.put("hurtLeft", spriteSheet.flipAnimation(animations.get("hurt"), true, false));

        animations.put("stand",spriteSheet.createAnimation(11, 11, 0.1f));

        animations.put("climb",spriteSheet.createAnimation(12, 13, 0.1f));


        currentAnimation = "walk";


    }

    public void draw(Batch spriteBatch) {
       super.draw(spriteBatch);
    }

    public void update(float deltaTime){
       super.update(deltaTime);
    }
}