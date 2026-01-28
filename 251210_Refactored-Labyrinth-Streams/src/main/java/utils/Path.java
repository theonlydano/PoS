package utils;

import gui.Location;

import java.util.ArrayList;
import java.util.List;

public class Path {
    public static List<Location> generate(Node node) {
        List<Location> path = new ArrayList<>();

        Node current = node.getParent();
        while(current.getParent() != null) {
            path.add(current.getData());
            current = current.getParent();
        }

        return path;
    }
}
