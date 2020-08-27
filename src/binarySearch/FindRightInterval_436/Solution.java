package binarySearch.FindRightInterval_436;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 436. Find Right Interval
 * https://leetcode.com/problems/find-right-interval/
 *
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose
 * start point is bigger than or equal to the end point of the interval i, which can be called that
 * j is on the "right" of i.
 *
 * For any interval i, you need to store the minimum interval j's index, which means that the
 * interval j has the minimum start point to build the "right" relationship for interval i. If
 * the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored
 * value of each interval as an array.
 *
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * You may assume none of these intervals have the same start point.
 *
 * Example 1:
 * Input: [ [1,2] ]
 * Output: [-1]
 * Explanation: There is only one interval in the collection, so it outputs -1.
 *
 * Example 2:
 * Input: [ [3,4], [2,3], [1,2] ]
 * Output: [-1, 0, 1]
 * Explanation: There is no satisfied "right" interval for [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point;
 * For [1,2], the interval [2,3] has minimum-"right" start point.
 *
 * Example 3:
 * Input: [ [1,4], [2,3], [3,4] ]
 * Output: [-1, 2, -1]
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point.
 *
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition
 * to get new method signature.
 */
public class Solution {
    // tc O(nlogn), sc O(n)
    // 12 ms, faster than 96.48%; 43.7 MB, less than 92.20%
    public int[] findRightInterval(int[][] intervals) {
        Map<int[], Integer> map = new HashMap<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            map.put(intervals[i], i);
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = n;
            int target = intervals[i][1];
            while (r - l > 1) {
                int m = (l + r) >>> 1;
                if (intervals[m][0] < target) {
                    l = m;
                } else {
                    r = m;
                }
            }

            res[map.get(intervals[i])] = r == n ? -1 : map.get(intervals[r]);
        }

        return res;
    }

    // tc O(nlogn), sc O(n)
    public int[] findRightInterval1(int[][] intervals) {
        TreeMap<Integer, Integer> starts = new TreeMap<>();
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts.put(intervals[i][0], i);
        }
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> pos = starts.ceilingEntry(intervals[i][1]);
            res[i] = pos == null ? -1 : pos.getValue();
        }
        return res;
    }

    // brute force, tc O(n^2), sc O(n)
    // 660 ms, 42,5 MB
    public int[] findRightInterval2(int[][] intervals) {
        int[] res = new int[intervals.length];
        int min, minIndex;
        for (int i = 0; i < intervals.length; i++) {
            min = Integer.MAX_VALUE;
            minIndex = -1;
            for (int j = 0; j < intervals.length; j++) {
                if (j == i) continue;
                if (intervals[j][0] >= intervals[i][1] && intervals[j][0] < min) {
                    min = intervals[j][0];
                    minIndex = j;
                }
            }
            res[i] = minIndex;
        }
        return res;
    }

}
