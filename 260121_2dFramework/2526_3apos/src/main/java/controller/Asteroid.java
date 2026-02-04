package controller;

import lombok.extern.java.Log;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

@Log

public class Asteroid extends Object{
    private ArrayList<Vector> paths;
    private boolean init = true;
    private int pathWays;
    private int onPath = 0;
    private boolean directionPathUp = true;
    private int nextPath = 1;
    private float xPath;
    private float yPath;
    private int speed = 100;
    private int windowsWidth = 0;
    private int windowsHeight = 0;

    public Asteroid(int w, int h) {
        this.windowsWidth = w;
        this.windowsHeight = h;

        Random rand = new Random();
        this.location = new Vector(rand.nextFloat(windowsWidth), rand.nextFloat(windowsHeight));
        this.paths = new ArrayList<>();

        for (int i = rand.nextInt(20) + 2; i > 0; i--) {
            paths.add(new Vector(rand.nextFloat(windowsWidth), rand.nextFloat(windowsHeight)));
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

    @Override
    public void update(){
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

    @Override
    public void draw(Graphics g){
        g.fillOval((int)location.getX(), (int)location.getY(), width, height);
    }
}
