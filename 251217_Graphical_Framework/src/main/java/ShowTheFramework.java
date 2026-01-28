import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;

// @Slf4j
@Log

public class ShowTheFramework {
    public static void main(String[] args) {
        log.info("Lets start...");
        System.setProperty("sun.java2d.opengl", "true");

        Game game = new Game();
        PaintArea paintArea = new PaintArea(game);

        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                            new Frame(paintArea).setVisible(true);
                    } // Thread -> see next semester
                }
        );

        log.info("... received the End");
    }

    // Your turn: create a circle similar to rectangle. implement wall bounce
    // your turn: change color if mouse click is withing a moveable object
}
