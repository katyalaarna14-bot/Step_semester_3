
package string.class_problems;

import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSumUnsorted {

    public static boolean bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean usingHashing(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(target - num)) {
                return true;
            }

            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println("Brute force result: "
                + bruteForce(nums, target));
        System.out.println("Hashing result: "
                + usingHashing(nums, target));
        System.out.println("Brute force time: O(n^2)");
        System.out.println("Hashing average time: O(n)");
        System.out.println("Hashing additional space: O(n)");
    }
}
