package greedy.JumpGame_55;

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which
 * makes it impossible to reach the last index.
 */
public class Solution {
    // my solution #2
    // tc O(n), sc O(1)
    // 1 ms, faster than 98.20%; 41.5 MB, less than 29.06%
    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    // my solution
    // tc O(n), sc O(1)
    public boolean canJump(int[] nums) {
        int zeroes = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                zeroes++;
            } else {
                if (nums[i] <= zeroes) {
                    zeroes++;
                } else {
                    zeroes = 0;
                }
            }
        }
        return zeroes == 0;
    }

    // tc O(n), sc O(1)
    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int maxJumps = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxJumps == 0) return false;
            maxJumps--;
            maxJumps = Math.max(maxJumps, nums[i]);
        }
        return true;
    }

    // tc O(n), sc O(1)
    // https://leetcode.com/problems/jump-game/discuss/20932/6-line-java-solution-in-on
    public boolean canJump3(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    // tc O(n^2) in worst case ([4,0,0,0,0]); sc O(1)
    // 1 ms, faster than 98.20%; 41.1 MB, less than 49.57%
    // The idea is to find all zero's and for each starting from that index to 0 check if we can jump over it.
    public boolean canJump4(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int i = 0;
        while (i < nums.length - 1) {
            while (nums[i] != 0 && i < nums.length - 1) i++;
            if (i == nums.length - 1) break;
            int j = i - 1;
            while (j >= 0) {
                if (nums[j] > i - j) break;
                j--;
            }
            if (j < 0) return false;
            i++;
        }
        return true;
    }
}
