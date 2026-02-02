package controller;

import lombok.extern.java.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

@Log
public abstract class BaseGame {
    protected JPanel view;
    private Timer timer; // tick, tick, tick
    protected SpaceRocket spaceRocket;
    protected int windowWidth;
    protected int windowHeight;

    public BaseGame(int w, int h){
        log.info("--> basegame ctor called ");
        timer = new Timer(20, e -> tick()); // tick all 20ms, call methode
        spaceRocket = SpaceRocket.getSpaceRocket();
        spaceRocket.setWindowParams(w, h);
        this.windowWidth = w;
        this.windowHeight = h;
    }

    public void start(JPanel view){
        this.view = view; // paint area
        log.info("--> basegame timer started");
        timer.start();
    }

    private void tick(){
        // update the game
        update();
        // repaint
        view.repaint();
    }

    abstract public void update();
    abstract public void draw(Graphics2D g2d);

    abstract public void mouseClicked(MouseEvent e);
    abstract public void mouseDown(MouseEvent e);
    abstract public void mouseRelease(MouseEvent e);

    abstract public void keyPressed(KeyEvent e);

}
