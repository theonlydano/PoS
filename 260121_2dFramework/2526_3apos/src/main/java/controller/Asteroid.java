package controller;

import lombok.extern.java.Log;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

@Log

public class Asteroid {
    private Vector location;
    private ArrayList<Vector> paths;
    private boolean init = true;
    private int pathWays;
    private int onPath = 0;
    private boolean directionPathUp = true;
    private int nextPath = 1;
    private float xPath;
    private float yPath;
    private int speed = 100;
    private int height;
    private int width;

    public Asteroid() {
        Random rand = new Random();
        this.location = new Vector(rand.nextFloat(386), rand.nextFloat(363));
        this.paths = new ArrayList<>();

        for (int i = rand.nextInt(20) + 2; i > 0; i--) {
            paths.add(new Vector(rand.nextFloat(386), rand.nextFloat(363)));
            if(init){
                init = false;
                pathWays = i - 1;
                xPath = (paths.get(onPath).getX() - location.getX()) / speed;
                yPath = (paths.get(onPath).getY() - location.getY()) / speed;
            }
        }

        this.height = rand.nextInt(20) + 10;
        this.width = height;
    }

    public void update(){
        /*
        switch (onPath) {
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }
         */
        for(Vector path : paths){
            if((int)location.getX() == (int)path.getX() && (int)location.getY() == (int)path.getY()){
                onPath+=nextPath;
                if(onPath == pathWays || onPath == 0){
                    nextPath *= -1;
                }
                xPath = (paths.get(onPath).getX() - location.getX()) / speed;
                yPath = (paths.get(onPath).getY() - location.getY()) / speed;
            }
        }
        location.add(new Vector(xPath, yPath));
        // log.info("Asteroid " + onPath + " LOCATION: " + location.getX() + " Y: " + location.getY());
        // log.info("Asteroid " + onPath + " XY: " + xPath + " Y: " + yPath);
        // log.info("Asteroid " + onPath + " PATH: " + paths.get(onPath).getX() + " Y: " + paths.get(onPath).getY());
    }

    public boolean collision(Vector l, int w, int h){
        if (location.getX() + width > l.getX() && location.getX() < l.getX() + w){
            if(location.getY() + height > l.getY() && location.getY() < l.getY() + h){
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics g){
        g.fillOval((int)location.getX(), (int)location.getY(), width, height);
    }
}
