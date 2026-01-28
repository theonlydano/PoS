package utils;

import gui.Location;

public class Node {
    // What a Node need?
    // parent
    // information -> data

    private Node parent;
    private Location data;

    public Node (Node parent, Location data) {
        this.parent = parent;
        this.data = data;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setData(Location data) {
        this.data = data;
    }

    public Node getParent() {
        return parent;
    }

    public Location getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Node [parent=" + parent + ", data=" + data + "]";
    }

}
