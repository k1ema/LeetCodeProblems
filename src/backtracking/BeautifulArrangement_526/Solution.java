package backtracking.BeautifulArrangement_526;

import java.util.ArrayList;
import java.util.List;

/**
 * 526. Beautiful Arrangement
 * https://leetcode.com/problems/beautiful-arrangement/
 *
 * Suppose you have n integers from 1 to n. We define a beautiful arrangement as an array that is constructed by
 * these n numbers successfully if one of the following is true for the ith position (1 <= i <= n) in this array:
 *      The number at the ith position is divisible by i.
 *      i is divisible by the number at the ith position.
 * Given an integer n, return the number of the beautiful arrangements that you can construct.
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 *
 * Explanation:
 * The first beautiful arrangement is [1, 2]:
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 * The second beautiful arrangement is [2, 1]:
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 *
 * Example 2:
 * Input: n = 1
 * Output: 1
 *
 * Constraints:
 * 1 <= n <= 15
 */
public class Solution {
    // tc O(k), sc O(n), where k is the number of valid permutations
    public int countArrangement(int n) {
        return bt(n, 1, new boolean[n + 1]);
    }

    private int bt(int n, int idx, boolean[] used) {
        if (idx > n) return 1;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (!used[i] && (idx % i == 0 || i % idx == 0)) {
                used[i] = true;
                res += bt(n, idx + 1, used);
                used[i] = false;
            }
        }
        return res;
    }

    // my solution
    // tc O(k), sc O(n), where k is the number of valid permutations
    public int countArrangement1(int n) {
        return bt(n, new ArrayList<>(), new boolean[n]);
    }

    private int bt(int n, List<Integer> list, boolean[] used) {
        if (list.size() == n) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int idx = list.size() + 1;
            if (used[i - 1] || !(idx % i == 0 || i % idx == 0)) continue;
            used[i - 1] = true;
            list.add(i);
            res += bt(n, list, used);
            used[i - 1] = false;
            list.remove(list.size() - 1);
        }
        return res;
    }

    // tc O(k), sc O(n), where k is the number of valid permutations
    public int countArrangement2(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        return bt(nums, 0);
    }

    private int bt(int[] nums, int idx) {
        if (idx == nums.length) return 1;
        int res = 0;
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            if (nums[idx] % (idx + 1) == 0 || (idx + 1) % nums[idx] == 0) {
                res += bt(nums, idx + 1);
            }
            swap(nums, idx, i);
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
