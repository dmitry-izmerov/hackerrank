package ru.demi.thirty_days_of_code;

import java.util.Scanner;

/**
 * Task:
 * Complete removeDuplicates so that it deletes any duplicate nodes from the list
 * and returns the head of the updated list.
 */
public class Day24 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int T = sc.nextInt();
        while (T-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        head = removeDuplicates(head);
        display(head);

    }

    private static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }

    }

    public static Node insert(Node head, int data) {
        Node p = new Node(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else {
            Node start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;

        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static Node removeDuplicates(Node head) {
        for (Node cur = head, prev = null; cur != null; cur = cur.next) {
            if (prev != null && prev.data == cur.data) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
        }

        return head;
    }
}
