package controller;

import lombok.extern.java.Log;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@Log
public class Game extends BaseGame{
    private boolean start = false;

    public Game(int w, int h) {
        super(w, h);
    }

    @Override
    public void update() {
        // log.info("--> game update called");
        if(start){
            super.spaceRocket.update();
        }

    }

    @Override
    public void draw(Graphics2D g2d) {
        // log.info("--> game draw called");
        super.spaceRocket.draw(g2d);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        log.info("--> game mouseClicked called");

    }

    @Override
    public void mouseDown(MouseEvent e) {
        log.info("--> game mouseDown called");

    }

    @Override
    public void mouseRelease(MouseEvent e) {
        log.info("--> game mouseRelease called");

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // log.info("--> game keyPressed called " + e.getKeyChar());
        switch (e.getKeyChar()) {
            case 'w':
            case 'W':
                spaceRocket.move(new Vector(0, -2f));
                break;
            case 'a':
            case 'A':
                spaceRocket.move(new Vector(-2f, 0));
                break;
            case 's':
            case 'S':
                if(!start){
                    start = true;
                }
                spaceRocket.move(new Vector(0, 2f));
                break;
            case 'd':
            case'D':
                spaceRocket.move(new Vector(2f, 0));
                break;

            default:
                break;
        }
    }

}
