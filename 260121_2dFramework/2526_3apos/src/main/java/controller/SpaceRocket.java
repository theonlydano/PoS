package controller;

import lombok.extern.java.Log;

import java.awt.*;
import java.util.Random;

@Log

public class SpaceRocket {
    private static SpaceRocket spaceRocket;
    private Vector location;
    private Vector velocity;
    private final Vector acceleration;
    private int width;
    private int height;
    private Color color = Color.BLACK;
    private boolean moving = true;

    private SpaceRocket() {
        Random rand = new Random();
        this.location = new Vector(100, 100);
        this.velocity = new Vector(rand.nextFloat() * 5f, 0);
        this.acceleration = new Vector(0, 0.2981f);
        // this.acceleration = new Vector(0, 0);
        this.width = 20;
        this.height = 50;
    }

    public void update(){
        if(moving){
            // log.info("space rocket updated");
            velocity.add(acceleration);
            location.add(velocity);
            // log.info("location: " + location);
            if(location.getX() + width > 386f || location.getX() < 0){
                velocity.multiply(new Vector(-1, 1));
            }
            if(location.getY() + height > 363f){
                // velocity.multiply(new Vector(1, -1));
                if (velocity.getY() > 7f){
                    this.color = Color.RED;
                    // location.add(new Vector(1000f, 1000f));
                    // log.info("sent into nirvana");
                }else{
                    this.color = Color.GREEN;
                    velocity = new Vector(0f, 0f);
                }
                moving = false;
                location.setY(363f - height);
            }
        }
    }

    public void draw(Graphics2D g2d){
        g2d.setColor(color);
        g2d.fillRect( (int) this.location.getX(), (int) this.location.getY(), width, height);
    }

    public void move(Vector velocity){
        // log.info("--> spaceRocket move called " + velocity);
        this.velocity.add(velocity);
    }

    public static SpaceRocket getSpaceRocket(){
        if(spaceRocket == null){
            spaceRocket = new SpaceRocket();
        }

        return spaceRocket;
    }

}
