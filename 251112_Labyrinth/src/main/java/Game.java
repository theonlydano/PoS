import algo.Search;
import gui.Labyrinth;
import gui.Location;
import utils.Node;
import utils.Path;
import utils.Queue;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        int rows = 100;
        int cols = 150;
        float spead = 0.3f;

        Location start = new Location(1, 1);
        Location goal = new Location(rows-2, cols-2);
        Labyrinth labyrinth = new Labyrinth(rows, cols, start, goal, spead);

        Node result = Search.bfs(start, labyrinth); 
        if (result != null) {
            List<Location> path = Path.generate(result);
            labyrinth.setPath(path);
            System.out.println(result);
        }

        System.out.println(labyrinth);
    }
}
