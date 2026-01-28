package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Labyrinth {
    private int rows;
    private int cols;
    private Cell[][] grid;
    private Location start;
    private Location goal;
    private float spread;

    public Labyrinth(int r, int c, Location start, Location goal, float spread) {
        this.start = start;
        this.goal = goal;
        this.rows = r;
        this.cols = c;
        this.spread = spread;

        grid = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell();
            }
        }

        fillWithObstacles();

        // your turn: set start / goal into the labyrinth
        grid[start.row][start.col].setState("S");
        grid[goal.row][goal.col].setState("G");
    }

    private void fillWithObstacles() {
        // your turn: insert the obstacles ... (randomly)

        // float spread = 0.3f; // 50 % Hindernisse
        Random rand = new Random();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                float randomSpread = rand.nextFloat(); // gleich verteilt
                if(randomSpread < this.spread) {
                    grid[row][col].setState("X");
                }
            }
        }
    }

    public boolean isGoal(Location location) {
        return goal.compareTo(location) == 0;
    }

    public List<Location> getNeighbours(Location location) {
        List<Location> neighbours = new ArrayList<Location>();

        // your turn: find all valid neighbours from location
        try{
            if (!grid[location.row][location.col-1].getState().equals("X")) {
                // links
                neighbours.add(new Location(location.row, location.col-1));
            }
        }catch(Exception e) {}
        try{
            if (!grid[location.row-1][location.col].getState().equals("X")) {
                // oben
                neighbours.add(new Location(location.row-1, location.col));
            }
        }catch(Exception e) {}
        try{
            if (!grid[location.row+1][location.col].getState().equals("X")) {
            // unten
                neighbours.add(new Location(location.row+1, location.col));
            }
        }catch(Exception e) {}
        try{
            if (!grid[location.row][location.col+1].getState().equals("X")) {
                // rechts
                neighbours.add(new Location(location.row, location.col+1));
            }
        }catch(Exception e) {}

        return neighbours;
    }

    public void setPath(List<Location> path) {
        for (Location location : path) {
            grid[location.row][location.col].setState("*");
        }

        grid[start.row][start.col].setState("S");
        grid[goal.row][goal.col].setState("G");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(grid[i][j].toString());
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
