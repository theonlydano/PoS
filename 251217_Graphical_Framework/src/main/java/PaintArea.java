import lombok.extern.java.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

@Log

public class PaintArea extends JPanel {
    private MyGraphics myGraphics;

    private Graphics graphic;

    // List<GenericGraphic> graphicElements;

    public PaintArea(MyGraphics myGraphics) {
        super();
        this.myGraphics = myGraphics;

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onMouseClick(e); // call my own method
            }

            @Override
            public void mousePressed(MouseEvent e) {
                onMouseDown(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                onMouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // graphicElements = new ArrayList<GenericGraphic>();
    }

    public void onMouseClick(MouseEvent event) {
        log.info(System.currentTimeMillis() + "MouseClicked: " + event.getX() + ", " + event.getY());
        myGraphics.handleMouseClickEvent(event);
        /*
        myGraphics.figures.stream()
                .forEach(e -> {
                    if(e.getLocation().getX() + 50 > event.getX() && e.getLocation().getX() - 50 < event.getX()) {
                        if(e.getLocation().getY() + 50 > event.getY() && e.getLocation().getY() - 50 < event.getY()) {
                            e.changeColor();
                        }
                    }
                });

         */
    }
    public void onMouseDown(MouseEvent event) {
        myGraphics.mouseDown(event);
    }
    public void onMouseReleased(MouseEvent event) {
        myGraphics.mouseRelease(event);
    }

    public void addElement(GenericGraphic e) {
        //graphicElements.add(e);
        myGraphics.addFigure(e);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        this.graphic = g;
        // log.info("called paintComponent");

        Graphics2D g2d = (Graphics2D) g;
        int height = getHeight();
        int width = getWidth();

        // graphicElements.stream()
        //        .forEach(e -> {e.update(width, height); e.draw(g2d); });

        myGraphics.update(width, height);
        myGraphics.draw(g2d);
    }
}
