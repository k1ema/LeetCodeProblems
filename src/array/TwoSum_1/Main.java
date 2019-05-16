package array.TwoSum_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */
public class Main {
    public static void main(String[] args) {
        // new int[] {3, 2, 4}, 6
        // new int[] {1, 2, 4, 11, 13, 21, 23}, 17
        int[] ints1 = twoSum(new int[] {2, 7, 11, 15}, 9);
        int[] ints2 = twoSum2(new int[] {2, 7, 11, 15}, 9);
        int[] ints3 = twoSum3(new int[] {2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(ints2));
        System.out.println(Arrays.toString(ints3));
    }

    // O(n^2)
    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    // O(n)
    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }

        return null;
    }

    // O(n)
    private static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
