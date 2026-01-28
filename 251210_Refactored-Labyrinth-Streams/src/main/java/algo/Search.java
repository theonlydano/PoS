package algo;

import gui.Labyrinth;
import gui.Location;
import utils.DataStructure;
import utils.Node;
import utils.Queue;
import utils.Stack;

import javax.xml.crypto.Data;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Search {

    public static Node dfs(Location start, Labyrinth grid){ // tiefe zuerst
        Stack stack = new Stack();
        return generic_search(start, grid, stack);
    }
    public static Node bfs(Location start, Labyrinth grid){ // breite zuerst
        Queue queue = new Queue();
        return generic_search(start, grid, queue);
    }

    public static Node generic_search(Location start, Labyrinth grid, DataStructure frontiers){
        // 0.) init: prepare
        frontiers.push(new Node(null, start));

        Set<Location> visitedNodes = new HashSet<>(); // Liste, aber ohne Duplikate

        while(!frontiers.isEmpty()){
            // 1.) get current node/location from stack
            Node currentNode = frontiers.pop();
            Location currentLocation = currentNode.getData();

            // 2.) aks
            if (grid.isGoal(currentLocation)){
                return currentNode;
            }

            // 3.) get neighbours from location and push
            List<Location> neighbours = grid.getNeighbours(currentLocation);

            for (Location neighbour : neighbours){

                if(visitedNodes.contains(neighbour)){
                    continue;
                }

                visitedNodes.add(neighbour);
                frontiers.push(new Node(currentNode, neighbour));
            }

            // REFACTOR THIS SHIT
            //----------------------------------------------------------------------------------------------------------

            neighbours.stream().forEach(neighbour -> {
                if(!visitedNodes.contains(neighbour)) {
                    visitedNodes.add(neighbour);
                    frontiers.push(new Node(currentNode, neighbour));
                }
            });
        }

        // end of methode -> nothing found
        return null;
    }
}
