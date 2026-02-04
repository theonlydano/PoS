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
        
    }

    public void draw(Graphics g){
        g.fillRect((int)location.getX(), (int)location.getY(), width, height);
    }
}
