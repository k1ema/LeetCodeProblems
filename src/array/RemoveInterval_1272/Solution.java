package array.RemoveInterval_1272;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1272. Remove Interval
 * https://leetcode.com/problems/remove-interval/
 *
 * Given a sorted list of disjoint intervals, each interval intervals[i] = [a, b] represents the set of real numbers x such that a <= x < b.
 *
 * We remove the intersections between any interval in intervals and the interval toBeRemoved.
 *
 * Return a sorted list of intervals after all such removals.
 *
 * Example 1:
 * Input: intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]
 * Output: [[0,1],[6,7]]
 *
 * Example 2:
 * Input: intervals = [[0,5]], toBeRemoved = [2,3]
 * Output: [[0,2],[3,5]]
 *
 * Example 3:
 * Input: intervals = [[-5,-4],[-3,-2],[1,2],[3,5],[8,9]], toBeRemoved = [-1,4]
 * Output: [[-5,-4],[-3,-2],[4,5],[8,9]]
 *
 * Constraints:
 * 1 <= intervals.length <= 10^4
 * -10^9 <= intervals[i][0] < intervals[i][1] <= 10^9
 */
public class Solution {
    /*
                -------   ------   -------
              ------                 ---
     */
    // tc O(n), sc O(n)
    // 7 ms, faster than 72.15%; 47.4 MB, less than 74.16%
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] interv : intervals) {
            if (interv[1] < toBeRemoved[0] || interv[0] > toBeRemoved[1]) {
                res.add(Arrays.asList(interv[0], interv[1]));
            } else {
                if (interv[0] < toBeRemoved[0]) {
                    res.add(Arrays.asList(interv[0], toBeRemoved[0]));
                }
                if (interv[1] > toBeRemoved[1]) {
                    res.add(Arrays.asList(toBeRemoved[1], interv[1]));
                }
            }
        }
        return res;
    }
}
