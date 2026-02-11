package controller;

import lombok.extern.java.Log;

import java.awt.*;

@Log

public class LandingPlattform extends Object{
    private Color color = Color.cyan;

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
        g.setColor(color);
        g.fillRect((int)location.getX(), (int)location.getY(), width, height);
    }

    public boolean checkOnTop(Vector l, int h, int w){
        // Simple checker - checks if on top or 5 px under the top
        if((int) location.getY() <= (int)(l.getY() + h) && (int) location.getY() >= (int) (l.getY() + h - 5)){
            if((int) location.getX() <= (int) (l.getX() + w) && (int) (location.getX() + width) >= (int) l.getX()){
                return true;
            }
        }

        return false;
    }
}
