package controller;

import java.awt.*;

public class LandingPlattform extends Object{

    public LandingPlattform(Vector location, int width, int height) {
        this.location = location;
        this.width = width;
        this.height = height;
    }

    @Override
    public void update(){
        // Not yet in use
    }

    @Override
    public void draw(Graphics g){
        g.fillRect((int)location.getX(), (int)location.getY(), width, height);
    }
}
