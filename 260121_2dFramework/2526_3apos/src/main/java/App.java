import controller.BaseGame;
import controller.Game;
import view.PaintArea;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");

        int windowWidth = 800;
        int windowHeight = 600;


        // model: The 2d-Logic (the game)
        BaseGame model = new Game(windowWidth, windowHeight);

        // view: the paint-area
        PaintArea view = new PaintArea(model);
        view.setFocusable(true);

        JFrame frame = new JFrame();
        frame.setTitle("Lunar Lander");
        frame.setSize(windowWidth, windowHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add paint-area to frame
        frame.add(view);

        // make them visible
        frame.setVisible(true);

        // start the game thread -> tick, tick, tick
        model.start(view);
    }
}
