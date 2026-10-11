
package string.assignment_problems;

import java.util.Scanner;

public class PriorityTokenInsertion {

    static class Node {
        String token;
        Node next;

        Node(String token) {
            this.token = token;
            this.next = null;
        }
    }

    static Node head = null;

    static void addFirst(String token) {
        Node newNode = new Node(token);
        newNode.next = head;
        head = newNode;
    }

    static void addLast(String token) {
        Node newNode = new Node(token);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    static void insertAt(String token, int position) {
        if (position <= 1) {
            addFirst(token);
            return;
        }

        Node current = head;

        for (int i = 1; current != null && i < position - 1; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(token);
        newNode.next = current.next;
        current.next = newNode;
    }

    static void display() {
        Node current = head;

        System.out.print("Tokens: ");

        while (current != null) {
            System.out.print(current.token);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String operation = sc.next();

            switch (operation) {
                case "FIRST":
                    addFirst(sc.next());
                    break;

                case "LAST":
                    addLast(sc.next());
                    break;

                case "INSERT":
                    String token = sc.next();
                    int position = sc.nextInt();
                    insertAt(token, position);
                    break;

                case "DISPLAY":
                    display();
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

