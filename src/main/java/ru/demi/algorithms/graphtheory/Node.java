package ru.demi.algorithms.graphtheory;

import java.util.LinkedList;
import java.util.List;

public class Node {
    private int id;
    private List<Node> children = new LinkedList<>();

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Node getChild(int id) {
        return children.stream()
                .filter(node -> node.id == id)
                .findFirst()
                .orElse(null);
    }

    public void addChild(Node node) {
        children.add(node);
    }

    public void removeChild(Node node) {
        children.remove(node);
    }
}
