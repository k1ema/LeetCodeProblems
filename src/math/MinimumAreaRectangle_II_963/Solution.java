package math.MinimumAreaRectangle_II_963;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 963. Minimum Area Rectangle II
 * https://leetcode.com/problems/minimum-area-rectangle-ii/
 *
 * Given a set of points in the xy-plane, determine the minimum area of any rectangle
 * formed from these points, with sides not necessarily parallel to the x and y axes.
 *
 * If there isn't any rectangle, return 0.
 *
 * Example 1:
 * Input: [[1,2],[2,1],[1,0],[0,1]]
 * Output: 2.00000
 * Explanation: The minimum area rectangle occurs at [1,2],[2,1],[1,0],[0,1], with an area of 2.
 *
 * Example 2:
 * Input: [[0,1],[2,1],[1,1],[1,0],[2,0]]
 * Output: 1.00000
 * Explanation: The minimum area rectangle occurs at [1,0],[1,1],[2,1],[2,0], with an area of 1.
 *
 * Example 3:
 * Input: [[0,3],[1,2],[3,1],[1,3],[2,1]]
 * Output: 0
 * Explanation: There is no possible rectangle to form from these points.
 *
 * Example 4:
 * Input: [[3,1],[1,1],[0,1],[2,1],[3,3],[3,2],[0,2],[2,3]]
 * Output: 2.00000
 * Explanation: The minimum area rectangle occurs at [2,1],[2,3],[3,3],[3,1], with an area of 2.
 *
 * Note:
 * 1 <= points.length <= 50
 * 0 <= points[i][0] <= 40000
 * 0 <= points[i][1] <= 40000
 * All points are distinct.
 * Answers within 10^-5 of the actual value will be accepted as correct.
 */
public class Solution {
    // tc O(n^3), sc O(n)
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        Set<Point> pointSet = new HashSet<>();
        Point[] A = new Point[n];
        for (int i = 0; i < n; i++) {
            A[i] = new Point(points[i][0], points[i][1]);
            pointSet.add(A[i]);
        }

        double minArea = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Point p1 = A[i];
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                Point p2 = A[j];
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    Point p3 = A[k];
                    Point p4 = new Point(p2.x + p3.x - p1.x, p2.y + p3.y - p1.y);
                    if (pointSet.contains(p4)) {
                        // dot production
                        int dot = (p2.x - p1.x) * (p3.x - p1.x) + (p2.y - p1.y) * (p3.y - p1.y);
                        if (dot == 0) {
                            minArea = Math.min(minArea, p1.distance(p2) * p1.distance(p3));
                        }
                    }
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

    // tc O(n^3), sc O(n?)
    // 32 ms, faster than 58.10%; 38.4 MB, less than 98.81%
    /*
        1. for each 3 diff points
            - calc distance between each of them
            - check is there right angle exists
            - is exists -> add three dots to list
        2. double iterate through list and check whether each two triangles can contain rectangle
            check that it is a rectangle:
                - hypotenuse is the same
                - hypotenuse is equal to other diagonal
                or we can use dot production: (a*b) = |a| * |b| * cosF, since cos90=0 -> (a,b) == 0
     */
    public double minAreaFreeRect1(int[][] points) {
        int n = points.length;
        List<int[][]> triangles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pointsEqual(points[i], points[j])) continue;
                for (int k = j + 1; k < n; k++) {
                    if (pointsEqual(points[i], points[k]) || pointsEqual(points[j], points[k])) continue;
                    double dist_ij = getDistance(points[i], points[j]);
                    double dist_jk = getDistance(points[j], points[k]);
                    double dist_ik = getDistance(points[i], points[k]);
                    if (rightAngle(dist_ij, dist_jk, dist_ik)) {
                        triangles.add(new int[][] {points[i], points[j], points[k]});
                    } else if (rightAngle(dist_jk, dist_ik, dist_ij)) {
                        triangles.add(new int[][] {points[j], points[k], points[i]});
                    } else if (rightAngle(dist_ik, dist_ij, dist_jk)) {
                        triangles.add(new int[][] {points[k], points[i], points[j]});
                    }
                }
            }
        }

        double minArea = Integer.MAX_VALUE;
        for (int i = 0; i < triangles.size(); i++) {
            for (int j = i + 1; j < triangles.size(); j++) {
                if (isRectangle(triangles.get(i), triangles.get(j))) {
                    int[][] triangle = triangles.get(i);
                    minArea = Math.min(minArea, getDistance(triangle[0], triangle[1]) * getDistance(triangle[1], triangle[2]));
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

    private boolean pointsEqual(int[] p1, int[] p2) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }

    private double getDistance(int[] p1, int[] p2) {
        return Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
    }

    private boolean rightAngle(double a, double b, double c) {
        return Math.abs(a * a + b * b - c * c) <= 0.00001d;
    }

    private boolean isRectangle(int[][] triangle1, int[][] triangle2) {
        boolean twoPointsEqual = pointsEqual(triangle1[0], triangle2[0]) && pointsEqual(triangle1[2], triangle2[2]) || pointsEqual(triangle1[0], triangle2[2]) && pointsEqual(triangle1[2], triangle2[0]);
        if (twoPointsEqual) {
            boolean diagonalsEqual = Math.abs(getDistance(triangle1[0], triangle1[2]) - getDistance(triangle1[1], triangle2[1])) <= 0.00001d;
            return diagonalsEqual;
        }
        return false;
    }
}
