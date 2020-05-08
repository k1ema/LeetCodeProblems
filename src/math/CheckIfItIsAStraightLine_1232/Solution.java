package math.CheckIfItIsAStraightLine_1232;

/**
 * 1232. Check If It Is a Straight Line
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 *
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents t
 * he coordinate of a point. Check if these points make a straight line in the XY plane.
 *
 * Example 1: see link
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 *
 * Example 2: see link
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 * Constraints:
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 */
public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        if (x2 != x1) {
            double k = (y2 - y1) / (x2 - x1);
            double b = y1 - k * x1;
            for (int[] coord : coordinates) {
                int xi = coord[0];
                int yi = coord[1];
                if (yi != (Math.round(k * xi + b))) {
                    return false;
                }
            }
        } else {
            for (int[] coord : coordinates) {
                if (coord[0] != x1) {
                    return false;
                }
            }
        }
        return true;
    }
}
