import java.awt.*;

public interface GenericGraphic {

    void update(int width, int height); // calc
    void draw(Graphics2D g); // repaint
    Vector getLocation();
    void changeColor();


}
