package controller;

import lombok.extern.java.Log;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

@Log

public class SpaceRocket {
    private static SpaceRocket spaceRocket;
    private Vector location;
    private Vector velocity;
    private final Vector acceleration;
    private int width;
    private int height;
    private Color color = Color.GREEN;
    private boolean moving = true;
    private ArrayList<Asteroid> asteroids;
    private int health = 100;
    private int windowsWidth = 10;
    private int windowsHeight = 10;
    private float fuel = 200f;

    private SpaceRocket() {
        Random rand = new Random();
        this.location = new Vector((float)(386/2), 100);
        this.velocity = new Vector(rand.nextFloat() * 5f, 0);
        this.acceleration = new Vector(0, 0.2981f);
        // this.acceleration = new Vector(0, 0);
        this.width = 20;
        this.height = 50;

        asteroids = new ArrayList<>();
    }

    private void generateAstsroids() {
        Random rand = new Random();
        for(int i = rand.nextInt(2); i > 0; i--){
            asteroids.add(new Asteroid(windowsWidth, windowsHeight));
        }
    }

    public void update(){
        if(moving){
            // log.info("space rocket updated");
            velocity.add(acceleration);
            location.add(velocity);
            // log.info("location: " + location);
            if(location.getX() + width > windowsWidth || location.getX() < 0){
                velocity.multiply(new Vector(-1, 1));
            }
            if(location.getY() + height > windowsHeight){
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
                location.setY(windowsHeight - height);
            }
            for(Asteroid asteroid : asteroids){
                asteroid.update();
                if (asteroid.collision(location, width, height)){
                // log.info("-------------------------- COLLISION DETECTED --------------------------");
                    health -= 10;
                }
            }
        }
        if(health <= 0){
            moving = false;
            color = Color.RED;
        }
    }

    public void draw(Graphics2D g2d){
        g2d.setColor(color);
        g2d.fillRect( (int) this.location.getX(), (int) this.location.getY(), width, height);
        g2d.setColor(new Color(80, 80, 80));
        for(Asteroid asteroid : asteroids){
            asteroid.draw(g2d);
        }
    }

    public void move(Vector velocity){
        // log.info("--> spaceRocket move called " + velocity);
        if(fuel <= 0 && moving){
            color = Color.MAGENTA;
        }else{
            this.velocity.add(velocity);
            fuel -= 10;
        }
    }

    public static SpaceRocket getSpaceRocket(){
        if(spaceRocket == null){
            spaceRocket = new SpaceRocket();
        }

        return spaceRocket;
    }

    public void setWindowParams(int w, int h){
        this.windowsWidth = w;
        this.windowsHeight = h;
        // log.info("SET WINDOW PARAMS: w=" + w + ", h=" + h);
        generateAstsroids();
    }

}
