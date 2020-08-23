package binarySearch.RandomPointInNonOverlappingRectangles_497;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 497. Random Point in Non-overlapping Rectangles
 * https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
 *
 * Given a list of non-overlapping axis-aligned rectangles rects, write a function pick
 * which randomly and uniformily picks an integer point in the space covered by the rectangles.
 *
 * Note:
 * An integer point is a point that has integer coordinates.
 * A point on the perimeter of a rectangle is included in the space covered by the rectangles.
 * ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of
 * the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
 * length and width of each rectangle does not exceed 2000.
 * 1 <= rects.length <= 100
 * pick return a point as an array of integer coordinates [p_x, p_y]
 * pick is called at most 10000 times.
 *
 * Example 1:
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[[[1,1,5,5]]],[],[],[]]
 * Output:
 * [null,[4,1],[4,1],[3,3]]
 *
 * Example 2:
 * Input:
 * ["Solution","pick","pick","pick","pick","pick"]
 * [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
 * Output:
 * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
 *
 * Explanation of Input Syntax:
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has
 * one argument, the array of rectangles rects. pick has no arguments. Arguments are always wrapped
 * with a list, even if there aren't any.
 */
public class Solution {
    // 55 ms, faster than 97.26%; 45.8 MB, less than 86.02%
    private int sum;
    private List<Integer> list;
    private int[][] rects;
    private Random rnd = new Random();
    // tc O(n), where n - number of rectangles; sc o(n)
    public Solution(int[][] rects) {
        this.rects = rects;
        sum = 0;
        list = new ArrayList<>();
        for (int[] x : rects) {
            sum += (x[2] - x[0] + 1) * (x[3] - x[1] + 1);
            list.add(sum);
        }
    }

    // tc O(logn), sc O(1)
    public int[] pick() {
        int target = rnd.nextInt(sum);
        // let's find value the most right <= target
        int l = -1, r = list.size() - 1;
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            if (list.get(m) <= target) {
                l = m;
            } else {
                r = m;
            }
        }

        int[] x = rects[r];
        int width = x[2] - x[0] + 1;
        int height = x[3] - x[1] + 1;
        int base = list.get(r) - width * height;
        int x1 = x[0] + (target - base) % width;
        int y1 = x[1] + (target - base) / width;
        return new int[] {x1, y1};
    }
}
