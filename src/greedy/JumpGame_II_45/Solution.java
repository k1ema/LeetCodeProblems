package greedy.JumpGame_II_45;

import java.util.Arrays;

/**
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 * Constraints:
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i] <= 10^5
 */
public class Solution {
    // tc O(nlogn), sc O(n)
    // 34 ms, faster than 24.90%; 46.4 MB, less than 5.64%
    // https://www.youtube.com/watch?v=hWVTOr6phl8
    // https://www.youtube.com/watch?v=tmv7W9Xw3lo
    public int jump(int[] nums) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(n);

        st.update(n - 1, 0);

        int L, R;
        for (int i = n - 2; i >= 0; i--) {
            L = i + 1;
            R = Math.min(n - 1, i + nums[i]);

            int r = st.getMin(L, R) + 1;
            st.update(i, r);
        }

        return st.getMin(0, 0);
    }

    private static class SegmentTree {
        private final int INF = (int) 1e9;
        private final int n;
        private final int[] a;
        private final int offset;

        SegmentTree(int n) {
            int k = 1;
            while ((1 << k) < n) {
                k++;
            }
            n = 1 << k;
            a = new int[2 * n - 1];
            Arrays.fill(a, INF);
            offset = a.length - n;
            this.n = n;
        }

        int getMin(int L, int R) {
            return getMin(0, 0, n - 1, L, R);
        }

        int getMin(int v, int l, int r, int L, int R) {
            if (r < L || l > R)
                return INF;

            if (l >= L && r <= R)
                return a[v];

            int m = l + (r - l) / 2;
            return Math.min(getMin(v * 2 + 1, l, m, L, R), getMin(v * 2 + 2, m + 1, r, L, R));
        }

        void update(int i, int v) {
            a[offset + i] = v;

            int index = offset + i;
            while (index != 0) {
                int parent = (index - 1) / 2;
                a[parent] = Math.min(a[2 * parent + 1], a[2 * parent + 2]);
                index /= 2;
            }
        }
    }

    // tc O(n), sc O(1)
    // 1ms; 40.8 MB
    // https://www.youtube.com/watch?v=vBdo7wtwlXs
    public int jump4(int[] nums) {
        if (nums.length == 1) return 0;
        int ladder = nums[0], stairs = nums[0], jump = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (i + nums[i] > ladder) {
                ladder = i + nums[i];
            }
            stairs--;
            if (stairs == 0) {
                jump++;
                stairs = ladder - i;
            }
        }
        return jump;
    }

    // Greedy tc O(n), sc O(1)
    // https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy
    public int jump3(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    // dp top-down, TLE
    // tc O(n^2), sc O(n)
    public int jump1(int[] nums) {
        return f(nums, 0, new Integer[nums.length]);
    }

    private int f(int[] nums, int i, Integer[] memo) {
        int n = nums.length;
        if (i >= n - 1) return 0;
        if (memo[i] != null) return memo[i];
        int res = n;
        for (int j = nums[i]; j > 0; j--) {
            res = Math.min(res, 1 + f(nums, i + j, memo));
        }
        memo[i] = res;
        return res;
    }

    // dp bottom-up, TLE
    // tc O(n^2), sc O(n)
    public int jump2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = n;
            if (nums[i] == 0) continue;
            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i + j]);
            }
        }
        return dp[0];
    }
}
