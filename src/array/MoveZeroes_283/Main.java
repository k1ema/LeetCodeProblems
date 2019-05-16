package array.MoveZeroes_283;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 *
 * Example:
 * Input: [0,1,0,12,3]
 * Output: [1,12,3,0,0]
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Main {
    private static final int[][] DATA = {
            {0, 1, 0, 12, 3, 0},
            {0, 1, 0, 3, 12},
            {5, 4, 3, 2, 1, 0},
            {0, 5, 4, 0, 0, 3, 2, 1, 0, 0},
            {0, 1, 0, 0, 12, 3, 0},
            {2, 1},
            {0, 0},
            {0},
            {1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {1, 2, 3, 4, 5, 6, 7, 8}
    };

    public static void main(String[] args) {
        System.out.println("simple O(n^(2+n))");
        SolutionSimple simple = new SolutionSimple();
        for (int[] nums : DATA) {
            simple.moveZeroes(nums);
            System.out.println(Arrays.toString(nums));
        }

        System.out.println("better O(n)");
        Solution s = new Solution();
        for (int[] nums : DATA) {
            s.moveZeroes(nums);
            System.out.println(Arrays.toString(nums));
        }

        System.out.println("optimal O(n)");
        SolutionOptimal os = new SolutionOptimal();
        for (int[] nums : DATA) {
            os.moveZeroes(nums);
            System.out.println(Arrays.toString(nums));
        }
    }

//   with sort
//    private void moveZeroes(int[] nums) {
//        int lastNulls = 0;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (nums[i] != 0) {
//                break;
//            }
//            lastNulls++;
//        }
//
//        for (int i = 0; i < nums.length - lastNulls; i++) {
//            if (nums[i] == 0) {
//                int t = nums[nums.length - lastNulls - 1];
//                nums[nums.length - lastNulls - 1] = nums[i];
//                nums[i] = t;
//                lastNulls++;
//            }
//        }
//
//        for (int i = 0; i < nums.length - lastNulls - 1; i++) {
//            for (int j = i + 1; j < nums.length - lastNulls; j++) {
//                if (nums[j] < nums[i]) {
//                    int t = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = t;
//                }
//            }
//        }
//    }
}
