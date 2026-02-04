package controller;

import java.awt.*;

public abstract class Object {
    protected Vector location;
    protected int width;
    protected int height;

    public abstract void update();
    public abstract void draw(Graphics g);

    public boolean collision(Vector l, int w, int h){
        if (location.getX() + width > l.getX() && location.getX() < l.getX() + w){
            if(location.getY() + height > l.getY() && location.getY() < l.getY() + h){
                return true;
            }
        }
        return false;
    }
}
