import lombok.extern.java.Log;

import java.awt.*;

@Log

public class Rectangle extends Moveable implements GenericGraphic{
    private int width;
    private int height;
    private boolean changeColor = false;
    private boolean bounce = true;

    public Rectangle(int x, int y, int width, int height) {
        this.location = new Vector(x,y);
        this.velocity = new Vector(1,0);
        this.acceleration = new Vector(0,1);
        this.width = width;
        this.height = height;
    }

    @Override
    public void update(int w, int h) {
        // log.info("Rectangle: update called");
        if(location.getX() < 0 || location.getX() + width > w) {
            velocity.multiply(new Vector(-1,1));
            velocity.add(new Vector(-1,0));
        }
        if(location.getY() < 0){
            velocity.multiply(new Vector(1,-1));
        }
        if(location.getY() + height > h){
            velocity.multiply(new Vector(1,-1));
        }
        velocity.add(acceleration);
        location.add(velocity); // s = s_0 + v * 1s
    }

    @Override
    public void draw(Graphics2D g) {
        // log.info(System.currentTimeMillis() + "Rectangle: draw called");
        g.drawRect((int)location.getX(), (int)location.getY(), width, height);
    }

    public Vector getLocation() {
        return location;
    }

    public void changeColor() {
        changeColor = !changeColor;
    }
}
