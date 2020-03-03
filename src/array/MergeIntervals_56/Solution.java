package array.MergeIntervals_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code
 * definition to get new method signature.
 */
public class Solution {
    // https://leetcode.com/problems/merge-intervals/discuss/21222/A-simple-Java-solution
    // tc O(nlogn), sc O(n)
    // 6 ms, faster than 63.05%; 42.4 MB, less than 48.55%
    int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                result.add(newInterval);
                newInterval = interval;
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }

    // tc O(nlogn), sc O(n)
    // 9 ms, faster than 18.83%; 42.1 MB, less than 49.28%
    int[][] merge1(int[][] intervals) {
        int n;
        if (intervals == null || (n = intervals.length) < 2) return intervals;

        Point[] points = new Point[n * 2];
        for (int i = 0; i < n; i++) {
            points[2 * i] = new Point(intervals[i][0], true);
            points[2 * i + 1] = new Point(intervals[i][1], false);
        }
        Arrays.sort(points);

        List<int[]> list = new ArrayList<>();
        int i = 0;
        int[] interval = new int[2];
        interval[0] = points[i].val;
        while (i < points.length) {
            if (i > 0 && interval[1] != points[i].val) {
                list.add(interval);
                interval = new int[2];
                interval[0] = points[i].val;
            }
            int starts = 1;
            while (starts > 0) {
                i++;
                if (points[i].start) starts++;
                else starts--;
            }
            interval[1] = points[i].val;
            i++;
        }
        list.add(interval);
        int[][] res = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            res[j][0] = list.get(j)[0];
            res[j][1] = list.get(j)[1];
        }
        return res;
    }

    private static class Point implements Comparable<Point> {
        private int val;
        private boolean start;

        public Point(int val, boolean start) {
            this.val = val;
            this.start = start;
        }

        @Override
        public int compareTo(Point o) {
            return val - o.val;
        }
    }
}
