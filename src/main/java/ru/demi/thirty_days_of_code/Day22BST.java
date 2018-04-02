package ru.demi.thirty_days_of_code;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class Day22BST {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static int getHeight(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            Node next = queue.remove();

            boolean isEmpty = queue.isEmpty();
            if (next == null) {
                if (!isEmpty) {
                    queue.add(null); // as border between levels
                }
                ++level;
                continue;
            }

            if (Objects.nonNull(next.left)) {
                queue.add(next.left);
            }
            if (Objects.nonNull(next.right)) {
                queue.add(next.right);
            }

            boolean hasChildren = Objects.nonNull(next.right) || Objects.nonNull(next.left);
            if (isEmpty && hasChildren) { // root case
                queue.add(null); // as border between levels
            }
        }

        return level;
    }

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
