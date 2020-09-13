package array.InsertInterval_57;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals
 * (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 *
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code
 * definition to get new method signature.
 */
public class Solution {
    // tc O(n), sc O(1)
    // store to list all intervals that less than or equals to newInterval
    // merge intervals
    // add to res others
    //
    // 1 ms, faster than 98.83%; 41.7 MB, less than 78.23%
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];

        while (i < intervals.length && intervals[i][1] < start) {
            result.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        result.add(new int[] {start, end});

        while (i < intervals.length) result.add(intervals[i++]);

        return result.toArray(new int[result.size()][]);
    }

    // tc O(n), sc O(1), my solution, more complex logic
    // 1 ms; 41.9 MB
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return newInterval != null ? new int[][] {newInterval} : new int[][] {};
        }
        List<int[]> res = new ArrayList<>();
        int[] mergeInterval = intervals[0];
        boolean mergeIntervalAdded = false;
        for (int[] interval : intervals) {
            if (interval[0] > mergeInterval[1]) {
                res.add(mergeInterval);
                if (newInterval[1] <= mergeInterval[1]) {
                    mergeIntervalAdded = true;
                }
                mergeInterval = interval;
            }
            if (!mergeIntervalAdded && newInterval[0] <= interval[1]) {
                if (newInterval[1] < interval[0]) {
                    res.add(newInterval);
                    mergeIntervalAdded = true;
                } else {
                    mergeInterval[0] = Math.min(mergeInterval[0], Math.min(interval[0], newInterval[0]));
                    mergeInterval[1] = Math.max(mergeInterval[1], Math.max(interval[1], newInterval[1]));
                }
            }
        }
        res.add(mergeInterval);
        if (newInterval[0] > mergeInterval[1]) {
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][]);
    }
}
