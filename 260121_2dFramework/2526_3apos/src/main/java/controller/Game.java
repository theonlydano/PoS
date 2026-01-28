package controller;

import lombok.extern.java.Log;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@Log
public class Game extends BaseGame{

    @Override
    public void update() {
        // log.info("--> game update called");
        super.spaceRocket.update();
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
                spaceRocket.move(new Vector(-2f, 0));
                break;
            case 's':
                spaceRocket.move(new Vector(0, 2f));
                break;
            case 'd':
                spaceRocket.move(new Vector(2f, 0));
                break;

            default:
                break;
        }
    }

}
