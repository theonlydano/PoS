package controller;

import java.awt.*;

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

    public boolean checkOnTop(Vector l, int h){
        // Not yet working
        /*
        if(location.getY() >= l.getY() - h){
            return true;
        }
         */
        return true;
    }
}
