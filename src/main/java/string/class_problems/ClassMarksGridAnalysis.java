
package string.class_problems;

import java.util.Scanner;

public class ClassMarksGridAnalysis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] names = new String[n];
        int[][] marks = new int[n][3];
        int[] subjectTotals = new int[3];
        int[] totals = new int[n];

        int topperIndex = 0;

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();

            for (int j = 0; j < 3; j++) {
                marks[i][j] = sc.nextInt();
                totals[i] += marks[i][j];
                subjectTotals[j] += marks[i][j];
            }

            if (totals[i] > totals[topperIndex]) {
                topperIndex = i;
            }
        }

        System.out.print("Totals ");

        for (int i = 0; i < n; i++) {
            System.out.print(names[i] + " " + totals[i]);

            if (i < n - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();

        System.out.printf(
            "averages %.2f, %.2f, %.2f%n",
            subjectTotals[0] / (double) n,
            subjectTotals[1] / (double) n,
            subjectTotals[2] / (double) n
        );

        System.out.println(
            "topper " + names[topperIndex] + " (" + totals[topperIndex] + ")"
        );

        sc.close();
    }
}
