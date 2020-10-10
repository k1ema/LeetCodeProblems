package greedy.MinimumNumberOfArrowsToBurstBalloons_452;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *
 * There are some spherical balloons spread in two-dimensional space. For
 * each balloon, provided input is the start and end coordinates of the
 * horizontal diameter. Since it's horizontal, y-coordinates don't matter,
 * and hence the x-coordinates of start and end of the diameter suffice.
 * The start is always smaller than the end.
 *
 * An arrow can be shot up exactly vertically from different points along
 * the x-axis. A balloon with xstart and xend bursts by an arrow shot at x
 * if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can
 * be shot. An arrow once shot keeps traveling up infinitely.
 *
 * Given an array points where points[i] = [xstart, xend], return the minimum
 * number of arrows that must be shot to burst all balloons.
 *
 * Example 1:
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: One way is to shoot one arrow for example at x = 6 (bursting
 * the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the
 * other two balloons).
 *
 * Example 2:
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 *
 * Example 3:
 * Input: points = [[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 *
 * Example 4:
 * Input: points = [[1,2]]
 * Output: 1
 *
 * Example 5:
 * Input: points = [[2,3],[2,3]]
 * Output: 1
 *
 * Constraints:
 * 0 <= points.length <= 104
 * points.length == 2
 * -231 <= xstart < xend <= 231 - 1
 */
public class Solution {
    // tc O(nlogn), sc O(1)
    // 24 ms, faster than 25.75%; 57.2 MB, less than 17.36%
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int arrows = 1, end = points[0][1];
        for (int[] p : points) {
            if (end < p[0]) {
                arrows++;
                end = p[1];
            }
        }
        return arrows;
    }

    // tc O(n^2), sc O(n)
    // 243 ms, faster than 5.01%; 84 MB, less than 17.36%
    public int findMinArrowShots1(int[][] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 0;
        Set<Integer> deleted = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            if (deleted.contains(i)) continue;
            for (int j = i + 1; j < points.length; j++) {
                if (points[j][0] <= points[i][1] && !deleted.contains(j)) {
                    deleted.add(i);
                    deleted.add(j);
                }
            }
            res++;
        }
        return res;
    }
}
