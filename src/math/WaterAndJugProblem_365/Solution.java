package math.WaterAndJugProblem_365;

/**
 * 365. Water and Jug Problem
 * https://leetcode.com/problems/water-and-jug-problem/
 *
 * You are given two jugs with capacities x and y litres. There is an infinite amount
 * of water supply available. You need to determine whether it is possible to measure
 * exactly z litres using these two jugs.
 *
 * If z liters of water is measurable, you must have z liters of water contained within
 * one or both buckets by the end.
 *
 * Operations allowed:
 *
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the
 * first jug itself is empty.
 *
 * Example 1: (From the famous "Die Hard" example)
 * Input: x = 3, y = 5, z = 4
 * Output: True
 *
 * Example 2:
 * Input: x = 2, y = 6, z = 5
 * Output: False
 *
 * Constraints:
 * 0 <= x <= 10^6
 * 0 <= y <= 10^6
 * 0 <= z <= 10^6
 */
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == z || y == z || x + y == z) return true;

        int vx = 0, vy = 0;
        for (int i = 0; i < 1e6 + 10; i++) {
            if (vx == z || vy == z || vx + vy == z
                    || x + vy == z || y + vx == z) return true;

            if (vx == 0) vx = x;
            if (vx == z || vy == z || vx + vy == z
                    || x + vy == z || y + vx == z) return true;

            int dy = Math.min(vx, y - vy);
            vx -= dy;
            vy += dy;
            if (vx == z || vy == z || vx + vy == z
                    || x + vy == z || y + vx == z) return true;

            if (vy == y) vy = 0;
        }
        return false;
    }
}
