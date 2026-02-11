package controller;

import lombok.extern.java.Log;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

@Log

public class SpaceRocket extends Object{
    private static SpaceRocket spaceRocket;
    private Vector location;
    private Vector velocity;
    private final Vector acceleration;
    private int width;
    private int height;
    private Color color = Color.LIGHT_GRAY;
    private boolean moving = true;
    private ArrayList<Asteroid> asteroids;
    private int health = 100;
    private int windowsWidth = 10;
    private int windowsHeight = 10;
    private float fuel = 3000f;
    private ArrayList<LandingPlattform> landingPlattforms;
    private final int asteroidlimit = 10;

    private SpaceRocket() {
        Random rand = new Random();
        this.location = new Vector((float)(386/2), 100);
        this.velocity = new Vector(rand.nextFloat() * 5f, 0);
        this.acceleration = new Vector(0, 0.1981f);
        // this.acceleration = new Vector(0, 0);
        this.width = 20;
        this.height = 50;

        asteroids = new ArrayList<>();
        landingPlattforms = new ArrayList<>();
    }

    private void generateAstsroids() {
        Random rand = new Random();
        for(int i = rand.nextInt(asteroidlimit); i > 0; i--){
            asteroids.add(new Asteroid(windowsWidth, windowsHeight));
        }
    }

    private void generateLandingPlattforms() {
        Random rand = new Random();
        /*
        for(int i = rand.nextInt(2); i > 0; i--){
        }
        */
        landingPlattforms.add(new LandingPlattform(new Vector((float)(windowsWidth/2), (float)(windowsHeight/2)), 40, 20));
    }

    @Override
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

            for(LandingPlattform plattform : landingPlattforms){
                plattform.update();
                if (plattform.collision(location, width, height) && plattform.checkOnTop(location, height, width)){
                    moving = false;
                    color = Color.GREEN;
                } else if (plattform.collision(location, width, height)) {
                    moving = false;
                    color = Color.RED;
                }
            }
        }
        if(health <= 0){
            moving = false;
            color = Color.RED;
        }
    }

    @Override
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        int x = (int) location.getX();
        int y = (int) location.getY();

        // === ROCKET BODY ===
        g2.setColor(color);
        g2.fillRect(x, y, width, height);

        g2.setColor(new Color(80, 80, 80));
        g2.drawRect(x, y, width, height);

        // === NOSE CONE ===
        int[] noseX = {
                x,
                x + width / 2,
                x + width
        };

        int[] noseY = {
                y,
                y - height / 3,
                y
        };

        g2.setColor(color.brighter());
        g2.fillPolygon(noseX, noseY, 3);

        // === SIDE FINS ===
        g2.setColor(color.darker());

        // Left fin
        int[] leftFinX = {
                x,
                x - width / 3,
                x
        };
        int[] leftFinY = {
                y + height / 2,
                y + height,
                y + height
        };
        g2.fillPolygon(leftFinX, leftFinY, 3);

        // Right fin
        int[] rightFinX = {
                x + width,
                x + width + width / 3,
                x + width
        };
        int[] rightFinY = {
                y + height / 2,
                y + height,
                y + height
        };
        g2.fillPolygon(rightFinX, rightFinY, 3);

        // === WINDOW ===
        g2.setColor(new Color(150, 200, 255));
        int windowSize = width / 2;
        g2.fillOval(
                x + width / 4,
                y + height / 4,
                windowSize,
                windowSize
        );

        g2.setColor(Color.WHITE);
        g2.drawOval(
                x + width / 4,
                y + height / 4,
                windowSize,
                windowSize
        );

        // === ENGINE FLAME (optional) ===
        g2.setColor(Color.ORANGE);

        int[] flameX = {
                x + width / 4,
                x + width / 2,
                x + 3 * width / 4
        };

        int[] flameY = {
                y + height,
                y + height + height / 3,
                y + height
        };

        g2.fillPolygon(flameX, flameY, 3);

        for(Asteroid asteroid : asteroids){
            asteroid.draw(g);
        }
        for(LandingPlattform plattform : landingPlattforms){
            plattform.draw(g);
        }
    }

    @Override
    public boolean collision(Vector location, int width, int height){
        return false;
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
        generateLandingPlattforms();
    }

}
