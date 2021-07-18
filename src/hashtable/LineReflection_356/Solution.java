package hashtable.LineReflection_356;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 356. Line Reflection
 * https://leetcode.com/problems/line-reflection/
 *
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points
 * symmetrically, in other words, answer whether or not if there exists a line that after reflecting all points
 * over the given line the set of the original points is the same that the reflected ones.
 *
 * Note that there can be repeated points.
 *
 * Follow up:
 * Could you do better than O(n2) ?
 *
 * Example 1:
 * Input: points = [[1,1],[-1,1]]
 * Output: true
 * Explanation: We can choose the line x = 0.
 *
 * Example 2:
 * Input: points = [[1,1],[-1,-1]]
 * Output: false
 * Explanation: We can't choose a line.
 *
 * Constraints:
 * n == points.length
 * 1 <= n <= 10^4
 * -10^8 <= points[i][j] <= 10^8
 */
public class Solution {
    // tc O(nlogn), sc O(n)
    public boolean isReflected(int[][] points) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        Map<Integer, Set<Integer>> checkDup = new HashMap<>();
        for (int[] point : points) {
            map.putIfAbsent(point[1], new ArrayList<>());
            checkDup.putIfAbsent(point[1], new HashSet<>());
            if (checkDup.get(point[1]).contains(point[0])) {
                continue;
            }
            checkDup.get(point[1]).add(point[0]);
            map.get(point[1]).add(point);
        }
        Double line_x_coord = null;
        for (int y_coord : map.keySet()) {
            List<int[]> list = map.get(y_coord);
            if (list.size() == 1) {
                if (line_x_coord == null) {
                    line_x_coord = list.get(0)[0] * 1d;
                } else if (line_x_coord != list.get(0)[0]) {
                    return false;
                }
                continue;
            }
            list.sort(Comparator.comparingInt(a -> a[0]));
            int l = 0, r = list.size() - 1;
            while (l <= r) {
                int[] left = list.get(l);
                int[] right = list.get(r);
                double mid_x = (left[0] + right[0]) / 2d;
                if (line_x_coord != null) {
                    if (mid_x != line_x_coord) {
                        return false;
                    }
                } else {
                    line_x_coord = mid_x;
                }
                l++; r--;
            }
        }
        return true;
    }
}
