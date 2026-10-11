
package string.assignment_problems;

import java.util.Scanner;

public class CancelledOrdersCleanup {

    static class Node {
        String code;
        Node next;

        Node(String code) {
            this.code = code;
        }
    }

    static Node head;

    static void addLast(String code) {
        Node node = new Node(code);

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

    static void removeAll(String code) {
        while (head != null && head.code.equals(code)) {
            head = head.next;
        }

        Node current = head;

        while (current != null && current.next != null) {
            if (current.next.code.equals(code)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    static void display() {
        Node current = head;
        System.out.print("Orders: ");

        while (current != null) {
            System.out.print(current.code);
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
                case "REMOVE":
                    removeAll(sc.next());
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
