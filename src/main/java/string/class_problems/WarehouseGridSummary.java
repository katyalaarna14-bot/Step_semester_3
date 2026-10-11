
package string.class_problems;

public class WarehouseGridSummary {

    public static void warehouseSummary(int[][] grid) {
        int total = 0;
        int max = grid[0][0];
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];

                if (grid[i][j] > max) {
                    max = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("Total items: " + total);
        System.out.println("Maximum bin coordinate: ("
                + maxRow + ", " + maxCol + ")");
        System.out.println("Maximum items: " + max);
        System.out.println("Time complexity: O(m * n)");
        System.out.println("Additional space: O(1)");
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        warehouseSummary(grid);
    }
}
