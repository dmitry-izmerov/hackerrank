package ru.demi.algorithms.graphtheory;

import java.util.*;

public class Graph {
    private Map<Integer, Node> nodes = new HashMap<>();

    public void addEdge(int source, int destination) {
        Node srcNode = getNode(source);
        Node destNode = getNode(destination);
        srcNode.addChild(destNode);
    }

    private Node getNode(int id) {
        Node node = nodes.get(id);
        if (Objects.isNull(node)) {
            node = new Node(id);
            nodes.put(id, node);
        }
        return node;
    }

    public boolean hasPathDFS(int source, int destination) {
        Node srcNode = getNode(source);
        Node destNode = getNode(destination);
        Set<Integer> visited = new HashSet<>();
        return hasPathDFS(srcNode, destNode, visited);
    }

    private boolean hasPathDFS(Node srcNode, Node destNode, Set<Integer> visited) {
        if (visited.contains(srcNode.getId())) {
            return false;
        }
        visited.add(srcNode.getId());

        if (srcNode == destNode) {
            return true;
        }

        for (Node child : srcNode.getChildren()) {
            if (hasPathDFS(child, destNode, visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasPathBFS(int source, int destination) {
        Queue<Node> queue = new LinkedList<>();
        Node srcNode = getNode(source);
        Node destNode = getNode(destination);
        Set<Integer> visited = new HashSet<>();

        queue.add(srcNode);

        while (!queue.isEmpty()) {
            Node node = queue.remove();


            if (destNode == node) {
                return true;
            }

            visited.add(node.getId());

            for (Node child : node.getChildren()) {
                if (!visited.contains(child.getId())) {
                    queue.add(child);
                }
            }
        }

        return false;
    }
}
