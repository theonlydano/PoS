package controller;

import java.awt.*;

public class LandingPlattform {
    private Vector location;
    private int width;
    private int height;

    public LandingPlattform(Vector location, int width, int height) {
        this.location = location;
        this.width = width;
        this.height = height;
    }

    public void update(){
        // Not yet in use
    }

    public void draw(Graphics g){
        g.fillRect((int)location.getX(), (int)location.getY(), width, height);
    }

    // Code from Asteroid
    public boolean collision(Vector l, int w, int h){
        if (location.getX() + width > l.getX() && location.getX() < l.getX() + w){
            if(location.getY() + height > l.getY() && location.getY() < l.getY() + h){
                return true;
            }
        }
        return false;
    }
}
