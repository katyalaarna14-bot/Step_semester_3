
package string.assignment_problems;

import java.util.Arrays;

public class MergingTokenQueues {

    public static int[] mergeTokens(int[] counterA, int[] counterB) {
        int m = counterA.length;
        int n = counterB.length;

        int[] merged = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (counterA[i] <= counterB[j]) {
                merged[k++] = counterA[i++];
            } else {
                merged[k++] = counterB[j++];
            }
        }

        while (i < m) {
            merged[k++] = counterA[i++];
        }

        while (j < n) {
            merged[k++] = counterB[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] counterA = {3, 8, 15, 20};
        int[] counterB = {5, 8, 12};

        int[] result = mergeTokens(counterA, counterB);

        System.out.println("Counter A: " + Arrays.toString(counterA));
        System.out.println("Counter B: " + Arrays.toString(counterB));
        System.out.println("Merged tokens: " + Arrays.toString(result));

        System.out.println("Merge time complexity: O(m + n)");
        System.out.println("Additional space complexity: O(m + n)");
        System.out.println("Joining and sorting time: O((m + n) log(m + n))");
    }
}
