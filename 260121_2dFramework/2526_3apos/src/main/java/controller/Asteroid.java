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

    public Asteroid() {
        Random rand = new Random();
        this.location = new Vector(rand.nextFloat(386), rand.nextFloat(363));
        this.paths = new ArrayList<>();

        for (int i = rand.nextInt(4); i > 0; i--) {
            paths.add(new Vector(rand.nextFloat(386), rand.nextFloat(363)));
            if(init){
                pathWays = i;
                init = false;
                xPath = paths.get(onPath).getX() - location.getX() / 200;
                yPath = paths.get(onPath).getY() - location.getY() / 200;
            }
        }
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
            if(location.equals(path)){
                onPath+=nextPath;
                if(onPath == pathWays || onPath == 0){
                    nextPath *= -1;
                }
                xPath = paths.get(onPath).getX() - location.getX() / 200;
                yPath = paths.get(onPath).getY() - location.getY() / 200;
            }
        }
        location.add(new Vector(xPath, yPath));
        log.info("Asteroid X: " + location.getX() + " Y: " + location.getY());
        log.info("Asteroid X: " + xPath + " Y: " + yPath);
    }

    public void draw(Graphics g){
        g.fillRect((int)location.getX(), (int)location.getY(), 20, 20);
    }
}
