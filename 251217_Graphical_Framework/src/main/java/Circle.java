import lombok.extern.java.Log;

import java.awt.*;
import java.util.Random;

@Log

public class Circle extends Moveable implements GenericGraphic{
    private int width;
    private int height;
    private boolean changeColor = false;
    private Color color = Color.BLACK;

    public Circle(int x, int y, int width, int height) {
        location = new Vector(x,y);
        velocity = new Vector(1,1);
        this.width = width;
        this.height = height;
    }

    @Override
    public void update(int w, int h) {
        // log.info("Circle: update called");
        if(location.getX() - width < w || location.getX() + width > w) {
            velocity.multiply(new Vector(-1,1));
        }
        if(location.getY() - height < h || location.getY() + height > h) {
            velocity.multiply(new Vector(1,-1));
        }
        location.add(velocity); // s = s_0 + v * 1s
    }

    @Override
    public void draw(Graphics2D g) {
        // log.info(System.currentTimeMillis() + "Circle: draw called");
        if(changeColor) {
            color = new Color(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(256));
            changeColor = !changeColor;
        }
        g.setColor(color); // FINISH MAKING THE COLOR CHANGE WHEN CLICKED -----------------------------------------------
        g.fillOval((int)location.getX(), (int)location.getY(), width, height);
        g.drawOval((int)location.getX(), (int)location.getY(), width, height);
    }

    public Vector getLocation() {
        return location;
    }

    public void changeColor() {
        changeColor = !changeColor;
    }
}
