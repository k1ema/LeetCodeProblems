package segmentTree.MinimumNumberOfIncrementsOnSubarraysToFormATargetArray_1526;

import java.util.Arrays;

/**
 * 1526. Minimum Number of Increments on Subarrays to Form a Target Array
 * https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
 *
 * Given an array of positive integers target and an array initial of same size with all zeros.
 *
 * Return the minimum number of operations to form a target array from initial if you are allowed to do the following operation:
 *
 * Choose any subarray from initial and increment each value by one.
 * The answer is guaranteed to fit within the range of a 32-bit signed integer.
 *
 * Example 1:
 * Input: target = [1,2,3,2,1]
 * Output: 3
 * Explanation: We need at least 3 operations to form the target array from the initial array.
 * [0,0,0,0,0] increment 1 from index 0 to 4 (inclusive).
 * [1,1,1,1,1] increment 1 from index 1 to 3 (inclusive).
 * [1,2,2,2,1] increment 1 at index 2.
 * [1,2,3,2,1] target array is formed.
 *
 * Example 2:
 * Input: target = [3,1,1,2]
 * Output: 4
 * Explanation: (initial)[0,0,0,0] -> [1,1,1,1] -> [1,1,1,2] -> [2,1,1,2] -> [3,1,1,2] (target).
 *
 * Example 3:
 * Input: target = [3,1,5,4,2]
 * Output: 7
 * Explanation: (initial)[0,0,0,0,0] -> [1,1,1,1,1] -> [2,1,1,1,1] -> [3,1,1,1,1]
 *                                   -> [3,1,2,2,2] -> [3,1,3,3,2] -> [3,1,4,4,2] -> [3,1,5,4,2] (target).
 * Example 4:
 * Input: target = [1,1,1,1]
 * Output: 1
 *
 * Constraints:
 * 1 <= target.length <= 10^5
 * 1 <= target[i] <= 10^5
 */
public class Solution {
    // segment tree
    // tc O(nlogn), sc O(n)
    public int minNumberOperations(int[] target) {
        SegmentTree st = new SegmentTree(target);
        return f(target, 0, target.length - 1, st);
    }

    private int f(int[] target, int L, int R, SegmentTree st) {
        int n = target.length;
        if (L > R || L == n || R == -1) return 0;
        int[] min = st.getMin(L, R);
        int left = f(target, L, min[1] - 1, st);
        int right = f(target, min[1] + 1, R, st);
        int num = min[0];
        return (left > 0 ? left - num : 0) + (right > 0 ? right - num : 0) + num;
    }

    private static class SegmentTree {
        private int[][] arr;
        private int offset, n;

        SegmentTree(int[] nums) {
            int n = nums.length;
            int k = 0;
            while ((1 << k) < n) {
                k++;
            }
            n = 1 << k;
            offset = n - 1;

            arr = new int[2 * n - 1][2];
            Arrays.fill(arr, new int[] {Integer.MAX_VALUE, -1});
            for (int i = 0; i < nums.length; i++) {
                update(i, nums[i]);
            }
            this.n = n;
        }

        void update(int i, int val) {
            int ind = i + offset;
            arr[ind] = new int[] {val, i};
            while (ind > 0) {
                int parent = (ind - 1) / 2;
                int leftChild = 2 * parent + 1, rightChild = 2 * parent + 2;
                if (arr[leftChild][0] < arr[rightChild][0]) {
                    arr[parent] = arr[leftChild];
                } else {
                    arr[parent] = arr[rightChild];
                }
                ind = parent;
            }
        }

        int[] getMin(int L, int R) {
            return getMin(0, 0, n - 1, L, R);
        }

        int[] getMin(int ind, int l, int r, int L, int R) {
            if (r < L || l > R) return new int[] {Integer.MAX_VALUE, -1};
            if (l >= L && r <= R) return arr[ind];
            int m = l + (r - l) / 2;
            int[] left = getMin(2 * ind + 1, l, m, L, R);
            int[] right = getMin(2 * ind + 2, m + 1, r, L, R);
            return left[0] < right[0] ? left : right;
        }
    }

    // tc O(n), sc O(1)
    public int minNumberOperations1(int[] target) {
        int res = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                res += target[i] - target[i - 1];
            }
        }
        return res;
    }

    // tc O(n), sc O(1)
    // my solution
    public int minNumberOperations2(int[] target) {
        int res = 0, curMax = target[0], curMin = 0;
        for (int i = 1; i < target.length; i++) {
            if (target[i] >= target[i - 1]) {
                curMax = target[i];
            } else {
                if (target[i - 1] == curMax) {
                    res += curMax - curMin;
                }
                curMin = target[i];
            }
        }
        if (target[target.length - 1] == curMax) {
            res += curMax - curMin;
        }
        return res;
    }
}
