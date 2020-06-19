package dynamic.FindTwoNonOverlappingSubArraysEachWithTargetSum_1477;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
 * https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 *
 * Given an array of integers arr and an integer target.
 *
 * You have to find two non-overlapping sub-arrays of arr each with sum equal target. There can be multiple
 * answers so you have to find an answer where the sum of the lengths of the two sub-arrays is minimum.
 *
 * Return the minimum sum of the lengths of the two required sub-arrays, or return -1 if you cannot find such two sub-arrays.
 *
 * Example 1:
 * Input: arr = [3,2,2,4,3], target = 3
 * Output: 2
 * Explanation: Only two sub-arrays have sum = 3 ([3] and [3]). The sum of their lengths is 2.
 *
 * Example 2:
 * Input: arr = [7,3,4,7], target = 7
 * Output: 2
 * Explanation: Although we have three non-overlapping sub-arrays of sum = 7 ([7], [3,4] and [7]), but we will
 * choose the first and third sub-arrays as the sum of their lengths is 2.
 *
 * Example 3:
 * Input: arr = [4,3,2,6,2,3,4], target = 6
 * Output: -1
 * Explanation: We have only one sub-array of sum = 6.
 *
 * Example 4:
 * Input: arr = [5,5,4,4,5], target = 3
 * Output: -1
 * Explanation: We cannot find a sub-array of sum = 3.
 *
 * Example 5:
 * Input: arr = [3,1,1,1,5,1,2,1], target = 3
 * Output: 3
 * Explanation: Note that sub-arrays [1,2] and [2,1] cannot be an answer because they overlap.
 *
 * Constraints:
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 1000
 * 1 <= target <= 10^8
 */
public class Solution {
    // tc O(n), sc O(n)
    // hashtable
    // https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/discuss/685548/Java-Sliding-Window-with-dp-O(N)-20-lines
    // similar to 560. Subarray Sum Equals K
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int n = arr.length;
        int[] min = new int[n];
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            min[i] = i > 0 ? min[i - 1] : Integer.MAX_VALUE;
            if (map.containsKey(sum - target)) {
                int pre = map.get(sum - target);
                min[i] = Math.min(min[i], i - pre);
                if (pre > -1 && min[pre] != Integer.MAX_VALUE) {
                    res = Math.min(res, min[pre] + i - pre);
                }
            }
            map.put(sum, i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // tc O(n), sc O(n)
    // sliding window
    // https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/discuss/686105/JAVA-or-Sliding-window-with-only-one-array-or-No-HasMap
    public int minSumOfLengths1(int[] arr, int target) {
        int n = arr.length;
        int sum = 0, start = 0, ans = n + 1, bestSoFar = Integer.MAX_VALUE;
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            while (sum > target) {
                sum -= arr[start++];
            }
            if (sum == target) {
                if (start > 0 && best[start - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, best[start - 1] + i - start + 1);
                }
                bestSoFar = Math.min(bestSoFar, i - start + 1);
            }
            best[i] = bestSoFar;
        }
        return ans != n + 1 ? ans : -1;
    }

    // tc O(n^4), sc O(1), TLE
    // my brute force solution
    public int minSumOfLengths2(int[] arr, int target) {
        int minSum = Integer.MAX_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int curSum1 = 0;
            for (int j = i; j < n; j++) {
                curSum1 += arr[j];
                if (curSum1 > target) {
                    break;
                }

                if (curSum1 < target) {
                    continue;
                }

                for (int k = j + 1; k < n; k++) {
                    int curSum2 = 0;
                    for (int l = k; l < n; l++) {
                        curSum2 += arr[l];
                        int curLen = j - i + 1 + l - k + 1;
                        if (curSum2 > target || curLen >= minSum) {
                            break;
                        }
                        if (curSum2 == target) {
                            minSum = Math.min(minSum, curLen);
                        }
                    }
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
