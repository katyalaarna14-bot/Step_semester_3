
package string.assignment_problems;

public class TicketPriceSlotFinder {

    public static int findSlot(int[] prices, int newPrice) {
        int low = 0;
        int high = prices.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (prices[mid] == newPrice) {
                return mid;
            } else if (prices[mid] < newPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] prices = {120, 150, 200, 260};

        System.out.println("Slot for 150: " + findSlot(prices, 150));
        System.out.println("Slot for 210: " + findSlot(prices, 210));
        System.out.println("Slot for 300: " + findSlot(prices, 300));

        System.out.println("Binary search time: O(log n)");
        System.out.println("Additional space: O(1)");
        System.out.println("Linear scan time: O(n)");
    }
}
