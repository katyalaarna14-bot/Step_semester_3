
package string.class_problems;

public class MaximizeAreaBetweenBoundaries {

    public static int maxContainerArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int area = height * width;

            maxArea = Math.max(maxArea, area);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println("Maximum water area: "
                + maxContainerArea(heights));
        System.out.println("Brute force time: O(n^2)");
        System.out.println("Two-pointer time: O(n)");
        System.out.println("Additional space: O(1)");
    }
}
