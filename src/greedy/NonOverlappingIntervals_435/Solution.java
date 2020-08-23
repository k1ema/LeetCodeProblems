package greedy.NonOverlappingIntervals_435;

import java.util.Arrays;

/**
 * 435. Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/
 *
 * Given a collection of intervals, find the minimum number of intervals you need to remove to
 * make the rest of the intervals non-overlapping.
 *
 * Example 1:
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 *
 * Example 2:
 * Input: [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 *
 * Example 3:
 * Input: [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 *
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 */
public class Solution {
    /*
        1. sort intervals by end point
        2. start iterating:
            if cur start < prev end
                res += 1
            else prev = cur
        3. return res
    */
    // tc O(nlogn), sc O(1)
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int end = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }

    // tc O(nlogn), sc O(1)
    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }

    // tc O(n^2), sc O(n)
    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int n = intervals.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (!overlap(intervals[j], intervals[i])) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        return n - res;
    }

    private boolean overlap(int[] a, int[] b) {
        return b[0] < a[1];
    }
}
