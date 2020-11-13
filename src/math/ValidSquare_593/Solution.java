package math.ValidSquare_593;

import java.util.*;

/**
 * 593. Valid Square
 * https://leetcode.com/problems/valid-square/
 *
 * Given the coordinates of four points in 2D space, return whether the four
 * points could construct a square.
 *
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 *
 * Example:
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 *
 * Note:
 * All the input integers are in the range [-10000, 10000].
 * A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 * Input points have no order.
 */
public class Solution {
    // 1 ms, faster than 79.58%; 36.7 MB, less than 75.65%
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = new int[][] {p1, p2, p3, p4};
        Arrays.sort(p, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int d01 = dist(p[0], p[1]);
        int d02 = dist(p[0], p[2]);
        int d23 = dist(p[2], p[3]);
        int d13 = dist(p[1], p[3]);

        boolean sidesEqual = d01 == d02 && d02 == d23 && d23 == d13;
        if (!sidesEqual || d01 == 0) return false;

        int d03 = dist(p[0], p[3]);
        int d12 = dist(p[1], p[2]);
        return d03 != 0 && d03 == d12;
    }

    // brute force - check all permutations (4! = 24) and for each:
    //                      - check sides are equal
    //                      - check diagonals are equal
    // tc O(1), sc O(1), 3ms
    public boolean validSquare1(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = new int[][] {p1, p2, p3, p4};
        List<List<Integer>> allComb = new ArrayList<>();
        allCombinations(p, new ArrayList<>(), allComb);
        for (List<Integer> comb : allComb) {
            if (check(p[comb.get(0)], p[comb.get(1)], p[comb.get(2)], p[comb.get(3)])) {
                return true;
            }
        }
        return false;
    }

    private void allCombinations(int[][] p, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == 4) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < p.length; i++) {
            if (list.contains(i)) continue;
            list.add(i);
            allCombinations(p, list, res);
            list.remove(list.size() - 1);
        }
    }

    private boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d12 = dist(p1, p2);
        int d23 = dist(p2, p3);
        int d34 = dist(p3, p4);
        int d14 = dist(p1, p4);

        boolean sidesEqual = d12 == d23 && d23 == d34 && d34 == d14;
        if (!sidesEqual || d12 == 0) return false;

        int d24 = dist(p2, p4);
        int d13 = dist(p1, p3);
        return d24 != 0 && d24 == d13;
    }

    private int dist(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
