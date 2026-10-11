
package string.assignment_problems;

import java.util.Scanner;

public class ReverseTheQueue {

    static class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
        }
    }

    static Node head;

    static void addLast(String value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    static void reverse() {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        head = previous;
    }

    static void display() {
        Node current = head;
        System.out.print("Queue: ");

        while (current != null) {
            System.out.print(current.value);
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
                case "ADD":
                    addLast(sc.next());
                    break;
                case "REVERSE":
                    reverse();
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
