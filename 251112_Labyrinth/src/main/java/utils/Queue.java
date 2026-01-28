package utils;

import gui.Location;

import java.util.ArrayList;
import java.util.List;

public class Queue implements DataStructure{
    // How a stack works
    // push -- add an element
    // pop ... get the last element and remove

    private List<Node> container;

    public Queue() {
        container = new ArrayList<>();
    }

    public void push(Node node) {
        container.add(node);
    }

    public Node pop() {
        // Node exNde = container.get(container.size() - 1);
        Node node = container.removeFirst();
        return node;
    }

    public boolean isEmpty() {
        return container.isEmpty();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        Node node = new Node(null, new Location(1, 2));
        queue.push(node);
        System.out.println("False " + queue.isEmpty());
        queue.pop();
        System.out.println("True " + queue.isEmpty());

    }
}
