package math.CircleAndRectangleOverlapping_1401;

/**
 * 1401. Circle and Rectangle Overlapping
 * https://leetcode.com/problems/circle-and-rectangle-overlapping/
 *
 * Given a circle represented as (radius, x_center, y_center) and an axis-aligned rectangle
 * represented as (x1, y1, x2, y2), where (x1, y1) are the coordinates of the bottom-left corner,
 * and (x2, y2) are the coordinates of the top-right corner of the rectangle.
 *
 * Return True if the circle and rectangle are overlapped otherwise return False.
 *
 * In other words, check if there are any point (xi, yi) such that belongs to the circle
 * and the rectangle at the same time.
 *
 * Example 1:
 * Input: radius = 1, x_center = 0, y_center = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
 * Output: true
 * Explanation: Circle and rectangle share the point (1,0)
 *
 * Example 2:
 * Input: radius = 1, x_center = 0, y_center = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1
 * Output: true
 *
 * Example 3:
 * Input: radius = 1, x_center = 1, y_center = 1, x1 = -3, y1 = -3, x2 = 3, y2 = 3
 * Output: true
 *
 * Example 4:
 * Input: radius = 1, x_center = 1, y_center = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1
 * Output: false
 *
 * Constraints:
 * 1 <= radius <= 2000
 * -10^4 <= x_center, y_center, x1, y1, x2, y2 <= 10^4
 * x1 < x2
 * y1 < y2
 */
public class Solution {
    // 0 ms, faster than 100.00%; 36.1 MB, less than 100.00%
    //
    // At first we check whether the circle is inside the rectangle.
    // If not, we calculate min distance between rectangle and circle projectons on x / y.
    // If circle center is between y1 and y2 than horizontal line which goes through circle center crosses
    // rectangle -> closest path is on horizontal line. And it should be LTE radius. The same logic for x.
    // If no, min distance does not lie neither on horizontal nor on vertical lines so we check using Pythagorean theorem
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        if (x1 <= x_center && x_center <= x2 && y1 <= y_center && y_center <= y2) {
            return true;
        }

        int minDistX = Math.min(Math.abs(x1 - x_center), Math.abs(x2 - x_center));
        int minDistY = Math.min(Math.abs(y1 - y_center), Math.abs(y2 - y_center));

        if (y1 <= y_center && y_center <= y2) {
            return minDistX <= radius;
        } else if (x1 <= x_center && x_center <= x2) {
            return minDistY <= radius;
        } else {
            return minDistX * minDistX + minDistY * minDistY <= radius * radius;
        }
    }
}
