import lombok.extern.java.Log;

import java.awt.event.MouseEvent;

@Log

public class Game extends MyGraphics {

    public Game(){
        super();
        log.info("Game was created");
        addFigure(new Rectangle(10,20,30,40));
    }

    @Override
    public void handleMouseClickEvent(MouseEvent e) {
        log.info("Not implemented yet...");
        figures.add(new Rectangle(
                e.getX(),
                e.getY(),
                20,
                20));
    }

    @Override
    public void mouseDown(MouseEvent e) {

    }
    @Override
    public void mouseRelease(MouseEvent e) {

    }
}
