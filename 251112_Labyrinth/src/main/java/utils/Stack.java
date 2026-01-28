package utils;

import gui.Location;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Stack implements DataStructure{
    // How a stack works
    // push -- add an element
    // pop ... get the last element and remove

    private List<Node> container;

    public Stack() {
        container = new ArrayList<>();
    }

    public void push(Node node) {
        container.add(node);
    }

    public Node pop() {
        // Node exNde = container.get(container.size() - 1);
        Node node = container.removeLast();
        return node;
    }

    public boolean isEmpty() {
        return container.isEmpty();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        Node node = new Node(null, new Location(1, 2));
        stack.push(node);
        System.out.println("False " + stack.isEmpty());
        stack.pop();
        System.out.println("True " + stack.isEmpty());

    }

}
