
package string.assignment_problems;

import java.util.Scanner;

public class TrainCoachesBothWays {

    static class Node {
        String name;
        Node next;
        Node prev;

        Node(String name) {
            this.name = name;
        }
    }

    static Node head;
    static Node tail;

    static void addLast(String name) {
        Node node = new Node(name);

        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    static void remove(String name) {
        Node current = head;

        while (current != null && !current.name.equals(name)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Coach not found");
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
    }

    static void forward() {
        Node current = head;
        System.out.print("Forward: ");

        while (current != null) {
            System.out.print(current.name);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }

        System.out.println();
    }

    static void backward() {
        Node current = tail;
        System.out.print("Backward: ");

        while (current != null) {
            System.out.print(current.name);
            if (current.prev != null) {
                System.out.print(" <-> ");
            }
            current = current.prev;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String operation = sc.next();

            switch (operation) {
                case "ADD":
                    addLast(sc.next());
                    break;
                case "REMOVE":
                    remove(sc.next());
                    break;
                case "FORWARD":
                    forward();
                    break;
                case "BACKWARD":
                    backward();
                    break;
                case "EXIT":
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}
