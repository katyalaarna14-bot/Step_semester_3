
package string.assignment_problems;

import java.util.Scanner;

public class RoundRobinGameTurns {

    static class Node {
        String player;
        Node next;

        Node(String player) {
            this.player = player;
        }
    }

    static Node tail;

    static void addLast(String player) {
        Node node = new Node(player);

        if (tail == null) {
            tail = node;
            tail.next = tail;
        } else {
            node.next = tail.next;
            tail.next = node;
            tail = node;
        }
    }

    static void printTurns() {
        if (tail == null) {
            System.out.println("No players");
            return;
        }

        Node head = tail.next;
        Node current = head;

        System.out.print("Turns: ");

        do {
            System.out.print(current.player);
            current = current.next;

            if (current != head) {
                System.out.print(" -> ");
            }
        } while (current != head);

        System.out.println(" -> (back to " + head.player + ")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String operation = sc.next();

            switch (operation) {
                case "ADD":
                    addLast(sc.next());
                    break;
                case "TURNS":
                    printTurns();
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
